package org.usfirst.frc.team1677.robot.subsystems;

import org.usfirst.frc.team1677.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;

public class Chassis {
	public static Victor Left;
	public static Victor Right;
	
	private static final boolean DEBUG = false;
	private static final String TAG = "CHASSIS: ";
	

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
	
	public Chassis() {
		Left = new Victor(RobotMap.LeftMaster);
		Right = new Victor(RobotMap.RightMaster);
		
		setLeft(0.0);
		setRight(0.0);
	}

}
