package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Outtake;
@Autonomous(name = "Auton Blue Loading", group = "Autons")
public class Autonblueloading extends AutonBase {
    double imuSpeed = 0.5;

    @Override
    public void runOpMode() {
        initialize();
        Camera.goalcolor(0); // 0 is blue, 1 is red

        waitForStart();
        Camera.start();
        Camera.loop();

        outtake.outtakeonNoReverseTransfer();
        outtake.ControlMotorSpeed();
        aprilTagOutakeSpeedAdjustAndAlignment();

        //align with goal
        imuDrive(imuSpeed,-1,0);
        imuTurn(imuSpeed,23);
        sleep (500);
        //score preloaded artifacts
        transferAndLaunchArtifacts();
        intake.on();
        sleep(1000);
        imuDrive(imuSpeed,-17,0);


        //go to get more
        imuTurn(.6,117);
        imuDrive(0.3,35,0);

        imuDrive(imuSpeed,-35,0);
        sleep (750);
        intake.off();

        outtake.outtakeonAfterIntake();

        //go to score
        imuTurn(.6,-117);
        imuDrive(imuSpeed,17,0);
        aprilTagOutakeSpeedAdjustAndAlignment();

        //score artifacts
        transferAndLaunchArtifacts();
        intake.on();

        //go get more
        imuTurn(.6,45);
        imuDrive(imuSpeed,-30,0);
        imuTurn(.6,90);
        imuDrive(imuSpeed,50,0);

        //go score
        imuDrive(imuSpeed,-50,0);
        imuTurn(.6,-90);
        intake.off();

        //score
        outtake.outtakeonAfterIntake();
        imuDrive(imuSpeed,30,0);
        imuTurn(.6,-23);
        aprilTagOutakeSpeedAdjustAndAlignment();
        transferAndLaunchArtifacts();

         //align with goal
        /*imuDrive(imuSpeed,-1,0);
        imuTurn(imuSpeed,23);
        sleep (500);
        //score preloaded artifacts
        transferAndLaunchArtifacts();
        intake.on();
        sleep(1000);
        imuDrive(imuSpeed,-17,0);


        //go to get more
        imuTurn(.6,117);
        imuDrive(0.3,35,0);

        imuDrive(imuSpeed,-35,0);
        sleep (750);
        intake.off();

        outtake.outtakeonAfterIntake();

        //go to score
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,50,0);
        imuTurn(imuSpeed,135);

        //score artifacts
        transferAndLaunchArtifacts();
        intake.on();

        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,90);
        imuDrive(0.3,33,0);
        sleep (750);
        intake.off();
            /*
        outtake.outtakeonAfterIntake();

        //go to score
        imuDrive(imuSpeed,-33,0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,135);

        //score artifacts
        transferAndLaunchArtifacts();

        //drive outside launch line for rp
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,30,0);*/
    }
}
