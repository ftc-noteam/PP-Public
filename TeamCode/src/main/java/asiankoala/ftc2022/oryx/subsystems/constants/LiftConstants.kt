package asiankoala.ftc2022.oryx.subsystems.constants

import com.acmerobotics.dashboard.config.Config

@Config
object LiftConstants {
    @JvmField var ticksPerUnit = 305.0 / 10.0
    @JvmField var kS = 0.02
    @JvmField var kV = 0.007
    @JvmField var kA = 0.0
    @JvmField var maxVel = 200.0
    @JvmField var maxAccel = 100.0
    @JvmField var kP = 0.65
    @JvmField var kI = 0.0
    @JvmField var kD = 0.005
    @JvmField var kG = 0.14
    @JvmField var home = 0.0
    @JvmField var ready = 1.0
    @JvmField var ground = ready
    @JvmField var low = ready
    @JvmField var med = ready
    @JvmField var high = 9.5
    @JvmField var disabledPosition = home
    @JvmField var allowedPositionError = 0.2
    @JvmField var coneDelta = 4.0
    val stackPositions = List(5) { ready + coneDelta * it }
    val stackSafeRaiseDelta = 6.0
}