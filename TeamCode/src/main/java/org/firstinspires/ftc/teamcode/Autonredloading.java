package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Sample", group = "Autons")
public class Autonredloading extends AutonBase {

    @Override
    public void runOpMode() {
        

        initialize();
        waitForStart();
        //start with only rear right corner touching wall
        //aim at goal from smaller shooting zone
        //activate outake before shooting
        //aim
        encoderStrafe(.5,5,3);
        imuDrive(.5,-3,0);
        //shoot
        //activate intake
        //get artifacts
        imuDrive(.75,12,0);
        imuTurn(.5,135);
        //encoderStrafe(.5,-10,5);
        //collect artifacts
        encoderStrafe(.75,23,9);
        imuTurn(.5,135);
        //shoot

    }
}
