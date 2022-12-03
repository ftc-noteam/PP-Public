package asiankoala.ftc2022.subsystems

import com.asiankoala.koawalib.hardware.motor.KMotor
import com.asiankoala.koawalib.subsystem.Subsystem

class Lift(
    private val leadMotor: KMotor,
    private val bottomMotor: KMotor,
    private val leftMotor: KMotor
) : Subsystem() {
    fun setPos(pos: Double) {
//        leadMotor.setProfileTarget(pos)
        leadMotor.setPositionTarget(pos)
    }

    fun openLoop(power: Double) {
        leadMotor.power = power
        bottomMotor.power = power
        leftMotor.power = power
    }

    override fun periodic() {
        bottomMotor.power = leadMotor.power
        leftMotor.power = leadMotor.power
    }
}
