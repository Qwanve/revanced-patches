package app.revanced.patches.duolingo.annotations

import app.revanced.patcher.annotation.Compatibility
import app.revanced.patcher.annotation.Package

@Compatibility([Package("com.duolingo", arrayOf("5.113.3"))])
@Target(AnnotationTarget.CLASS)
internal annotation class UnlockSuperCompatibility
