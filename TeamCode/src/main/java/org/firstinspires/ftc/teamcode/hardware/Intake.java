package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.RobotHardwareMap;

public class Intake {

    RobotHardwareMap robotHardwareMap;

    private double speed;
    private char direction;
    LinearOpMode opMode;

    // finish the init method

    public Intake(RobotHardwareMap robotHardwareMap, LinearOpMode opMode) {
        this.opMode = opMode;
        this.robotHardwareMap = robotHardwareMap;
    }
    public void initialize(){
       robotHardwareMap.intakeMotorFront.setDirection(DcMotorSimple.Direction.REVERSE);
     }


  public void setSpeed (double speed_in) {
        speed = speed_in;
      robotHardwareMap.intakeMotorFront.setPower(speed);
      robotHardwareMap.intakeMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
public void Toggle () {
    if (speed > 0) {
        speed = 0;
    } else {
        speed = 0.7;
    }

    robotHardwareMap.intakeMotorFront.setPower(speed);
    robotHardwareMap.intakeMotorFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
}
}





