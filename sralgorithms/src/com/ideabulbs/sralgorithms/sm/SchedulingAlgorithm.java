package com.ideabulbs.sralgorithms.sm;

public abstract class SchedulingAlgorithm {
	public static final Double MIN_EFACTOR = 1.3;
	
	double howEasyThisQToYou;
	int qualityResponse;
	double defaultEFactor = 2.5f;

	public double getEFactor() {
		return howEasyThisQToYou;
	}
	
	public void setEFactor(double newEFactor) {
		howEasyThisQToYou = newEFactor;
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
		if (qualityResponse < QualityResponseEnum.CORRECT_RESPONSE_03.getLevel()) 
			howEasyThisQToYou = defaultEFactor;
	}
	
	public abstract int getNextInterval(int n);
	public abstract double getNewEFactor();
}
