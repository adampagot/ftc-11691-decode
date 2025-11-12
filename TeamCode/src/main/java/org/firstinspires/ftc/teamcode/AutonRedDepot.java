package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.LynxModuleImuType;

@Autonomous(name = "Auton Red Depot", group = "Autons")
public class AutonRedDepot extends AutonBase {
    // Robot starts with back against center of blue depot

    double imuSpeed = 0.7;

    private void transferAndLaunchArtifacts() {}

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
        sleep (1000);
        transferAndLaunchArtifacts();
        intake.on();

        imuTurn(imuSpeed, -135);
        imuDrive(0.3,44,0);

        sleep(700);
        intake.off();
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed, -44, 0);
        imuTurn(imuSpeed, 135);

        transferAndLaunchArtifacts();
        intake.on();

        //go to get more
        imuTurn(imuSpeed,-45);
        imuDrive(imuSpeed,21,0);
        imuTurn(imuSpeed,-92);

        imuDrive(0.3,54,0);
        sleep (1000);// let the intake intake the artifacts
        intake.off();

        /* ran out of time so stop after intakeing 3 artifatics
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed,-54,0);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,-21,0);
        imuTurn(imuSpeed,-45);

        transferAndLaunchArtifacts();

        //drive outside launch line for rp
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,30,0);*/
    }
}