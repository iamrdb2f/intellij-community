// "Add parameter to function 'called'" "true"
// WITH_STDLIB
// DISABLE-ERRORS
// WITH_NEW_INFERENCE

fun caller() {
    called(<caret>setOf(1, 2, 3))
}

fun called() {}
// FUS_QUICKFIX_NAME: org.jetbrains.kotlin.idea.quickfix.AddFunctionParametersFix