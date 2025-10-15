package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Sample", group = "Autons")
public class AutonblueDepot extends AutonBase {

    @Override
    public void runOpMode() {


        initialize();
        waitForStart();
       //getting ready to shoot
        imuDrive(.75,-10,0);
        //shoot
        //move to artifacts
        imuTurn(.5,135);
        imuDrive(.75,-8,0);
        //turn on intake
        //pick up artifacts
        imuTurn(.5,-135);
        encoderStrafe(.5,5,5);
        //maybe only have output motors running when needed

    }
}
