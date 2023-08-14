package app.revanced.patches.duolingo.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

object UnlockSuperFingerprint : MethodFingerprint(
    accessFlags = AccessFlags.CONSTRUCTOR or AccessFlags.PUBLIC,
    opcodes = listOf(
        Opcode.IPUT_OBJECT,
        Opcode.IPUT_OBJECT,
        Opcode.IPUT_OBJECT,
        Opcode.MOVE_OBJECT_FROM16,
        Opcode.IPUT_OBJECT,
        Opcode.MOVE_FROM16,
        Opcode.IPUT_BOOLEAN,
        Opcode.MOVE_FROM16,
        Opcode.IPUT_BOOLEAN,
        Opcode.MOVE_FROM16
    ),
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass == "Lcom/duolingo/user/q;"
    }
)