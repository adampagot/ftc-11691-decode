package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

public class camera {
    RobotHardwareMap robotHardwareMap;


    LinearOpMode opMode;

    // finish the init method

    public camera(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
    }

    public double Robotallignwithgoal(double twistin) {
        double twistout = twistin;
        double powerFactor = 180; // long range value by default
        List<AprilTagDetection> currentDetections = robotHardwareMap.aprilTag.getDetections();

        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if ((detection.id == 20) || (detection.id == 24)) {
                    if ((detection.ftcPose.x <= 10) && (detection.ftcPose.x >= -10)) {
                        powerFactor = 90;
                    }
                    twistout= (detection.ftcPose.x / powerFactor) ;
                    //         = twistin;  if you want to conser input from the stick add twist in here
                    // value of 180 is rough estimate on the width of the camera at max distance it can pick up april tag(inches)
                }
            }

        }
   return twistout; }

}