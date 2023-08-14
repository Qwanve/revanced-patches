package app.revanced.patches.duolingo.annotations

import app.revanced.patcher.annotation.Compatibility
import app.revanced.patcher.annotation.Package

@Compatibility([Package("com.duolingo", arrayOf("5.113.3", "5.114.4", "5.115.4"))])
@Target(AnnotationTarget.CLASS)
internal annotation class UnlockSuperCompatibility
