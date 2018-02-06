
package org.usfirst.frc.team1677.robot;


import org.usfirst.frc.team1677.robot.controllers.ButtonBoard;
import org.usfirst.frc.team1677.robot.controllers.Encoders;
import org.usfirst.frc.team1677.robot.controllers.Wingman;
import org.usfirst.frc.team1677.robot.controllers.XboxController;
import org.usfirst.frc.team1677.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	public Chassis chassis;
	public Wingman driver;
//	public ButtonBoard coDriver;
	public Encoders enc;
	
	
	private static final String TAG = "ROBOT: ";
	
	@Override
	public void robotInit() {	
		chassis = new Chassis();
//		driver = new Wingman();
//		 coDriver = new ButtonBoard();
		enc = new Encoders();
	}

	@Override
	public void disabledInit() {
		chassis.setLeft(0.0);
		chassis.setRight(0.0);
	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void autonomousInit() {
		enc.resetLeftEncoder();
//		enc.resetRightEncoder();
	}

	@Override
	public void autonomousPeriodic() {
		enc.updateInterface();
	}

	@Override
	public void teleopInit() {
	
	}

	@Override
	public void teleopPeriodic() {
		driver.updateInterface();
		// coDriver.updateInterface();
		
		double leftVal = driver.getAxis_y() - driver.getAxis_x(); 
		double rightVal = driver.getAxis_y() + driver.getAxis_x();
        if(driver.isButton_trigger()) {
        	leftVal = leftVal / 2;
        	rightVal = rightVal / 2;
        } else {
        	leftVal = leftVal;
        	rightVal = rightVal;
        	leftVal = leftVal;
        	rightVal = rightVal;
        }
        // Arcade Drive
        chassis.setLeft(leftVal);
        chassis.setRight(rightVal);
	}

	@Override
	public void testPeriodic() {
	
	}
}
