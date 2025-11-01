package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Blue Loading", group = "Autons")
public class Autonblueloading extends AutonBase {
double imuSpeed = 0.5;

    @Override
    public void runOpMode() {
        initialize();
        waitForStart();

    //shoot preloaded artifacts
        imuDrive(imuSpeed,4,0);
        imuTurn(imuSpeed,18);
        imuDrive(imuSpeed, 2, 0);
       imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed, -37, 0);
        // active intake
        imuDrive(imuSpeed, 37, 0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed, -2,0);
        imuTurn(imuSpeed,-18);
        imuDrive(imuSpeed,-4,0);
    }
}