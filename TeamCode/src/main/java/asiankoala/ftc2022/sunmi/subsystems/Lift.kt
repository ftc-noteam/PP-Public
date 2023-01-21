package asiankoala.ftc2022.sunmi.subsystems

import asiankoala.ftc2022.sunmi.subsystems.constants.LiftConstants
import com.asiankoala.koawalib.control.controller.PIDGains
import com.asiankoala.koawalib.control.motor.FFGains
import com.asiankoala.koawalib.control.profile.MotionConstraints
import com.asiankoala.koawalib.hardware.motor.EncoderFactory
import com.asiankoala.koawalib.hardware.motor.KMotor
import com.asiankoala.koawalib.hardware.motor.MotorFactory
import com.asiankoala.koawalib.subsystem.Subsystem

class Lift(bl: KMotor) : Subsystem() {
    private val lt = MotorFactory("lt")
        .pairEncoder(
            bl,
            EncoderFactory(367.0 / 12.0).zero()
        )
        .withMotionProfileControl(
            PIDGains(
                LiftConstants.kP,
                0.0,
                LiftConstants.kD
            ),
            FFGains(kG = LiftConstants.kG),
            MotionConstraints(LiftConstants.vel, LiftConstants.accel),
            0.5
        )
        .float
        .build()
    private val lb = MotorFactory("lb").float.reverse.build()
//    private val rt = MotorFactory("rt").brake.reverse.build()
    private val rb = MotorFactory("rb").float.build()
    private val chainedMotors = listOf(lb, rb)

    val pos get() = lt.pos
    val vel get() = lt.vel

    fun setTarget(pos: Double) {
        lt.setProfileTarget(pos)
    }

    fun setPower() {
        lt.power = 0.8
    }

    fun bruh() {
        lt.power = 0.0
    }

    override fun periodic() {
        chainedMotors.forEach { it.power = lt.power }
    }
}