package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Outtake;

@Autonomous(name = "Auton Red Loading", group = "Autons")
public class AutonRedLoading extends AutonBase {
    double imuSpeed = 0.7;

    @Override
    public void runOpMode() {
        initialize();
        Camera.goalcolor(1); // 0 is blue, 1 is red

        waitForStart();
        Camera.start();
        Camera.loop();

        outtake.outtakeonNoReverseTransfer();
        outtake.ControlMotorSpeed();
        aprilTagOutakeSpeedAdjustAndAlignment();

        //align with goal
        imuDrive(imuSpeed,-1,0);
        imuTurn(imuSpeed,-23);
        sleep (500);
        //score preloaded artifacts
        transferAndLaunchArtifacts();
        intake.on();
        imuDrive(imuSpeed,-17,0);


        //go to get more
        imuTurn(.6,-117);
        imuDrive(0.3,35,0);

        imuDrive(imuSpeed,-35,0);
        sleep (750);
        intake.off();

        outtake.outtakeonAfterIntake();

        //go to score
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,50,0);
        imuTurn(imuSpeed,-135);

        //score artifacts
        transferAndLaunchArtifacts();
        intake.on();

        //go to get more
        imuTurn(imuSpeed,-45);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,-90);
        imuDrive(0.3,33,0);
        sleep (750);
        intake.off();
        /*
        outtake.outtakeonAfterIntake();

        imuDrive(imuSpeed,-33,0);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,-135);

        //score artifacts
        transferAndLaunchArtifacts();

        //drive outside launch line for rp
        imuTurn(imuSpeed,-45);
        imuDrive(imuSpeed,30,0);*/
    }
}