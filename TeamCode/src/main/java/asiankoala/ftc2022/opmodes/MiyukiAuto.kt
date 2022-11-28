package asiankoala.ftc2022.opmodes

import asiankoala.ftc2022.Miyuki
import asiankoala.ftc2022.commands.CmdChooser
import asiankoala.ftc2022.commands.sequence.DepositSequence
import asiankoala.ftc2022.commands.sequence.IntakeSequence
import asiankoala.ftc2022.commands.sequence.ReadySequence
import asiankoala.ftc2022.commands.subsystem.ClawCmds
import com.asiankoala.koawalib.command.KOpMode
import com.asiankoala.koawalib.command.commands.Cmd
import com.asiankoala.koawalib.command.commands.GVFCmd
import com.asiankoala.koawalib.command.commands.WaitUntilCmd
import com.asiankoala.koawalib.command.group.SequentialGroup
import com.asiankoala.koawalib.math.Pose
import com.asiankoala.koawalib.math.Vector
import com.asiankoala.koawalib.math.angleWrap
import com.asiankoala.koawalib.math.radians
import com.asiankoala.koawalib.path.DEFAULT_HEADING_CONTROLLER
import com.asiankoala.koawalib.path.FLIPPED_HEADING_CONTROLLER
import com.asiankoala.koawalib.path.HermitePath
import com.asiankoala.koawalib.path.Path
import com.asiankoala.koawalib.path.gvf.SimpleGVFController
import com.asiankoala.koawalib.util.Alliance
import com.asiankoala.koawalib.util.OpModeState

//open class MiyukiAuto(
//    alliance: Alliance,
//    close: Boolean,
//) : KOpMode() {
//    private val startPose = Pose(
//        Vector(-66.0, -36.0).choose(alliance, close),
//        close.choose(0.0, 180.0.radians)
//    )
//    private val miyuki by lazy { Miyuki(startPose) }
//    private val kN = 0.6
//    private val kOmega = 1.0 / 30.0.radians
//    private val kF = 4.0
//    private val kS = 1.0
//    private val epsilon = 1.0
//    private val thetaEpsilon = 5.0
//
//    private val initialPath = HermitePath(
//        FLIPPED_HEADING_CONTROLLER,
//        Pose(-66.0, -36.0, 0.0),
//        Pose(-3.0, -28.0, 30.0.radians)
//    ).choose(alliance, close)
//
//    private val intakePath = HermitePath(
//        DEFAULT_HEADING_CONTROLLER,
//        Pose(-3.0, -28.0, 210.0.radians),
//        Pose(-12.0, -66.0, 270.0.radians)
//    ).choose(alliance, close)
//
//    private val depositPath = HermitePath(
//        FLIPPED_HEADING_CONTROLLER,
//        Pose(-12.0, -66.0, 90.0.radians),
//        Pose(-3.0, -28.0, 30.0.radians)
//    ).choose(alliance, close)
//
//    private val initialReadyP = Pair(
//        ReadySequence(miyuki), Vector(-24.0, -36.0).choose(alliance, close)
//    )
//
//    private val intakeP = Pair(
//        IntakeSequence(miyuki.claw), Vector(-12.0, -43.0).choose(alliance, close)
//    )
//
//    private val readyP = Pair(
//        ReadySequence(miyuki), Vector(-12.0, -36.0).choose(alliance, close)
//    )
//
//    private val depositP = Pair(
//        DepositSequence(miyuki), Vector(-5.0, -30.0).choose(alliance, close)
//    )
//
//    private fun getGVFCmd(path: Path, vararg cmds: Pair<Cmd, Vector>) =
//        GVFCmd(miyuki.drive, SimpleGVFController(path, kN, kOmega, kF, kS, epsilon, thetaEpsilon), *cmds)
//
//    override fun mInit() {
//        +SequentialGroup(
//            ClawCmds.ClawGripCmd(miyuki.claw),
//            CmdChooser.homeCmd(miyuki),
//            WaitUntilCmd { opModeState == OpModeState.START },
//            getGVFCmd(initialPath, initialReadyP, depositP),
//            *List(5) {
//                listOf(
//                    getGVFCmd(intakePath, intakeP),
//                    getGVFCmd(depositPath, readyP, depositP)
//                )
//            }.flatten().toTypedArray()
//        )
//    }
//
//    companion object {
//        private fun <T> Boolean.choose(a: T, b: T) = if (this) a else b
//        private fun <T> T.cond(cond: Boolean, f: (T) -> T) = cond.choose(f.invoke(this), this)
//
//        private fun Vector.choose(alliance: Alliance, close: Boolean) =
//            this
//                .cond(alliance == Alliance.RED) { Vector(-x, y) }
//                .cond(close) { Vector(x, -y) }
//
//        private fun HermitePath.choose(alliance: Alliance, close: Boolean) =
//            this
//                .cond(alliance == Alliance.RED) {
//                    this.map(FLIPPED_HEADING_CONTROLLER) {
//                        Pose(
//                            -it.x,
//                            it.y,
//                            (180.0.radians - it.heading).angleWrap
//                        )
//                    }
//                }
//                .cond(close) {
//                    this.map(DEFAULT_HEADING_CONTROLLER) {
//                        Pose(
//                            it.x,
//                            -it.y,
//                            -it.heading
//                        )
//                    }
//                }
//    }
//}
