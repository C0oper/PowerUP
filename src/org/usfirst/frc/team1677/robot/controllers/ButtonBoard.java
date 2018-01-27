package org.usfirst.frc.team1677.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonBoard {
	private Joystick Controller;
	
	private boolean button_blue_bottom;
	private boolean button_blue_top;
	
	private boolean button_green_bottom;
	private boolean button_green_top;
	
	private boolean button_red_bottom;
	private boolean button_red_top;
	
	private boolean button_yellow_bottom;
	private boolean button_yellow_top;
	
	private boolean button_special;
	
	public ButtonBoard() {
		Controller = new Joystick(0);
		setButton_blue_bottom(false);
		setButton_blue_top(false);
		
		setButton_green_bottom(false);
		setButton_green_top(false);
		
		setButton_red_bottom(false);
		setButton_red_top(false);
		
		setButton_yellow_bottom(false);
		setButton_yellow_top(false);
		
		setButton_special(false);
	}
	
	public void updateButtons() {
		setButton_blue_top(Controller.getRawButton(0));
		setButton_blue_bottom(Controller.getRawButton(1));
		
		setButton_green_top(Controller.getRawButton(2));
		setButton_green_bottom(Controller.getRawButton(3));
		
		setButton_red_top(Controller.getRawButton(4));
		setButton_red_bottom(Controller.getRawButton(5));
		
		setButton_yellow_top(Controller.getRawButton(6));
		setButton_yellow_bottom(Controller.getRawButton(7));
		
		setButton_special(Controller.getRawButton(8));
	}

	public boolean isButton_blue_bottom() {
		return button_blue_bottom;
	}

	private void setButton_blue_bottom(boolean button_blue_bottom) {
		this.button_blue_bottom = button_blue_bottom;
	}

	public boolean isButton_blue_top() {
		return button_blue_top;
	}

	private void setButton_blue_top(boolean button_blue_top) {
		this.button_blue_top = button_blue_top;
	}

	public boolean isButton_green_bottom() {
		return button_green_bottom;
	}

	private void setButton_green_bottom(boolean button_green_bottom) {
		this.button_green_bottom = button_green_bottom;
	}

	public boolean isButton_green_top() {
		return button_green_top;
	}

	private void setButton_green_top(boolean button_green_top) {
		this.button_green_top = button_green_top;
	}

	public boolean isButton_red_bottom() {
		return button_red_bottom;
	}

	private void setButton_red_bottom(boolean button_red_bottom) {
		this.button_red_bottom = button_red_bottom;
	}

	public boolean isButton_red_top() {
		return button_red_top;
	}

	private void setButton_red_top(boolean button_red_top) {
		this.button_red_top = button_red_top;
	}

	public boolean isButton_yellow_bottom() {
		return button_yellow_bottom;
	}

	private void setButton_yellow_bottom(boolean button_yellow_bottom) {
		this.button_yellow_bottom = button_yellow_bottom;
	}

	public boolean isButton_yellow_top() {
		return button_yellow_top;
	}

	private void setButton_yellow_top(boolean button_yellow_top) {
		this.button_yellow_top = button_yellow_top;
	}

	public boolean isButton_special() {
		return button_special;
	}

	private void setButton_special(boolean button_special) {
		this.button_special = button_special;
	}
}
