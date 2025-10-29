package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Red Loading", group = "Autons")
public class AutonRedHomeDepot extends AutonBase {

    @Override
    public void runOpMode() {
        RobotHardwareMap theHardwareMap = new RobotHardwareMap(this.hardwareMap, this);
        theHardwareMap.initialize();

        waitForStart();

imuDrive(.5,33,0);
//score preloaded artifacts
imuTurn(.5, -90);
imuDrive(.5,15.5,0);
imuTurn(.5,-45);
// Turn on intake
imuDrive(0.5, 25, 0);
//turn off intake
imuDrive(0.5, 26, 0);
imuTurn(0.5, 135);
//shoot 3 artifacts
imuDrive(.5,82.5,0);

    }
}
