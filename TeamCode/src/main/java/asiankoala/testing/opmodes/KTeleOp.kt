package asiankoala.testing.opmodes

import com.asiankoala.koawalib.command.KOpMode
import com.asiankoala.koawalib.command.commands.InstantCmd
import com.asiankoala.koawalib.command.commands.MecanumCmd
import com.asiankoala.koawalib.logger.Logger
import com.asiankoala.koawalib.math.Pose
import com.asiankoala.koawalib.math.radians
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import asiankoala.testing.Robot
import asiankoala.testing.subsystems.Arm

@TeleOp
class KTeleOp : KOpMode() {
    private val robot by lazy { Robot(Pose(heading = 90.0.radians)) }

    override fun mInit() {
        robot.drive.setDefaultCommand(
            MecanumCmd(
                robot.drive,
                driver.leftStick.xInverted.yInverted,
                driver.rightStick,
                1.0,
                1.0,
                1.0,
                0.9,
                0.9,
                0.9
            )
        )

        driver.x.onPress(InstantCmd({ driver.rumbleBlips(3) }))
        driver.y.onPress(InstantCmd({ driver.rumble(2500) }))

        driver.a.onPress(InstantCmd({ robot.arm.motor.setPositionTarget(Arm.topPosition) }))
        driver.b.onPress(InstantCmd( { robot.arm.motor.setPositionTarget(Arm.homePosition) }))
    }

    override fun mLoop() {
        Logger.addTelemetryData("arm angle", robot.arm.motor.pos)
    }
}
