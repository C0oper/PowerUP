
package org.usfirst.frc.team1677.robot;


import org.usfirst.frc.team1677.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	public Chassis chassis;
	
	@Override
	public void robotInit() {
		chassis = new Chassis();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		
	}

	@Override
	public void testPeriodic() {
	
	}
}
