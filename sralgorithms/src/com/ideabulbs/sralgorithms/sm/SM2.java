package com.ideabulbs.sralgorithms.sm;

/**
 * SM2 spaced repetition algorithm implementation.
 * 
 * @author Andrei Matveyeu
 * @see Supermemo SM2 algorithm implementation by Dr. P. Wozniak: http://www.supermemo.com/english/ol/sm2.htm
 */
public class SM2 extends SchedulingAlgorithm {
	
	public SM2() {
		eFactor = 2.5f;
		qualityResponse = 0;
	}
	
	public SM2(double ef, int qr) {
		eFactor = ef;
		qualityResponse = qr;
	}

	/**
	 * Get new interval
	 * @param n
	 * @return
	 */
	public int getNextInterval(int n) {
		if (n==1) {
			return 1;
		}
		else if (n==2) {
			return 6;
		}
		else if (n>2) {
			return (int) ((n-1)*eFactor); 
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Get new E-Factor based on the given E-Factor and quality response 
	 * @param ef Current E-Factor
	 * @param qr Quality response
	 * @return
	 */
	public double getNewEFactor() {
		double newEFactor = eFactor +(0.1-(5-qualityResponse)*(0.08+(5-qualityResponse)*0.02));
		if (newEFactor < 1.3) newEFactor = 1.3;
		return newEFactor;
	}
	
}
