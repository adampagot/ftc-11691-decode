package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Outtake {
    RobotHardwareMap robotHardwareMap;

    private double speed;

    private boolean outtakerunning;
    LinearOpMode opMode;

    // finish the init method

    public Outtake(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
    }

    public void initialize() {
        robotHardwareMap.outtakeMotorBack1.setDirection(DcMotorSimple.Direction.FORWARD);
        robotHardwareMap.outtakeMotorBack2.setDirection(DcMotorSimple.Direction.REVERSE);
        outtakerunning = false;
        speed = .5;
        robotHardwareMap.outtakeMotorBack1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robotHardwareMap.outtakeMotorBack2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void setSpeed(double speed_in) {
        speed = speed_in;
    }

    public void ToggleOuttakeMotor() {
        if (outtakerunning) {
            outtakerunning = false;
        } else {
            outtakerunning = true;
        }

    }

    public void ControlMotorSpeed() {
        opMode.telemetry.addLine(String.format("outtakespeed %6.1f", speed));
        if (outtakerunning) {
            robotHardwareMap.outtakeMotorBack1.setPower(speed);
            robotHardwareMap.outtakeMotorBack2.setPower(speed);
        } else {
            robotHardwareMap.outtakeMotorBack1.setPower(0);
            robotHardwareMap.outtakeMotorBack2.setPower(0);

        }

    }

    public void increasemotorspeed() {
        speed = speed + 0.05;
if (speed>=1)
{ speed = 1; }
    }

    public void decreasemotorspeed() {
        speed = speed - 0.05;
        if (speed < .05)
        {
            speed = 0.05;
        }
    }
        public void RunTransferServo () {
        robotHardwareMap.LeftTransferServo.setDirection(CRServo.Direction.FORWARD);
            robotHardwareMap.RightTransferServo.setDirection(CRServo.Direction.REVERSE);
            robotHardwareMap.LeftTransferServo.setPower(-1);
            robotHardwareMap.RightTransferServo.setPower(1);

        }

        public void StopTransferServo () {
        robotHardwareMap.LeftTransferServo.setPower(0);
            robotHardwareMap.RightTransferServo.setPower(0);
        }

}




