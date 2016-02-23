package org.usfirst.frc.team1895.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1895.robot.Robot;

public class ManipulatorControl extends Command {

	public ManipulatorControl() {
		requires(Robot.manipulator);
	}

	protected void initialize() {
		Robot.manipulator.moveArm(0.0);
		Robot.manipulator.intakeSpeed(0.0);
		System.out.println("manipulator init");
	}

	protected void execute() {
		Robot.manipulator.moveArm(Robot.oi.joy.getRawAxis(1));
		Robot.manipulator.updateState();
		Robot.manipulator.updateMotorState();
		System.out.println("i work");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
