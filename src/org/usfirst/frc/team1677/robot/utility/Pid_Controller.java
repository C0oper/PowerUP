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
	
	private final boolean DEBUG = false;
	private final String TAG = "PID CONTROLLER: ";
	
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
	
	public void setOutputLimits(double minimum, double maximum){
		if(maximum < minimum) {
			return;
		}else {
			setMaxOutput(maximum);
			setMinOutput(minimum);
		}
	}
	
	public double getOutput(double actual, double setpoint){
		double output;
		double Poutput;
		double Ioutput;
		double Doutput;
		double Foutput;

		this.setpoint=setpoint;

		// Ramp the setpoint used for calculations if user has opted to do so
		if(setpointRange!=0){
			setpoint = constrain(setpoint,actual-setpointRange,actual+setpointRange);
		}

		// Do the simple parts of the calculations
		double error=setpoint-actual;

		// Calculate F output. Notice, this depends only on the setpoint, and not the error. 
		Foutput=F*setpoint;

		// Calculate P term
		Poutput=P*error;   

		// If this is our first time running this, we don't actually _have_ a previous input or output. 
		// For sensor, sanely assume it was exactly where it is now.
		// For last output, we can assume it's the current time-independent outputs. 
		if(firstRun){
			lastActual=actual;
			lastOutput=Poutput+Foutput;
			firstRun=false;
		}

		// Calculate D Term
		// Note, this is negative. This actually "slows" the system if it's doing
		// the correct thing, and small values helps prevent output spikes and overshoot 
		Doutput= -D*(actual-lastActual);
		lastActual=actual;

		// The Iterm is more complex. There's several things to factor in to make it easier to deal with.
		// 1. maxIoutput restricts the amount of output contributed by the Iterm.
		// 2. prevent windup by not increasing errorSum if we're already running against our max Ioutput
		// 3. prevent windup by not increasing errorSum if output is output=maxOutput    
		Ioutput=I*errorSum;
		if(maxIOutput!=0){
			Ioutput=constrain(Ioutput,-maxIOutput,maxIOutput); 
		}    

		// And, finally, we can just add the terms up
		output=Foutput + Poutput + Ioutput + Doutput;

		// Figure out what we're doing with the error.
		if(minOutput!=maxOutput && !bounded(output, minOutput,maxOutput) ){
			errorSum=error; 
			// reset the error sum to a sane level
			// Setting to current error ensures a smooth transition when the P term 
			// decreases enough for the I term to start acting upon the controller
			// From that point the I term will build up as would be expected
		}
		else if(outputRampRate!=0 && !bounded(output, lastOutput-outputRampRate,lastOutput+outputRampRate) ){
			errorSum=error; 
		}
		else if(maxIOutput!=0){
			errorSum=constrain(errorSum+error,-maxError,maxError);
			// In addition to output limiting directly, we also want to prevent I term 
			// buildup, so restrict the error directly
		}
		else{
			errorSum+=error;
		}

		// Restrict output to our specified output and ramp limits
		if(outputRampRate!=0){
			output=constrain(output, lastOutput-outputRampRate,lastOutput+outputRampRate);
		}
		if(minOutput!=maxOutput){ 
			output=constrain(output, minOutput,maxOutput);
			}
		if(outputFilter!=0){
			output=lastOutput*outputFilter+output*(1-outputFilter);
		}

		// Get a test printline with lots of details about the internal 
		// calculations. This can be useful for debugging. 
		// System.out.printf("Final output %5.2f [ %5.2f, %5.2f , %5.2f  ], eSum %.2f\n",output,Poutput, Ioutput, Doutput,errorSum );
		// System.out.printf("%5.2f\t%5.2f\t%5.2f\t%5.2f\n",output,Poutput, Ioutput, Doutput );

		lastOutput=output;
		if(DEBUG) {
			System.out.println(TAG + "Output [" + output + "] Error [" + errorSum + "]" );
			System.out.println(TAG + "P [" + P + "] I [" + I + "] D [" + D + "]");			
		}
		return output;
	}

	
	/**
	 * Forces a value into a specific range
	 * @param value input value
	 * @param min maximum returned value
	 * @param max minimum value in range
	 * @return Value if it's within provided range, min or max otherwise 
	 */
	private double constrain(double value, double min, double max){
		if(value > max){ return max;}
		if(value < min){ return min;}
		return value;
	}  

	/**
	 * Test if the value is within the min and max, inclusive
	 * @param value to test
	 * @param min Minimum value of range
	 * @param max Maximum value of range
	 * @return true if value is within range, false otherwise
	 */
	private boolean bounded(double value, double min, double max){
		// Note, this is an inclusive range. This is so tests like
		// `bounded(constrain(0,0,1),0,1)` will return false.
		// This is more helpful for determining edge-case behaviour
		// than <= is.
		return (min<value) && (value<max);
	}
	
	public double getP() {
		return P; 
	}

	public void setP(double p) {
		if(DEBUG) {
			System.out.println(TAG + "Setting P [" + p + "]");
		}
		P = p;
	}

	public double getI() {
		return I;
	}

	public void setI(double i) {
		if(DEBUG) {
			System.out.println(TAG + "Setting I [" + i + "]");
		}
		I = i;
	}

	public double getD() {
		return D;
	}

	public void setD(double d) {
		if(DEBUG) {
			System.out.println(TAG + "Setting D [" + d + "]");
		}
		D = d;
	}

	public double getF() {
		return F;
	}

	public void setF(double f) {
		if(DEBUG) {
			System.out.println(TAG + "Setting F [" + f + "]");
		}
		F = f;
	}

	public double getMaxIOutput() {
		return maxIOutput;
	}

	public void setMaxIOutput(double maxIOutput) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Max I Output [" + maxIOutput + "]");
		}
		this.maxIOutput = maxIOutput;
	}

	public double getMaxError() {
		return maxError;
	}

	public void setMaxError(double maxError) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Max Error [" + maxError + "]");
		}
		this.maxError = maxError;
	}

	public double getErrorSum() {
		return errorSum;
	}

	public void setErrorSum(double errorSum) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Error Sum [" + errorSum + "]");
		}
		this.errorSum = errorSum;
	}

	public double getMaxOutput() {
		return maxOutput;
	}

	public void setMaxOutput(double maxOutput) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Max Output [" + maxOutput + "]");
		}
		this.maxOutput = maxOutput;
	}

	public double getMinOutput() {
		return minOutput;
	}

	public void setMinOutput(double minOutput) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Minimum Output [" + minOutput + "]");
		}
		this.minOutput = minOutput;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(double setpoint) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Setpoint [" + setpoint + "]");
		}
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
		if(DEBUG) {
			System.out.println(TAG + "Setting Output Ramp Rate [" + outputRampRate + "]");
		}
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
		if(DEBUG) {
			System.out.println(TAG + "Setting Output Filter [" + outputFilter + "]");
		}
		this.outputFilter = outputFilter;
	}

	public double getSetpointRange() {
		return setpointRange;
	}

	public void setSetpointRange(double setpointRange) {
		if(DEBUG) {
			System.out.println(TAG + "Setting Setpoint Range [" + setpointRange + "]");
		}
		this.setpointRange = setpointRange;
	}
}
