package asiankoala.testing.opmodes

import com.asiankoala.koawalib.command.KOpMode
import com.asiankoala.koawalib.command.commands.InstantCmd
import com.asiankoala.koawalib.command.commands.MecanumCmd
import com.asiankoala.koawalib.logger.Logger
import com.asiankoala.koawalib.math.Pose
import com.asiankoala.koawalib.math.radians
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import asiankoala.testing.Robot

@TeleOp
class KTeleOp : KOpMode() {
    private val robot by lazy { Robot(Pose(heading = 90.0.radians)) }

    override fun mInit() {
        robot.drive.setDefaultCommand(
            MecanumCmd(
                robot.drive,
                driver.leftStick.xInverted.yInverted,
                driver.rightStick,
                1.3,
                1.3,
                1.3,
                0.9,
                0.9,
                0.9
            )
        )

        driver.x.onPress(InstantCmd({ driver.rumbleBlips(3) }))
        driver.y.onPress(InstantCmd({ driver.rumble(2500) }))
    }

    override fun mLoop() {
        Logger.addTelemetryData("arm pos", robot.hardware.arm.pos)
    }
}
