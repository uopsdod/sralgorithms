package com.ideabulbs.sralgorithms.sm;

/**
 * SM2 spaced repetition algorithm implementation.
 * 
 * @author Andrei Matveyeu
 * @see Supermemo SM2 algorithm implementation by Dr. P. Wozniak: http://www.supermemo.com/english/ol/sm2.htm
 */
public class SM2 {
	float eFactor;
	int qualityResponse;
	float defaultEFactor = 2.5f;
	
	public SM2() {
		eFactor = 2.5f;
		qualityResponse = 0;
	}
	
	public SM2(float ef) {
		eFactor = ef;
		qualityResponse = 0;
	}
	
	public float getEFactor() {
		return eFactor;
	}
	
	public void setEFactor(float newEFactor) {
		eFactor = newEFactor;
	}
	
	public int getQualityResponse() {
		return qualityResponse;
	}

	/**
	 * Set quality response:
	 * 5 - perfect response
	 * 4 - correct response after a hesitation
	 * 3 - correct response recalled with serious difficulty
	 * 2 - incorrect response; where the correct one seemed easy to recall
	 * 1 - incorrect response; the correct one remembered
	 * 0 - complete blackout.
	 * @param newResponse
	 */
	public void setQualityResponse(int newResponse) {
		qualityResponse = newResponse;
		if (qualityResponse < 3) eFactor = defaultEFactor;
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
	 * Update the quality response and adjust eFactor if necessary
	 */
	public void updateResponse() {
		eFactor = eFactor +(0.1f-(5-qualityResponse)*(0.08f+(5-qualityResponse)*0.02f));
		if (eFactor < 1.3f) eFactor = 1.3f;
	}
	
}
