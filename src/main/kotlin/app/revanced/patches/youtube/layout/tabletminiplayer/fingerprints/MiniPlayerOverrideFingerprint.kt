package app.revanced.patches.youtube.layout.tabletminiplayer.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

object MiniPlayerOverrideFingerprint : MethodFingerprint(
    "Z", AccessFlags.STATIC or AccessFlags.PUBLIC,
    listOf("Landroid/content/Context;"),
    opcodes = listOf(
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT,
        Opcode.CONST_4,
        Opcode.IF_EQ,
        Opcode.CONST_4,
        Opcode.IF_EQ,
        Opcode.CONST_4, // override this value
        Opcode.RETURN,
        Opcode.CONST_4, // override this value
        Opcode.RETURN
    ),
)