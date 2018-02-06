package org.usfirst.frc.team1677.robot.utility;

/**
* Small, easy to use PID implementation with advanced controller capability.<br> 
* Minimal usage:
*
* Pid_Controller pid = new Pid_Controller(p,i,d); 
* ...looping code...{ 
*   output = pid.getOutput(sensorvalue, target);
* }
*
**/

public class Pid_Controller {
	private double P;
	private double I;
	private double D;
	private double F;

	private double maxIOutput;
	private double maxError;
	private double errorSum;

	private double maxOutput; 
	private double minOutput;

	private double setpoint;

	private double lastActual;

	private boolean firstRun=true;
	private boolean reversed=false;

	private double outputRampRate;
	private double lastOutput;

	private double outputFilter;

	private double setpointRange;
	
	public Pid_Controller(double P, double I, double D) {
		this.setP(P);
		this.setI(I);
		this.setD(D);
		
		setFirstRun(true);
		// Automatically Assume that you'll want it false
		setReversed(false);
		checkValues();

	}

	public Pid_Controller(double P, double I, double D, boolean reversed) {
		this.setP(P);
		this.setI(I);
		this.setD(D);
		
		setFirstRun(true);
		setReversed(reversed);
		checkValues();
	}

	public Pid_Controller(double P, double I, double D, double F) {
		this.setP(P);
		this.setI(I);
		this.setD(D);
		this.setF(F);

		setFirstRun(true);
		// Automatically Assume that you'll want it false
		setReversed(false);
		checkValues();
	}
	
	
	public Pid_Controller(double P, double I, double D, double F, boolean reversed) {
		this.setP(P);
		this.setI(I);
		this.setD(D);
		this.setF(F);

		setFirstRun(true);
		setReversed(reversed);
		checkValues();
	}
	
	
	private void checkValues(){
		if(reversed){  // all values should be below zero
			if(P>0) P*=-1;
			if(I>0) I*=-1;
			if(D>0) D*=-1;
			if(F>0) F*=-1;
		}
		else{  // all values should be above zero
			if(P<0) P*=-1;
			if(I<0) I*=-1;
			if(D<0) D*=-1;
			if(F<0) F*=-1;
		}
	}
	
	public double getP() {
		return P;
	}

	public void setP(double p) {
		P = p;
	}

	public double getI() {
		return I;
	}

	public void setI(double i) {
		I = i;
	}

	public double getD() {
		return D;
	}

	public void setD(double d) {
		D = d;
	}

	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}

	public double getMaxIOutput() {
		return maxIOutput;
	}

	public void setMaxIOutput(double maxIOutput) {
		this.maxIOutput = maxIOutput;
	}

	public double getMaxError() {
		return maxError;
	}

	public void setMaxError(double maxError) {
		this.maxError = maxError;
	}

	public double getErrorSum() {
		return errorSum;
	}

	public void setErrorSum(double errorSum) {
		this.errorSum = errorSum;
	}

	public double getMaxOutput() {
		return maxOutput;
	}

	public void setMaxOutput(double maxOutput) {
		this.maxOutput = maxOutput;
	}

	public double getMinOutput() {
		return minOutput;
	}

	public void setMinOutput(double minOutput) {
		this.minOutput = minOutput;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}

	public double getLastActual() {
		return lastActual;
	}

	public void setLastActual(double lastActual) {
		this.lastActual = lastActual;
	}

	public boolean isFirstRun() {
		return firstRun;
	}

	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}

	public boolean isReversed() {
		return reversed;
	}

	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}

	public double getOutputRampRate() {
		return outputRampRate;
	}

	public void setOutputRampRate(double outputRampRate) {
		this.outputRampRate = outputRampRate;
	}

	public double getLastOutput() {
		return lastOutput;
	}

	public void setLastOutput(double lastOutput) {
		this.lastOutput = lastOutput;
	}

	public double getOutputFilter() {
		return outputFilter;
	}

	public void setOutputFilter(double outputFilter) {
		this.outputFilter = outputFilter;
	}

	public double getSetpointRange() {
		return setpointRange;
	}

	public void setSetpointRange(double setpointRange) {
		this.setpointRange = setpointRange;
	}
}
