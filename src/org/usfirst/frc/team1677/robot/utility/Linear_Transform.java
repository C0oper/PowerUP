package org.usfirst.frc.team1677.robot.utility;

public class Linear_Transform {
	/* Linear Transformation
	 * This file is used to find the shortest route between two points. 
	 * Essentially we are finding our hypotnuse.
	 * 
	 * a^2 + b^2 = c^2
	 */
	
	public double Linear_Transform(double x, double y) {
		double a = x;
		double b = y;
		double c;
		
		a = Math.pow(a, 2);
		b = Math.pow(b, 2);
		c = a + b;
		c = Math.sqrt(c);
		return c;
	}
}
