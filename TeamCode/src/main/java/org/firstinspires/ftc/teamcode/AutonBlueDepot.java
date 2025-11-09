package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.LynxModuleImuType;

@Autonomous(name = "Auton Blue Depot", group = "Autons")
public class AutonBlueDepot extends AutonBase {

    double imuSpeed = .7;

    @Override
    public void runOpMode() {
        initialize();
        Camera.goalcolor(0); // 0 is blue, 1 is red

        waitForStart();
        Camera.start();
        Camera.loop();

        outtake.outtakeon();
        //get angle on goal
        imuDrive(imuSpeed,53,0);

        //score preloaded artifacts
        aprilTagOutakeSpeedAdjustAndAlignment();
        outtake.blockingShoot();

        outtake.outtakeoff();
        intake.on();

        imuTurn(imuSpeed, 135);
        imuDrive(imuSpeed,37,0);

        // Turn on intake
        sleep(500);
        //turn off intake
        sleep(500);

        //go to score
        imuDrive(imuSpeed, -37, 0);
        imuTurn(imuSpeed, -135);

        //shoot 3 artifacts
        sleep(3000);

        //go to get more
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,21,0);
        imuTurn(imuSpeed,90);

        //turn on intake
        imuDrive(imuSpeed,37,0);
        sleep(1000);
        //turn off intake

        //go to score
        imuDrive(imuSpeed,-37,0);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,-21,0);
        imuTurn(imuSpeed,-45);

        //shoot artifacts
        sleep(3000);

        //drive outside launch line for rp
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,30,0);
    }
}


