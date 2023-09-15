package app.revanced.patches.duolingo.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags

object UnlockSuperFingerprint : MethodFingerprint(
    accessFlags = AccessFlags.CONSTRUCTOR or AccessFlags.PUBLIC,

    customFingerprint = { methodDef, _ ->
        methodDef.definingClass == "Lcom/duolingo/user/q;" &&
        methodDef.parameters.size > 20
    }
)