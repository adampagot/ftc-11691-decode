package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.RobotHardwareMap;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

public class camera {
    RobotHardwareMap robotHardwareMap;


    LinearOpMode opMode;

    private Limelight3A limelight;
    private int goalColor;// 0 is 20 blue , 1 is 24 red
    private LLResult llResult ;

    // finish the init method

    public camera(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
        limelight = robotHardwareMap.baseHMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0); // 0 is 20, 1 is 24
        goalColor = 0;
    }

    public void start(){
        limelight.start();
    }

    public void loop(){
        YawPitchRollAngles orentation = robotHardwareMap.chImu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orentation.getYaw());
        llResult = limelight.getLatestResult();

        if (goalColor == 0) {
            opMode.telemetry.addLine("Goal Color Blue");
        }
        else {
            opMode.telemetry.addLine("Goal Color Red");
        }

        if ((llResult != null) && llResult.isValid()){
            Pose3D botpos = llResult.getBotpose_MT2();
            opMode.telemetry.addLine(String.format("XYA %6.1f %6.1f  %6.3f ", llResult.getTx(),  llResult.getTy(), llResult.getTa()));
            opMode.telemetry.addData("BotPos", botpos.toString());
            opMode.telemetry.addData("Yaw", botpos.getOrientation().getYaw());

        }
    }

    public double Robotallignwithgoal(double twistin) {
        double twistout = twistin;
        double powerFactor = 90; // long range value by default

        if ((llResult != null) && llResult.isValid()){
            if ((llResult.getTx() <= 10) && (llResult.getTx() >= -10)) {
                powerFactor = 35;
            }
            twistout= (llResult.getTx() / powerFactor) ;
            //         = twistin;  if you want to conser input from the stick add twist in here
            // value of 180 is rough estimate on the width of the camera at max distance it can pick up april tag(inches)

        }
        return twistout;
    }

    public double outtakespeedfordistance(double powerin) {
        List<AprilTagDetection> currentDetections = robotHardwareMap.aprilTag.getDetections();
        double power = powerin;
        double y2 = 124;
        double y1 = 50;
        double p2 = 0.45;
        double p1 = 0.10;
        double m = (p2 - p1) / (y2 - y1);
        double b = (p2 - (m * y2));
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if ((detection.id == 20) || (detection.id == 24)) {
                    power= (m*detection.ftcPose.y) + b;

                }
            }

        }
        return power;
    }
}

    public void goalcolor (int goalColorIn) {
        goalColor = goalColorIn;
        limelight.pipelineSwitch(goalColor); // 0 is 20 blue, 1 is 24 red


    }

}

