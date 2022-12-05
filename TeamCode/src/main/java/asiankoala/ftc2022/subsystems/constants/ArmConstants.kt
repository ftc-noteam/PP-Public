package asiankoala.ftc2022.subsystems.constants

import com.acmerobotics.dashboard.config.Config

@Config
object ArmConstants {
    @JvmField var kS = 0.0
    @JvmField var kV = 0.00001
    @JvmField var kA = 0.0000
    @JvmField var maxVel = 360.0
    @JvmField var maxAccel = 360.0

    @JvmField var ticksPerUnit = 2.0434
    @JvmField var kP = 0.014
    @JvmField var kI = 0.001
    @JvmField var kD = 0.0007
    @JvmField var kCos = 0.23
    @JvmField var allowedPositionError = 1.0


    @JvmField var home = -69.0 // thanks ritwik
    @JvmField var pickup = -66.0
    @JvmField var ground = 130.0
    @JvmField var low = 130.0
    @JvmField var med = 130.0
    @JvmField var high = 130.0
}