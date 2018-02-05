package org.usfirst.frc.team1677.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;

public class Chassis {
	private Victor Left;
	private Victor Right;
	
	private static final boolean DEBUG = false;
	private static final String TAG = "CHASSIS: ";
	
	public Chassis() {
		Left = (new Victor(0));
		Right = new Victor(1);
		
		setLeft(0.0);
		setRight(0.0);
	}

	public void setLeft(double input) {
		Left.set(input);
		if(DEBUG) {
			System.out.println(TAG + "Left Motor " + Left.get());
		}
	}
	
	public void setRight(double input) {
		Right.set(input);
		if(DEBUG) {
			System.out.println(TAG + "Right Motor " + Right.get());
		}
	}
	
}
