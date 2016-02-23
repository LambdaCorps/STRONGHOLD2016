package org.usfirst.frc.team1895.robot;

import org.usfirst.frc.team1895.robot.custom.F310;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	public F310 f310;
	public Joystick joy;
	
	public OI() {
		f310 = new F310(RobotMap.f310_port);
		joy = new Joystick(RobotMap.joy_port);
		
	}
}

