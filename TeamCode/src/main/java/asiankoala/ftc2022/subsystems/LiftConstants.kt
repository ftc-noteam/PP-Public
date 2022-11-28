package asiankoala.ftc2022.subsystems

import com.acmerobotics.dashboard.config.Config

@Config
object LiftConstants {
    @JvmField var ticksPerUnit = 1.0
    @JvmField var homePos = 0.0
    @JvmField var groundPos = 0.0
    @JvmField var lowPos = 0.0
    @JvmField var medPos = 0.0
    @JvmField var highPos = 0.0
    @JvmField var kP = 0.0
    @JvmField var kI = 0.0
    @JvmField var kD = 0.0
    @JvmField var kS = 0.0
    @JvmField var kV = 0.0
    @JvmField var kA = 0.0
    @JvmField var kG = 0.0
    @JvmField var maxVel = 0.0
    @JvmField var maxAccel = 0.0
    @JvmField var disabledPosition = 0.0
    @JvmField var allowedPositionError = 1.0
    @JvmField var testPower = 0.5
}