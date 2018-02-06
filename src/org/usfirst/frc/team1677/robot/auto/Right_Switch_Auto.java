package org.usfirst.frc.team1677.robot.auto;

import org.usfirst.frc.team1677.robot.controllers.Encoders;
import org.usfirst.frc.team1677.robot.subsystems.Chassis;

public class Right_Switch_Auto {

	private Encoders enc;
	private Chassis chassis;
	private double speed;
	private int step;
	
	private final int distanceToSwitch = 168; 
	
	public Right_Switch_Auto() {
		enc = new Encoders();
		chassis = new Chassis();
		speed = 0.7;
	}
	
	public void start() {
		while(enc.getLeftEncoder() < distanceToSwitch ) {
			switch(step) {
//				Drive to switch
				case 0:
				
//				Put box onto switch
				case 1:
				
//				Back away and turn
				case 2:
					
					
//				Drive forward past the base line
				case 3:
					
			}
		}
	}
}
