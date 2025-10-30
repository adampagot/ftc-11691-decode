package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

/***
 *
 * robot hardware map
 * Dragon$11691
 */
public class RobotHardwareMap {

    //0 - FL
    //1 - FR
    //2 - RL
    //3 - RR
    private LinearOpMode opMode = null;
    public HardwareMap baseHMap;

    public VoltageSensor controlHubBatteryVoltage;
    //public VoltageSensor expansionHubBatteryVoltage;

    public LynxModule controlHub;
    public LynxModule expansionHub;

    public DcMotorEx backLeftMotor;
    public DcMotorEx backRightMotor;
    public DcMotorEx frontLeftMotor;
    public DcMotorEx frontRightMotor;
    public DcMotorEx intakeMotorFront;
    public DcMotorEx outtakeMotorBack1;
    public DcMotorEx outtakeMotorBack2;
    public DcMotorEx clawRotator;
    public DcMotorEx armMotor;
 //   public DcMotorEx lifterMotor;
    public DigitalChannel LED1Green;
    public DigitalChannel LED1Red;
    public DigitalChannel LED2Green;
    public DigitalChannel LED2Red;

    public CRServo LeftTransferServo;
    public CRServo RightTransferServo;



    public IMU chImu;

    private final int baseResolution_x = 320;
    private final int baseResolution_y = 240;
    private AprilTagProcessor aprilTag;

    /**
     * The variable to store our instance of the vision portal.
     */
    private VisionPortal visionPortal;

    boolean controlHubBatteryVoltageEnabled = true;
    boolean expansionHubBatteryVoltageEnabled = true;

    public RobotHardwareMap(HardwareMap baseHMap, LinearOpMode opmode) {

        this.opMode = opmode;
        this.baseHMap = baseHMap;
    }

    public void initialize(){

        opMode.telemetry.addData("Status", "detecting...");

        controlHubBatteryVoltage = baseHMap.get(VoltageSensor.class, "Control Hub");
        //expansionHubBatteryVoltage = baseHMap.get(VoltageSensor.class, "Expansion Hub 2");
        controlHub = baseHMap.get(LynxModule.class, "Control Hub");
        //expansionHub = baseHMap.get(LynxModule.class, "Expansion Hub 2");

        //dc motor vs dc motor ex?
        backLeftMotor = baseHMap.get(DcMotorEx.class, "RL");
        backRightMotor = baseHMap.get(DcMotorEx.class, "RR");
        frontLeftMotor = baseHMap.get(DcMotorEx.class, "FL");
        frontRightMotor = baseHMap.get(DcMotorEx.class, "FR");
        intakeMotorFront = baseHMap.get(DcMotorEx.class,"IF");
        outtakeMotorBack1 = baseHMap.get(DcMotorEx.class,"BRO");
        outtakeMotorBack2 = baseHMap.get(DcMotorEx.class,"BLO");
//        lifterMotor = baseHMap.get(DcMotorEx.class, "Lifter");
        LeftTransferServo = baseHMap.get(CRServo.class,"LTS");
        RightTransferServo = baseHMap.get(CRServo.class,"RTS");

        //Initializes the IMU
        chImu = baseHMap.get(IMU.class, "chImu");

        IMU.Parameters myIMUParamaters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                        RevHubOrientationOnRobot.UsbFacingDirection.LEFT
                )
        );
        chImu.initialize(myIMUParamaters);

        opMode.telemetry.addData("Status", "done");
        opMode.telemetry.update();

    }
    public void initAprilTag() {

        // Create the AprilTag processor the easy way.
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        // Create the vision portal the easy way.

            visionPortal = VisionPortal.easyCreateWithDefaults(
                    baseHMap.get(WebcamName.class, "Webcam 1"), aprilTag);



    }   // end method initAprilTag()

    public void telemetryAprilTag() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        opMode.telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                opMode.telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                opMode.telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                opMode.telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                opMode.telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                opMode.telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                opMode.telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }   // end for() loop

        // Add "key" information to telemetry
        opMode.telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        opMode.telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        opMode.telemetry.addLine("RBE = Range, Bearing & Elevation");
    //    opMode.telemetry.update();

    }   // end method telemetryAprilTag()
}
