package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "AutonTune", group = "Autons")
public class AutonTune extends AutonBase {
    double testDriveSpeed = 0.5;
    int briefPause = 1000;

    @Override
    public void runOpMode(){

        initialize();
        Camera.goalcolor(0); // 0 is blue, 1 is red
        while (opModeInInit()) {
        }

        waitForStart();
        Camera.start();
        Camera.loop();
        Camera.loop();
        aprilTagOutakeSpeedAdjustAndAlignment();
/*
        testForwardAndBack();
        sleep(briefPause);
        testTurn(0.5, 90);
        sleep(briefPause);
        testSquare();
*/
    //    testIntake();
        // Encoder strafe does NOT use IMU and is too inaccurate to use when wheels slip
        //encoderStrafe(0.5 ,-80,25000);

    }

    public void testForwardAndBack() {
        imuDrive(testDriveSpeed, 30, 0);
        sleep(briefPause);
        imuDrive(testDriveSpeed, -30, 0);
    }

    public void testTurn(double testTurnspeed, double testDegrees) {
        imuTurn(testTurnspeed, testDegrees);
        sleep(briefPause);
        imuTurn(testTurnspeed, -testDegrees);
    }

    public void testSquare() {
        imuDrive(testDriveSpeed, 40, 0);
        sleep(briefPause);
        imuTurn(testDriveSpeed, 90);
        imuDrive(testDriveSpeed, 40, 0);
        sleep(briefPause);
        imuTurn(testDriveSpeed, 90);
        imuDrive(testDriveSpeed, 40, 0);
        sleep(briefPause);
        imuTurn(testDriveSpeed, 90);
        imuDrive(testDriveSpeed, 40, 0);
        sleep(briefPause);
        imuTurn(testDriveSpeed, 90);
    }

    public void testIntake() {
        intake.on();
        // drive forward and pick up three artifacts
        imuDrive(testDriveSpeed,37,0);

        sleep(briefPause);

        // return to original position
        imuDrive(testDriveSpeed,-37,0);
    }
}
