package org.usfirst.frc.team1895.robot;

public class RobotMap {
	//OI
		public static final int f310_port = 0;
			public static final double f310_axis_scaler = 0.55;
		public static final int joy_port  = 1;
	
	//Analog IO
		public static final int gyro_yi_port = 0;
		public static final int gyro_er_port = 1;
		public static final int rangeFinder_port = 2;
	
	//Digital IO
		public static final int outer_boulder_port  = 6;
		public static final int inner_boulder_port  = 5;
		public static final int left_encoderA_port  = 1;
		public static final int left_encoderB_port  = 2;
		public static final int right_encoderA_port = 3;
		public static final int right_encoderB_port = 4;
	
	//CAN
		public static final int left_motor1_port   = 5;
		public static final int left_motor2_port   = 3;
		public static final int right_motor1_port  = 4;
		public static final int right_motor2_port  = 6;
		public static final int hinge2_motor_port  = 1;
		public static final int hinge1_motor_port  = 2;
		public static final int intake_motor_port  = 7;
		public static final int spare_motor_port   = 8; //not programmed yet. when the talon is finally wired up it will show as 0 and must be changed in 172.22.11.2
	
	//Cameras
		public static final String cam0 = "cam0";
		public static final String cam1 = "cam1";
		public static final String cam2 = "cam2";
		public static final String cam3 = "cam3";
		public static final int num_cams = 4;
	
}
