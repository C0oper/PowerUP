package org.usfirst.frc.team1677.robot.controllers;

import edu.wpi.first.wpilibj.Encoder;

public class Encoders {
	private Encoder leftEncoder;
	private Encoder rightEncoder;

	private int rightVal;
	private int leftVal;
	
	private final boolean DEBUG = true;
	private final String TAG = "ENCODERS: ";
	
	
	// Constructor
	public Encoders() {
		leftEncoder = new Encoder(0, 1, false);
//		rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		
		leftVal = 0;
		rightVal = 0;
	}

	public void updateInterface() {
		setLeftEncoder();
//		setRightEncoder();
	}

	

	public int getLeftEncoder() {
		return leftVal;
	}

	public void setLeftEncoder() {
		leftVal = leftEncoder.getRaw();
		System.out.println(TAG + "Left value [" + leftVal + "]");
	}

	public void resetLeftEncoder() {
		leftEncoder.reset();
		leftVal = 0;
	}
		
//
//	public int getRightEncoder() {
//		return rightVal;
//	}
//
//
//	public void setRightEncoder() {
//		rightVal = rightEncoder.get();
//	System.out.println(TAG + "Right value [" + rightVal + "]");
//	}
//	
//	
//	public void resetRightEncoder() {
//		rightEncoder.reset();
//		rightVal = 0;
//	}
//	
}
