
package org.usfirst.frc.team1677.robot;


import org.usfirst.frc.team1677.robot.auto.Drive_Forward_No_Encoders;
import org.usfirst.frc.team1677.robot.controllers.ButtonBoard;
import org.usfirst.frc.team1677.robot.controllers.Wingman;
import org.usfirst.frc.team1677.robot.controllers.XboxController;
import org.usfirst.frc.team1677.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	public Chassis chassis;
	public Wingman driver;
//	public ButtonBoard coDriver;
	public Drive_Forward_No_Encoders autoExampleOne;
	
	
	private static final String TAG = "ROBOT: ";
	
	@Override
	public void robotInit() {	
		chassis = new Chassis();
		driver = new Wingman();
		// coDriver = new ButtonBoard();
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
		autoExampleOne = new Drive_Forward_No_Encoders();
	}

	@Override
	public void autonomousPeriodic() {
		autoExampleOne.run();
	}

	@Override
	public void teleopInit() {
		// autoExampleOne.stop();
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
