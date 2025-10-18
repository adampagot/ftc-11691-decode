package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.RobotControlMechanum;

@TeleOp
public class TeleOpTune extends LinearOpMode {
    @Override
    public void runOpMode() {

        RobotHardwareMap theHardwareMap = new RobotHardwareMap(this.hardwareMap, this);
        theHardwareMap.initialize();

        RobotControlMechanum robotDrive = new RobotControlMechanum(theHardwareMap, this);
        robotDrive.initialize();

        Intake intake = new Intake (theHardwareMap, this);
        intake.initialize();

        waitForStart();

        while (opModeIsActive()) {
            //put test code here
            intake.setSpeed(1.0);
        }

    }
}
