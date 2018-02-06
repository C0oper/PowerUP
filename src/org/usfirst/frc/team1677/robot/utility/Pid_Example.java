package org.usfirst.frc.team1677.robot.utility;

import org.usfirst.frc.team1677.robot.RobotMap;
import org.usfirst.frc.team1677.robot.controllers.Encoders;
import org.usfirst.frc.team1677.robot.subsystems.Chassis;

public class Pid_Example {
	private Pid_Controller pid;
	private Encoders enc;
	private Chassis chassis;
	private double speed;
	
	
	public Pid_Example() {
		
		// Create our new PID Controller
		// Assign our new PID Values
		pid = new Pid_Controller(RobotMap.P, RobotMap.I, RobotMap.D);
		enc = new Encoders();
		
		// Create our new Chassis
		chassis = new Chassis();
		
		// Zero out our speed
		speed = 0.0;
		
		// Set our Maximum-Minimum Speeds
		pid.setOutputLimits(-1.0, 1.0);
		// Set our acceptable error
		pid.setSetpointRange(RobotMap.EncoderInch/6);
		// Set our destination or distance
		pid.setSetpoint(RobotMap.EncoderInch);
	}
	
	public void start() {
		speed = pid.getOutput(enc.getLeftEncoder(), RobotMap.EncoderInch);
		chassis.setLeft(speed);
		chassis.setRight(speed);
	}
	
	public void stop() {
		speed = 0;
		chassis.setLeft(speed);
		chassis.setRight(speed);
	}
}
