package org.usfirst.frc.team1677.robot;

import org.usfirst.frc.team1677.robot.controller.SideWinder;
import org.usfirst.frc.team1677.robot.controller.WingMan;

public class OI {
		
	WingMan driver;
	SideWinder coDriver;
	
	public double getAxis(int contr, int direction) {
		double value;
		int controller;
		int axis;
		
		controller = contr;
		axis = direction;
		
		
		switch(controller) {
			case 1:
				// WingMan
				if(axis == 0) {
					return driver.getX();
				} else if(axis == 1) {
					return -driver.getY();
				}
				break;
			case 2:
				//SideWinder
				if(axis == 0) {
					return coDriver.getX();
				} else if(axis == 1) {
					return -coDriver.getY();
				}
				break;
		}
		
		
		
		return 0.0;
	}

	public boolean getButton(int contr, int choice) {
		double value;
		int controller;
		int button;
		
		controller = contr;
		button = choice;
		
		
		switch(controller) {
			case 1:
				// WingMan
				if(button == 0) {
					return driver.get_Trigger();
				} else if(button == 1) {
					return driver.get_Left_Top();
				} else if(button == 2) {
					return driver.get_Left_Bottom();
				} else if(button == 3) {
					return driver.get_Right_Top();
				} else if(button == 4) {
					return driver.get_Right_Bottom();
				} else if(button == 5) {
					return driver.get_Base_Top();
				} else if(button == 6) {
					return driver.get_Base_Bottom();
				} else {
					System.out.println("ERROR: Button does not exist");
					return false;
				}
			case 2:
				//SideWinder
				if(button == 1) {
					return coDriver.get_button_a();
				} else if(button == 2) {
					return coDriver.get_button_b();
				} else if(button == 3) {
					return coDriver.get_button_c();
				} else if(button == 4) {
					return coDriver.get_button_x();
				} else if(button == 5) {
					return coDriver.get_button_y();
				} else if(button == 6) {
					return coDriver.get_button_z();
				} else if(button == 7) {
					return coDriver.get_button_lt();
				} else if(button == 8) {
					return coDriver.get_button_rt();
				} else {
					System.out.println("ERROR: Button does not exist");
					return false;
				}
		}
		return false;
	
	}

}

