package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Red Depot", group = "Autons")
public class AutonRedDepot extends AutonBase {

    @Override
    public void runOpMode() {

        initialize();

        waitForStart();
        imuTurn(0.6, 15);
        //score preloaded artifacts
        sleep(3000);
        imuTurn(.6,30);
        imuDrive(0.5,56,0);
        imuTurn(0.5, -135);
        imuDrive(0.5,37,0);
// Turn on intake
        sleep(500);
//turn off intake
        sleep(500);
        imuDrive(0.5, -37, 0);
        imuTurn(0.5, 135);
//shoot 3 artifacts
        sleep(3000);
        imuTurn(.6,-45);
        imuDrive(.6,21,0);
        imuTurn(.6,-90);
        //turn on intake
        imuDrive(.6,37,0);
        sleep(1000);
        //turn off intake
        imuDrive(.6,-37,0);
        imuTurn(.6,90);
        imuDrive(.6,-21,0);
        imuTurn(.6,45);
        //shoot artifacts
        sleep(3000);
        imuTurn(.6,-45);
        imuDrive(.6,30,0);
    /*imuDrive(0.65,34,0);
        imuTurn(0.65,-135);
        //intake on
        imuDrive(0.65,70,0);
        sleep(500);
        //turn off intake
        imuDrive(0.65,-70,0);
        imuTurn(0.65,135);
        imuDrive(0.65,-20,0);
        //shoot artifacts
        sleep(3000);
        imuDrive(.5,20,0);*/



    }
}