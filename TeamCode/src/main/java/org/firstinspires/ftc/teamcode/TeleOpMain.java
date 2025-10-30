package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Outtake;
import org.firstinspires.ftc.teamcode.hardware.RobotControlMechanum;

@TeleOp
public class TeleOpMain extends LinearOpMode {

    static final String TAG = "TeleOp Main";

    @Override
    public void runOpMode() throws InterruptedException {
        //Initialize hardware
        RobotHardwareMap theHardwareMap = new RobotHardwareMap(this.hardwareMap, this);
        theHardwareMap.initialize();
/*
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
*/
        RobotControlMechanum robotDrive = new RobotControlMechanum(theHardwareMap, this);
        robotDrive.initialize();

        Intake intake = new Intake (theHardwareMap, this);
        intake.initialize();

        Outtake outtake = new Outtake (theHardwareMap, this);
        outtake.initialize();
/*
        RobotControlLights lights = new RobotControlLights(theHardwareMap, this);
        RobotControlLifter liftMotor = new RobotControlLifter(theHardwareMap,this);
        RobotControlArm armMotor = new RobotControlArm(theHardwareMap,this);
        RobotControlFlipperMotor flipperMotor = new RobotControlFlipperMotor(theHardwareMap, this);
        RobotControlGripperServos clawServo1 = new RobotControlGripperServos(theHardwareMap, this, "ServoClaw1");
        RobotControlGripperServos clawServo2 = new RobotControlGripperServos(theHardwareMap, this, "ServoClaw2");
        RobotControlGripperServos servoLauncher = new RobotControlGripperServos(theHardwareMap,this,"ServoLauncher");
        RobotControlFlipperPotentiometer robotControlFlipperPotentiometer = new RobotControlFlipperPotentiometer(theHardwareMap, this, "potentiometer");
        AutonBase autonBase = new AutonBase();

        /*FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());*/

        theHardwareMap.initAprilTag();

        telemetry.addData("Robot", "Initialized successfully");
        telemetry.update();

        waitForStart();
        telemetry.addData("Robot", "running teleop.. press (Y) For telemetry");
        telemetry.update();

       // create some gamepads to look at debouncing
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();
        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

      //double currentClaw = 0.8;
        //Main Loop
        while (opModeIsActive()) {
            theHardwareMap.telemetryAprilTag();
        //  loopTimeStart = System.currentTimeMillis();

           //copy over the previous gamepads so we can compare what changed
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            //mechanum drive - left stick y is negative because the up is negative
            double drive = -1 * gamepad1.left_stick_y;
            double strafe = -1 * gamepad1.left_trigger + gamepad1.right_trigger;
            //double strafe = gamepad1.left_stick_x;
            double twist = gamepad1.right_stick_x;

            //Speed values for slow mode
          /*  if (slowMode) {
                drive *= 0.6;
                strafe *= 0.6;
                twist *= 0.6;

            } else { // non slow mode is only 75% power
                drive *= 1;
                strafe *= 1;
                twist *= 1;
            }*/

            robotDrive.teleOpMechanum(drive, strafe, twist);

            /* //Distance Sensor Alignment
            //TODO: Add functionality with April Tags
            //TODO: Make sure you can run auton functionality in TeleOp
            if (currentGamepad1.a){
                double currentDistance = distanceSensor.getDistance(DistanceUnit.INCH);
                if (currentDistance > DISTANCE_FROM_BACKBOARD){
                    autonBase.imuDrive(0.5, -(currentDistance - DISTANCE_FROM_BACKBOARD), 0);
                }
                else if (currentDistance < DISTANCE_FROM_BACKBOARD){
                    autonBase.imuDrive(0.5, currentDistance - DISTANCE_FROM_BACKBOARD, 0);
                }
                else {
                    autonBase.imuDrive(0, 0, 0);
                }
            }
/*




            /***************
             * Gamepad 2
             */
            if (currentGamepad2.a && !previousGamepad2.a) {

                intake.Toggle();

            }

            if (currentGamepad2.x && !previousGamepad2.x) {

                outtake.ToggleOuttakeMotor();
            }

            if (currentGamepad2.y) {

                outtake.RunTransferServo();

            } else {
                outtake.StopTransferServo();
            }

            if (currentGamepad2.dpad_up && !previousGamepad2.dpad_up) {

                outtake.increasemotorspeed();
            }
            if (currentGamepad2.dpad_down && !previousGamepad2.dpad_down) {

                outtake.decreasemotorspeed();
            }
            //Open/close claw1
            /*if (currentGamepad2.left_bumper)
            {
                clawServo1.moveToPosition(GripperPositions.GRIPPER1_OPEN);
                telemetry.addData("Claw1 Open",clawServo1.getCurrentPosition());
            }
            else if (!currentGamepad2.left_bumper & previousGamepad2.left_bumper)
            {
                clawServo1.moveToPosition(GripperPositions.GRIPPER1_CLOSED);
                telemetry.addData("Claw1 Close",clawServo1.getCurrentPosition());
            }

            //claw 2 controls
            if (currentGamepad2.right_bumper)
            {
                clawServo2.moveToPosition(GripperPositions.GRIPPER2_OPEN);
                telemetry.addData("Claw2 Open",clawServo2.getCurrentPosition());
            }
            else if (!currentGamepad2.right_bumper & previousGamepad2.right_bumper)
            {
                clawServo2.moveToPosition(GripperPositions.GRIPPER2_CLOSED);
                telemetry.addData("Claw2 Close",clawServo2.getCurrentPosition());
            }

            /*if (currentGamepad2.y && previousGamepad2.y){
                currentClaw += 0.05;
                theHardwareMap.servoClaw2.setPosition(currentClaw);
            } else if (currentGamepad2.x && previousGamepad2.x){
                currentClaw -= 0.05;
                theHardwareMap.servoClaw2.setPosition(currentClaw);
            }*/

            outtake.ControlMotorSpeed();

            telemetry.update();
        }

        //  telemetry.addData ("Status", "Stopped");
        //  telemetry.update();

    }
}