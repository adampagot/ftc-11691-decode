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
        sleep(3000);
        imuDrive(imuSpeed,-5,0);
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,-30,0);
        imuTurn(imuSpeed,180);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,35,0);
        //intake on
        sleep(1000);
        imuDrive(imuSpeed,-35,0);
        //intake off
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,50,0);
        imuTurn(imuSpeed,-45);
        //score artifacts
        sleep(3000);
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,23,0);
        imuTurn(imuSpeed,-90);
        imuDrive(imuSpeed,33,0);
        //intake on
        sleep(1000);
        //intake off
        imuDrive(imuSpeed,-33,0);
        imuTurn(imuSpeed,90);
        imuDrive(imuSpeed,23,0);
        imuTurn(imuSpeed,-45);
        //score artifacts
        sleep(3000);
        imuTurn(imuSpeed,45);
        imuDrive(imuSpeed,-30,0);
    }
}
