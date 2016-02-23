package org.usfirst.frc.team1895.robot.subsystems;

import org.usfirst.frc.team1895.robot.Robot;
import org.usfirst.frc.team1895.robot.RobotMap;
import org.usfirst.frc.team1895.robot.commands.ManipulatorControl;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulatorSubsystem extends Subsystem {
	
	//motors go here
	private CANTalon left_arm_motor; //These are paired motors; have to be the same
	private CANTalon right_arm_motor;//
	
	private CANTalon intake_motor;

	public DigitalInput outerSensor;
	public DigitalInput innerSensor;
	 
	private int state;
	
	private boolean manual_control;
	
	/***/
	public ManipulatorSubsystem() {
		left_arm_motor = new CANTalon(RobotMap.hinge2_motor_port);
		right_arm_motor = new CANTalon(RobotMap.hinge1_motor_port);
		
		intake_motor = new CANTalon(RobotMap.intake_motor_port);

		innerSensor = new DigitalInput(RobotMap.inner_boulder_port);
		outerSensor = new DigitalInput(RobotMap.outer_boulder_port);
		
		state = 0;
		
		manual_control = false;
	}
	
	/***/
	public void moveArm(double speed) {
		if(speed > 0) {
			left_arm_motor.set(speed * 0.75);
			right_arm_motor.set(speed* 0.75);
		} else if(speed < 0) {
			left_arm_motor.set(speed * 0.45);
			right_arm_motor.set(speed* 0.45);
		} else {
			left_arm_motor.set( 0.0);
			right_arm_motor.set(0.0);
		}

	}
	
	/***/
	public void intakeSpeed(double velocity) {
		
		intake_motor.set(velocity);
	}
	
	/***/
	public int getState() {
		return state;
	}
	
	/***/
	public void updateState() {
		System.out.println("updateState start");
		SmartDashboard.putBoolean("getOuterSensor", outerSensor.get());
		SmartDashboard.putBoolean("getInnerSensor", innerSensor.get());
		if(innerSensor.get()==false && outerSensor.get()==false && state==3) state=0; //boulder is not in range; just left
		if(innerSensor.get()==false && outerSensor.get()==true  && state==0) state=1; //boulder detected; intaking
		if(innerSensor.get()==false && outerSensor.get()==false && state==1) state=0; //boulder ran away :(
		if(innerSensor.get()==true  && outerSensor.get()==true  && state==1) state=2; //boulder is being held
		if(Robot.oi.joy.getRawButton(1)                         && state==2) state=3; //firing
		SmartDashboard.putNumber("updateState", state);

	}
	
	public void updateMotorState() {
		if(manual_control) {
			driveMotor(Robot.oi.joy.getRawButton(1), Robot.oi.joy.getRawButton(2));
		} else {
			switch(state) {
				case 0:
					intake_motor.set( 0.00);
					break;
				case 1:
					intake_motor.set( 0.55);
					break;
				case 2:
					intake_motor.set( 0.00);
					break;
				case 3:
					intake_motor.set(-0.75);
					break;
			}
		}
	}
	
	public void driveMotor(boolean in, boolean out) {
		if(in && !out) {
			intake_motor.set( 0.55);
		} else if (!in && out) {
			intake_motor.set(-0.75);
		} else {
			intake_motor.set( 0.00);
		}
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ManipulatorControl());
		System.out.println("initializae default command for manipulator");
	}
}

