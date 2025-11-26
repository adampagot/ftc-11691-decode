package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Outtake;
@Autonomous(name = "Auton Red Loading", group = "Autons")
public class AutonRedLoading extends AutonBase {
    double imuSpeed = 0.5;
    double turnSpeed = 0.6;
    int direction = -1; // 1 for Blue; -1 for Red

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
        imuTurn(imuSpeed,23 * direction);
        sleep (500);
        //score preloaded artifacts
        transferAndLaunchArtifacts(); // shoot the first set of artifacts that were preloaded
        intake.on();
        sleep(1000);
        imuDrive(imuSpeed,-20,0);


        //go to get back row
        imuTurn(turnSpeed,110 * direction);
        imuDrive(0.3,35,0);

        imuDrive(imuSpeed,-35,0);
        sleep (750);
        intake.off();

        outtake.outtakeonAfterIntake();

        //go to score from back
        imuTurn(turnSpeed,-110 * direction);
        imuDrive(imuSpeed,17,0);
        aprilTagOutakeSpeedAdjustAndAlignment();

        //score artifacts
        transferAndLaunchArtifacts();
        intake.on();

        //go get second row (trying to save  little time
        imuDrive(imuSpeed,-30,0);
        imuTurn(turnSpeed,35 * direction);
        imuDrive(imuSpeed,-9,0);
        imuTurn(turnSpeed,75 * direction);

        // ramp down speed for better intake
        imuDrive(imuSpeed,5,0);
        imuDrive(imuSpeed * 0.75,5,0);
        imuDrive(imuSpeed * 0.5,20,0);
        sleep(5000);

        // out of time
    }
}
