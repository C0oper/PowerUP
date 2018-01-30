package org.usfirst.frc.team1677.robot.controllers;

import org.usfirst.frc.team1677.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController {
	private Joystick Controller;
	
	private boolean button_a;
	private boolean button_b;
	private boolean button_x;
	private boolean button_y;
	
	private boolean button_rb;
	private boolean button_lb;
	
	private double axis_rt;
	private double axis_lt;
	
	private double axis_x;
	private double axis_y;
	
	private static final String TAG = "XBOX CONTROLLER: ";
	
	public XboxController() {
		Controller = new Joystick(RobotMap.DriverPort);

		setButton_a(false);
		setButton_b(false);
		setButton_x(false);
		setButton_y(false);
		
		setButton_rb(false);
		setButton_lb(false);
		
		setAxis_rt(0.0);
		setAxis_lt(0.0);
		setAxis_x(0.0);
		setAxis_y(0.0);
	}
	
	public void updateInterface() {
		setButton_a(Controller.getRawButton(0));
		setButton_b(Controller.getRawButton(1));
		setButton_x(Controller.getRawButton(2));
		setButton_y(Controller.getRawButton(3));
		
		setButton_lb(Controller.getRawButton(4));
		setButton_rb(Controller.getRawButton(5));
		
		setAxis_lt(Controller.getRawAxis(4));
		setAxis_rt(Controller.getRawAxis(5));
		
		setAxis_y(Controller.getRawAxis(1));
		setAxis_x(Controller.getRawAxis(2));
	}

	public boolean isButton_a() {
		return button_a;
	}

	private void setButton_a(boolean button_a) {
		this.button_a = button_a;
	}

	public boolean isButton_b() {
		return button_b;
	}

	private void setButton_b(boolean button_b) {
		this.button_b = button_b;
	}

	public boolean isButton_x() {
		return button_x;
	}

	private void setButton_x(boolean button_x) {
		this.button_x = button_x;
	}

	public boolean isButton_y() {
		return button_y;
	}

	private void setButton_y(boolean button_y) {
		this.button_y = button_y;
	}

	public boolean isButton_rb() {
		return button_rb;
	}

	private void setButton_rb(boolean button_rb) {
		this.button_rb = button_rb;
	}

	public boolean isButton_lb() {
		return button_lb;
	}

	private void setButton_lb(boolean button_lb) {
		this.button_lb = button_lb;
	}

	public double getAxis_rt() {
		return axis_rt;
	}

	private void setAxis_rt(double axis_rt) {
		this.axis_rt = axis_rt;
	}

	public double getAxis_lt() {
		return axis_lt;
	}

	private void setAxis_lt(double axis_lt) {
		this.axis_lt = axis_lt;
	}

	public double getAxis_x() {
		return axis_x;
	}

	private void setAxis_x(double axis_x) {
		this.axis_x = axis_x;
	}

	public double getAxis_y() {
		return axis_y;
	}

	private void setAxis_y(double axis_y) {
		this.axis_y = axis_y;
	}
	
}
