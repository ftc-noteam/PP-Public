package asiankoala.ftc2022.sunmi.subsystems

import asiankoala.ftc2022.sunmi.subsystems.constants.ClawConstants
import com.asiankoala.koawalib.hardware.servo.KServo
import com.asiankoala.koawalib.subsystem.KSubsystem

class Claw : KSubsystem() {
    private val servo = KServo("claw").startAt(ClawConstants.close)

    fun setPos(pos: Double) {
        servo.position = pos
    }
}
