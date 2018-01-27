package org.usfirst.frc.team1677.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;

public class Chassis {
	private Victor Left;
	private Victor Right;
	
	public Chassis() {
		Left = (new Victor(0));
		Right = new Victor(1);
		
		setLeft(0.0);
		setRight(0.0);
	}

	private void setLeft(double input) {
		Left.set(input);
	}
	
	private void setRight(double input) {
		Right.set(input);
	}
	
}
