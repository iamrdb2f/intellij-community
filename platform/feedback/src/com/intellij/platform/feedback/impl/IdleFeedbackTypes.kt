// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.feedback.impl

import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.util.NlsSafe
import com.intellij.platform.feedback.aqua.bundle.AquaFeedbackBundle
import com.intellij.platform.feedback.aqua.dialog.AquaNewUserFeedbackDialog
import com.intellij.platform.feedback.aqua.dialog.AquaOldUserFeedbackDialog
import com.intellij.platform.feedback.aqua.state.AquaNewUserFeedbackService
import com.intellij.platform.feedback.aqua.state.AquaNewUserInfoState
import com.intellij.platform.feedback.aqua.state.AquaOldUserFeedbackService
import com.intellij.platform.feedback.aqua.state.AquaOldUserInfoState
import com.intellij.platform.feedback.impl.bundle.CommonFeedbackBundle
import com.intellij.platform.feedback.impl.notification.RequestFeedbackNotification
import com.intellij.platform.feedback.impl.state.DontShowAgainFeedbackService.Companion.dontShowFeedbackInCurrentVersion
import com.intellij.platform.feedback.impl.statistics.FeedbackNotificationCountCollector.Companion.logDisableNotificationActionInvoked
import com.intellij.platform.feedback.impl.statistics.FeedbackNotificationCountCollector.Companion.logRequestNotificationShown
import com.intellij.platform.feedback.impl.statistics.FeedbackNotificationCountCollector.Companion.logRespondNotificationActionInvoked
import com.intellij.platform.feedback.kafka.bundle.KafkaFeedbackBundle
import com.intellij.platform.feedback.kafka.dialog.KafkaConsumerFeedbackDialog
import com.intellij.platform.feedback.kafka.dialog.KafkaProducerFeedbackDialog
import com.intellij.platform.feedback.kafka.state.KafkaConsumerProducerFeedbackService
import com.intellij.platform.feedback.kafka.state.KafkaConsumerProducerInfoState
import com.intellij.util.PlatformUtils
import kotlinx.datetime.*
import java.time.Duration
import java.time.LocalDateTime

enum class IdleFeedbackTypes {
  AQUA_NEW_USER_FEEDBACK {
    override val fusFeedbackId: String = "aqua_new_user_feedback"
    override val suitableIdeVersion: String = "" // Not suitable for Aqua, because it is in the permanent Preview version
    private val lastDayCollectFeedback = LocalDate(2024, 2, 29)
    private val maxNumberNotificationShowed = 2

    override fun isSuitable(): Boolean {
      val state = AquaNewUserFeedbackService.getInstance().state

      return checkIdeIsSuitable() &&
             checkIsNoDeadline() &&
             isAnyProjectOpenNow() &&
             isUserTypedInEditor(state) &&
             checkFeedbackNotSent(state) &&
             checkNotificationNumberNotExceeded(state)
    }

    override fun createNotification(forTest: Boolean): Notification {
      return RequestFeedbackNotification(
        "Feedback In IDE",
        AquaFeedbackBundle.message("new.user.notification.request.feedback.title"),
        AquaFeedbackBundle.message("new.user.notification.request.feedback.content"))
    }

    override fun createFeedbackDialog(project: Project?, forTest: Boolean): DialogWrapper {
      return AquaNewUserFeedbackDialog(project, forTest)
    }

    override fun updateStateAfterNotificationShowed() {
      AquaNewUserFeedbackService.getInstance().state.numberNotificationShowed += 1
    }

    override fun updateStateAfterDialogClosedOk() {
      AquaNewUserFeedbackService.getInstance().state.feedbackSent = true
    }

    private fun checkIdeIsSuitable(): Boolean {
      return PlatformUtils.isAqua()
    }

    private fun isAnyProjectOpenNow(): Boolean {
      return ProjectManager.getInstance().openProjects.count {
        !it.isDisposed
      } > 0
    }

    private fun isUserTypedInEditor(state: AquaNewUserInfoState): Boolean {
      return state.userTypedInEditor
    }

    private fun checkIsNoDeadline(): Boolean {
      return Clock.System.todayIn(TimeZone.currentSystemDefault()) < lastDayCollectFeedback
    }

    private fun checkFeedbackNotSent(state: AquaNewUserInfoState): Boolean {
      return !state.feedbackSent
    }

    private fun checkNotificationNumberNotExceeded(state: AquaNewUserInfoState): Boolean {
      return state.numberNotificationShowed < maxNumberNotificationShowed
    }

  },
  AQUA_OLD_USER_FEEDBACK {
    override val fusFeedbackId: String = "aqua_old_user_feedback"
    override val suitableIdeVersion: String = "" // Not suitable for Aqua, because it is in the permanent Preview version
    private val lastDayCollectFeedback = LocalDate(2024, 2, 29)
    private val maxNumberNotificationShowed = 2
    private val elapsedMinNumberDaysFromFirstRun = 5

    override fun isSuitable(): Boolean {
      val state = AquaOldUserFeedbackService.getInstance().state

      return checkIdeIsSuitable() &&
             checkIsNoDeadline() &&
             isAnyProjectOpenNow() &&
             isUserTypedInEditor(state) &&
             isUsageTimeEnough(state) &&
             checkFeedbackNotSent(state) &&
             checkNotificationNumberNotExceeded(state)
    }

    override fun createNotification(forTest: Boolean): Notification {
      return RequestFeedbackNotification(
        "Feedback In IDE",
        AquaFeedbackBundle.message("old.user.notification.request.feedback.title"),
        AquaFeedbackBundle.message("old.user.notification.request.feedback.content"))
    }

    override fun createFeedbackDialog(project: Project?, forTest: Boolean): DialogWrapper {
      return AquaOldUserFeedbackDialog(project, forTest)
    }

    override fun updateStateAfterNotificationShowed() {
      AquaOldUserFeedbackService.getInstance().state.numberNotificationShowed += 1
    }

    override fun updateStateAfterDialogClosedOk() {
      AquaOldUserFeedbackService.getInstance().state.feedbackSent = true
    }

    private fun checkIdeIsSuitable(): Boolean {
      return PlatformUtils.isAqua()
    }

    private fun checkIsNoDeadline(): Boolean {
      return Clock.System.todayIn(TimeZone.currentSystemDefault()) < lastDayCollectFeedback
    }

    private fun isAnyProjectOpenNow(): Boolean {
      return ProjectManager.getInstance().openProjects.count {
        !it.isDisposed
      } > 0
    }

    private fun isUserTypedInEditor(state: AquaOldUserInfoState): Boolean {
      return state.userTypedInEditor
    }

    private fun isUsageTimeEnough(state: AquaOldUserInfoState): Boolean {
      val firstUsageTime = state.firstUsageTime
      if (firstUsageTime == null) {
        return false
      }
      return Duration.between(firstUsageTime.toJavaLocalDateTime(), LocalDateTime.now()).toDays() >= elapsedMinNumberDaysFromFirstRun
    }

    private fun checkFeedbackNotSent(state: AquaOldUserInfoState): Boolean {
      return !state.feedbackSent
    }

    private fun checkNotificationNumberNotExceeded(state: AquaOldUserInfoState): Boolean {
      return state.numberNotificationShowed < maxNumberNotificationShowed
    }
  },
  KAFKA_CONSUMER_FEEDBACK {
    override val fusFeedbackId: String = "kafka_consumer_feedback"
    override val suitableIdeVersion: String = "" // Not suitable for Aqua, because it is in the permanent Preview version
    private val maxNumberNotificationShowed = 1

    override fun isSuitable(): Boolean {
      val state = KafkaConsumerProducerFeedbackService.getInstance().state

      return isAnyProjectOpenNow() &&
             isEditorOpened(state) &&
             checkFeedbackNotSent(state) &&
             checkNotificationNumberNotExceeded(state)
    }

    override fun createNotification(forTest: Boolean): Notification {
      return RequestFeedbackNotification(
        "Feedback In IDE",
        KafkaFeedbackBundle.message("notification.request.feedback.title"),
        KafkaFeedbackBundle.message("notification.request.feedback.content"))
    }

    override fun createFeedbackDialog(project: Project?, forTest: Boolean): DialogWrapper {
      return KafkaConsumerFeedbackDialog(project, forTest)
    }

    override fun updateStateAfterNotificationShowed() {
      KafkaConsumerProducerFeedbackService.getInstance().state.numberNotificationShowed += 1
    }

    override fun updateStateAfterDialogClosedOk() {
      KafkaConsumerProducerFeedbackService.getInstance().state.feedbackSent = true
    }

    private fun isAnyProjectOpenNow(): Boolean {
      return ProjectManager.getInstance().openProjects.count {
        !it.isDisposed
      } > 0
    }

    private fun isEditorOpened(state: KafkaConsumerProducerInfoState): Boolean {
      return state.consumerDialogIsOpened
    }

    private fun checkFeedbackNotSent(state: KafkaConsumerProducerInfoState): Boolean {
      return !state.feedbackSent
    }

    private fun checkNotificationNumberNotExceeded(state: KafkaConsumerProducerInfoState): Boolean {
      return state.numberNotificationShowed < maxNumberNotificationShowed
    }
  },
  KAFKA_PRODUCER_FEEDBACK {
    override val fusFeedbackId: String = "kafka_producer_feedback"
    override val suitableIdeVersion: String = "" // Not suitable for Aqua, because it is in the permanent Preview version
    private val maxNumberNotificationShowed = 1

    override fun isSuitable(): Boolean {
      val state = KafkaConsumerProducerFeedbackService.getInstance().state

      return isAnyProjectOpenNow() &&
             isEditorOpened(state) &&
             checkFeedbackNotSent(state) &&
             checkNotificationNumberNotExceeded(state)
    }

    override fun createNotification(forTest: Boolean): Notification {
      return RequestFeedbackNotification(
        "Feedback In IDE",
        KafkaFeedbackBundle.message("notification.request.feedback.title"),
        KafkaFeedbackBundle.message("notification.request.feedback.content"))
    }

    override fun createFeedbackDialog(project: Project?, forTest: Boolean): DialogWrapper {
      return KafkaProducerFeedbackDialog(project, forTest)
    }

    override fun updateStateAfterNotificationShowed() {
      KafkaConsumerProducerFeedbackService.getInstance().state.numberNotificationShowed += 1
    }

    override fun updateStateAfterDialogClosedOk() {
      KafkaConsumerProducerFeedbackService.getInstance().state.feedbackSent = true
    }

    private fun isAnyProjectOpenNow(): Boolean {
      return ProjectManager.getInstance().openProjects.count {
        !it.isDisposed
      } > 0
    }

    private fun isEditorOpened(state: KafkaConsumerProducerInfoState): Boolean {
      return state.producerDialogIsOpened
    }

    private fun checkFeedbackNotSent(state: KafkaConsumerProducerInfoState): Boolean {
      return !state.feedbackSent
    }

    private fun checkNotificationNumberNotExceeded(state: KafkaConsumerProducerInfoState): Boolean {
      return state.numberNotificationShowed < maxNumberNotificationShowed
    }
  };

  protected abstract val fusFeedbackId: String

  protected abstract val suitableIdeVersion: String

  abstract fun isSuitable(): Boolean

  protected fun isIdeEAP(): Boolean {
    return ApplicationInfo.getInstance().isEAP
  }

  protected fun checkIdeVersionIsSuitable(): Boolean {
    return suitableIdeVersion == ApplicationInfo.getInstance().shortVersion
  }

  protected abstract fun createNotification(forTest: Boolean): Notification

  protected abstract fun createFeedbackDialog(project: Project?, forTest: Boolean): DialogWrapper

  protected abstract fun updateStateAfterNotificationShowed()

  protected abstract fun updateStateAfterDialogClosedOk()

  @NlsSafe
  protected open fun getGiveFeedbackNotificationLabel(): String {
    return CommonFeedbackBundle.message("notification.request.feedback.action.respond.text")
  }

  @NlsSafe
  protected open fun getCancelFeedbackNotificationLabel(): String {
    return CommonFeedbackBundle.message("notification.request.feedback.action.dont.show.text")
  }

  protected open fun getNotificationOnCancelAction(project: Project?): () -> Unit {
    return {}
  }

  fun showNotification(project: Project?, forTest: Boolean = false) {
    val notification = createNotification(forTest)
    notification.addAction(
      NotificationAction.createSimpleExpiring(getGiveFeedbackNotificationLabel()) {
        if (!forTest) {
          logRespondNotificationActionInvoked(this)
        }
        val dialog = createFeedbackDialog(project, forTest)
        val isOk = dialog.showAndGet()
        if (isOk) {
          updateStateAfterDialogClosedOk()
        }
      }
    )
    notification.addAction(
      NotificationAction.createSimpleExpiring(getCancelFeedbackNotificationLabel()) {
        if (!forTest) {
          dontShowFeedbackInCurrentVersion()
          logDisableNotificationActionInvoked(this)
        }
        getNotificationOnCancelAction(project)()
      }
    )
    notification.notify(project)
    if (!forTest) {
      logRequestNotificationShown(this)
      updateStateAfterNotificationShowed()
    }
  }
}