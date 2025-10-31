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
        List<AprilTagDetection> currentDetections = robotHardwareMap.aprilTag.getDetections();
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if ((detection.id == 20) || (detection.id == 24)) {
                    twistout = twistin + (detection.ftcPose.x / 18);
                    //value of 18 is rough estimate on the width of the camera at max distance it can pick up april tag
                }
            }

        }
   return twistout; }

}