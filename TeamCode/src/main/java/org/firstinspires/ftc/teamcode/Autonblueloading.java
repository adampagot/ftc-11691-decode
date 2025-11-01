package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Blue Loading", group = "Autons")
public class Autonblueloading extends AutonBase {
    double imuSpeed = 0.7;

    @Override
    public void runOpMode() {
        initialize();
        waitForStart();

        imuTurn(imuSpeed,15);
        //score preloaded artifacts
        sleep(3000);
        imuTurn(.6,30);
        imuDrive(imuSpeed,-23,0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,35,0);
        //intake on
        sleep(1000);
        imuDrive(imuSpeed,-35,0);
        //intake off
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,50,0);
        imuTurn(imuSpeed,135);
        //score artifacts
        sleep(3000);
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,33,0);
        //intake on
        sleep(1000);
        //intake off
        imuDrive(imuSpeed,-33,0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,26,0);
        imuTurn(imuSpeed,135);
        //score artifacts
        sleep(3000);
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,30,0);
    }
}
