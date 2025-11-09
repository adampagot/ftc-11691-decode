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

    private boolean restartouttake;

    private long timeofrestartouttake;

    // finish the init method

    public Outtake(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
    }

    public void initialize() {
        robotHardwareMap.outtakeMotorBack1.setDirection(DcMotorSimple.Direction.REVERSE);
        robotHardwareMap.outtakeMotorBack2.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakerunning = false;
        speed = .412;
        robotHardwareMap.outtakeMotorBack1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robotHardwareMap.outtakeMotorBack2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void setSpeed(double speed_in) {
        speed = speed_in;
        if (speed >= 1) {
            speed = 1;}
        else if (speed <= .01) {
            speed = .01;
        }
    }

    public void ToggleOuttakeMotor() {
        if (outtakerunning) {
            outtakerunning = false;
        } else {
            restartouttake = true;
            timeofrestartouttake = System.currentTimeMillis();
        }

    }
    public void outtakeon() {
        if (!outtakerunning && !restartouttake) {// only start outtake if its not running
            restartouttake = true;
            timeofrestartouttake = System.currentTimeMillis();
        }
    }
    public void outtakeoff() {
        outtakerunning = false;
    }

    public void ControlMotorSpeed() {
        long currenttime;
        opMode.telemetry.addLine(String.format("outtakespeed %6.3f", speed));
        if (restartouttake) {
            currenttime = System.currentTimeMillis();
           if ((currenttime - timeofrestartouttake) > 500){
               this.StopCenterTransferServo();
               outtakerunning = true;
               restartouttake = false;
           }
           else {
               robotHardwareMap.CenterTransferServo.setPower(-1);
           }
        }
        if (outtakerunning) {
            robotHardwareMap.outtakeMotorBack1.setPower(speed);
            robotHardwareMap.outtakeMotorBack2.setPower(speed);
        } else {
            robotHardwareMap.outtakeMotorBack1.setPower(0);
            robotHardwareMap.outtakeMotorBack2.setPower(0);

        }

    }

    public void increasemotorspeed() {
        speed = speed + 0.005;
if (speed>=1)
{ speed = 1; }
    }

    public void decreasemotorspeed() {
        speed = speed - 0.005;
        if (speed < .05)
        {
            speed = 0.05;
        }
    }
    public void RunSideTransferServo () {
        robotHardwareMap.LeftTransferServo.setDirection(CRServo.Direction.FORWARD);
        robotHardwareMap.RightTransferServo.setDirection(CRServo.Direction.FORWARD);

        robotHardwareMap.LeftTransferServo.setPower(-1);
        robotHardwareMap.RightTransferServo.setPower(1);
    }

    public void StopSideTransferServo () {
        robotHardwareMap.LeftTransferServo.setPower(0);
        robotHardwareMap.RightTransferServo.setPower(0);
    }

    public void RunCenterTransferServer (){
        robotHardwareMap.CenterTransferServo.setDirection(CRServo.Direction.FORWARD);
        robotHardwareMap.CenterTransferServo.setPower(1);
    }

    public void StopCenterTransferServo () {
        robotHardwareMap.CenterTransferServo.setPower(0);
    }


    public double getspeed(){
        return speed;
    }

    public void blockingShoot(){
        //can we tell if the outtake is at speed?

        RunSideTransferServo();
        StopSideTransferServo();
        opMode.sleep(3000);
        RunSideTransferServo();
        StopCenterTransferServo();
    }
}




