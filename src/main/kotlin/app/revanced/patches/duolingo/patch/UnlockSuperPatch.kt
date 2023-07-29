package app.revanced.patches.duolingo.patch

import app.revanced.extensions.toErrorResult
import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.duolingo.annotations.UnlockSuperCompatibility
import app.revanced.patches.duolingo.fingerprints.UnlockSuperFingerprint

@Patch
@Name("Unlock Super")
@Description("Unlocks Duolingo Super")
@UnlockSuperCompatibility
@Version("0.0.1")
class UnlockSuperPatch : BytecodePatch(
    listOf(
        UnlockSuperFingerprint
    )
) {
    override fun execute(context: BytecodeContext): PatchResult {
        UnlockSuperFingerprint.result?.let { result ->
                val index = result.scanResult.patternScanResult!!.endIndex
                result.mutableMethod.replaceInstruction(index, "const v1, true")
        } ?: return UnlockSuperFingerprint.toErrorResult()

        return PatchResultSuccess()
    }
}
