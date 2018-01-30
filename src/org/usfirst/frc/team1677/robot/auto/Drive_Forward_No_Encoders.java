package org.usfirst.frc.team1677.robot.auto;

import java.util.Timer;

import org.usfirst.frc.team1677.robot.subsystems.Chassis;

public class Drive_Forward_No_Encoders {
	Chassis chassis;
	Timer timer;
	
	private static final boolean DEBUG = false;
	private static final String TAG = "DRIVE W/O ENCODERS: ";
	
	public Drive_Forward_No_Encoders() {
		chassis = new Chassis();
		timer = new Timer();
	}
	
	public void run() {
		chassis.setLeft(0.5);
		chassis.setRight(0.5);
	}
	
	public void stop() {
		chassis.setLeft(0.0);
		chassis.setRight(0.0);
	}
}
