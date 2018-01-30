package org.usfirst.frc.team1677.robot.controllers;

import org.usfirst.frc.team1677.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class Wingman {
	private Joystick Controller;
	
	private boolean button_trigger;
	
	private double axis_x;
	private double axis_y;
	
	private static final boolean DEBUG = false;
	private static final String TAG = "WINGMAN CONTROLLER: ";
	
	public Wingman() {
		Controller = new Joystick(RobotMap.DriverPort);
		
		setButton_trigger(false);
		
		setAxis_x(0.0);
		setAxis_y(0.0);
	}
	
	public void updateInterface() {
		setAxis_x(Controller.getRawAxis(0));
		setAxis_y(Controller.getRawAxis(1));
		setButton_trigger(isButton_trigger());
		
        System.out.println(TAG + "Axis Y [" + getAxis_y() + "] Axis X[" + getAxis_x() + "]");
	}

	public boolean isButton_trigger() {
		return button_trigger;
	}

	public void setButton_trigger(boolean button_trigger) {
		this.button_trigger = Controller.getRawButton(1);
	}

	public double getAxis_x() {
		return axis_x;
	}

	public void setAxis_x(double axis_x) {
		this.axis_x = axis_x;
	}

	public double getAxis_y() {
		return axis_y;
	}

	public void setAxis_y(double axis_y) {
		this.axis_y = axis_y;
	}
}
