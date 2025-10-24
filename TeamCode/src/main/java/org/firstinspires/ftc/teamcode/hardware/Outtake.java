package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Outtake
{
    RobotHardwareMap robotHardwareMap;

    private double speed;

    LinearOpMode opMode;

    // finish the init method

    public Outtake(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
    }
    public void initialize(){
        robotHardwareMap.outtakeMotorBack1.setDirection(DcMotorSimple.Direction.FORWARD);
        robotHardwareMap.outtakeMotorBack2.setDirection(DcMotorSimple.Direction.REVERSE);
     }


  public void setSpeed (double speed_in) {
        speed = speed_in;
      robotHardwareMap.outtakeMotorBack1.setPower(speed);
      robotHardwareMap.outtakeMotorBack2.setPower(speed);

      robotHardwareMap.outtakeMotorBack1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      robotHardwareMap.outtakeMotorBack2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
public void ToggleOuttakeMotor () {
    if (speed > 0) {
        speed = 0;
    } else {
        speed = 0.3;
    }

    robotHardwareMap.outtakeMotorBack1.setPower(speed);
    robotHardwareMap.outtakeMotorBack2.setPower(speed);

    robotHardwareMap.outtakeMotorBack1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    robotHardwareMap.outtakeMotorBack2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
}

        public void RunTransferServo () {
        robotHardwareMap.LeftTransferServo.setDirection(CRServo.Direction.FORWARD);
            robotHardwareMap.RightTransferServo.setDirection(CRServo.Direction.REVERSE);
            robotHardwareMap.LeftTransferServo.setPower(-1);
            robotHardwareMap.RightTransferServo.setPower(1);

        }

}





