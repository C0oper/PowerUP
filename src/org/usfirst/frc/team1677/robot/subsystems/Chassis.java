package org.usfirst.frc.team1677.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;

public class Chassis {
	VictorSP motor1;
	
	public void init() {
		motor1 = new VictorSP(1);
		
		motor1.enableDeadbandElimination(true);
	}
	
	public void changeSpeed(double SpeedVale) { 
		motor1.set(SpeedVale);
	}
}
