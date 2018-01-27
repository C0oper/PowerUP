package org.usfirst.frc.team1677.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

public class Chassis {
	private Victor Left;
	private Victor Right;
	
	public Chassis() {
		Left = new Victor(0);
		Right = new Victor(1);
	}
}
