package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.LynxModuleImuType;

@Autonomous(name = "Auton Blue Depot", group = "Autons")
public class AutonBlueDepot extends AutonBase {

    @Override
    public void runOpMode() {
        initialize();

        waitForStart();

        imuDrive(0.65,53,0);
//score preloaded artifacts
        sleep(3000);
        imuTurn(0.65, 135);
        imuDrive(0.65,37,0);
// Turn on intake
        sleep(500);
//turn off intake
        sleep(500);
        imuDrive(0.65, -37, 0);
        imuTurn(0.65, -135);
//shoot 3 artifacts
        sleep(3000);
        imuDrive(0.65,34,0);
        imuTurn(0.65,135);
        //intake on
        imuDrive(0.65,70,0);
        sleep(500);
        //turn off intake
        imuDrive(0.65,-70,0);
        imuTurn(0.65,-135);
        imuDrive(0.65,-20,0);
        //shoot artifacts
        sleep(3000);
        imuDrive(.5,-65,0);

    }
}


