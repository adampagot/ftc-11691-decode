package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auton Red Loading", group = "Autons")
public class AutonRedLoading extends AutonBase {

    @Override
    public void runOpMode() {
        RobotHardwareMap theHardwareMap = new RobotHardwareMap(this.hardwareMap, this);
        theHardwareMap.initialize();

        waitForStart();

imuDrive(.5,15,0);

    }
}
