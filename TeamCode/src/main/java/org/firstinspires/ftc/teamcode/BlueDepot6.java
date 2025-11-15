package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Blue Depot 6", group = "Autons")
public class BlueDepot6 extends AutonBase {
    // Robot starts with back against center of blue depot

    double imuSpeed = 0.7;

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
        transferAndLaunchArtifacts();
        intake.on();

        imuTurn(imuSpeed, 135);
        imuDrive(0.3,44,0);

        sleep(700);
        intake.off();
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed, -44, 0);
        imuTurn(imuSpeed, -135);

        transferAndLaunchArtifacts();
        intake.on();

        //get out of launch area
        imuTurn(imuSpeed,25);
        imuDrive(imuSpeed,-30,0);
    }
}