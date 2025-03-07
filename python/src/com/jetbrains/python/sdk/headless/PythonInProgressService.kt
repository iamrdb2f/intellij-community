// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.jetbrains.python.sdk.headless

import com.intellij.openapi.components.Service
import com.intellij.openapi.observable.AbstractInProgressService
import kotlinx.coroutines.CoroutineScope

@Service(Service.Level.PROJECT)
class PythonInProgressService(scope: CoroutineScope) : AbstractInProgressService(scope)