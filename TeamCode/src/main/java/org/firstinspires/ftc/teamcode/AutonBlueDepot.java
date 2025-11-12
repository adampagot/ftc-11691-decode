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
        transferAndLaunchArtifacts();
        intake.on();

        imuTurn(imuSpeed, 135);
        imuDrive(imuSpeed,37,0);

        intake.off();
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed, -37, 0);
        imuTurn(imuSpeed, -135);

        transferAndLaunchArtifacts();
        intake.on();

        //go to get more
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,21,0);
        imuTurn(imuSpeed,90);

        imuDrive(imuSpeed,37,0);
        intake.off();
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed,-37,0);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,-21,0);
        imuTurn(imuSpeed,-45);

        transferAndLaunchArtifacts();

        //drive outside launch line for rp
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,30,0);
    }
}


