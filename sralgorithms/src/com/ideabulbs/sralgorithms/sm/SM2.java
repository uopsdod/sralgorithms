package com.ideabulbs.sralgorithms.sm;

/**
 * SM2 spaced repetition algorithm implementation.
 * 
 * @author Andrei Matveyeu
 * @see Supermemo SM2 algorithm implementation by Dr. P. Wozniak: http://www.supermemo.com/english/ol/sm2.htm
 */
public class SM2 extends SchedulingAlgorithm {
	public SM2() {
//		eFactor = 2.5f;
		super.howEasyThisQToYou = super.defaultEFactor;
		super.qualityResponse = QualityResponseEnum.COMPLETE_BLACKOUT_00.getLevel();
	}
	
	public SM2(double ef, int qr) {
		super.howEasyThisQToYou = ef;
		super.qualityResponse = qr;
	}

	/**
	 * Get new interval
	 * @param howManyTimesYouHaveAnsThisQ
	 * @return
	 */
	public int getNextInterval(int howManyTimesYouHaveAnsThisQ) {
		int result = 0;
		if (howManyTimesYouHaveAnsThisQ==1) {
			result = 1;
		}
		else if (howManyTimesYouHaveAnsThisQ==2) {
			result = 6;
		}
		else if (howManyTimesYouHaveAnsThisQ>2) {
			result = (int) ((howManyTimesYouHaveAnsThisQ-1)*super.howEasyThisQToYou); 
		}
		else {
			result = 0;
		}
		System.out.println("nextInterval: " + result);
		return result;
	}
	
	/**
	 * Get new E-Factor based on the given E-Factor and quality response 
	 * @param ef Current E-Factor
	 * @param qr Quality response
	 * @return
	 */
	public double getNewEFactor() {
		int gap_btwn_curr_and_best = QualityResponseEnum.PERFECT_RESPONSE_05.getLevel() - super.qualityResponse;
		System.out.println("gap_btwn_curr_and_best(gap差越大，efs值就會越小): " + gap_btwn_curr_and_best);
		System.out.println("(0.08+gap_btwn_curr_and_best*0.02): " + (0.08+gap_btwn_curr_and_best*0.02));
		System.out.println("gap_btwn_curr_and_best*(0.08+gap_btwn_curr_and_best*0.02)(拿來減掉efactor用的，此絕對值越大，efs值越小): " + gap_btwn_curr_and_best*(0.08+gap_btwn_curr_and_best*0.02));
		double newEFactor = super.howEasyThisQToYou + (0.1) - (gap_btwn_curr_and_best*(0.08+gap_btwn_curr_and_best*0.02));
		System.out.println("nowEFactor: " + super.howEasyThisQToYou);
		System.out.println("newEFactor: " + newEFactor);
		if (newEFactor < SchedulingAlgorithm.MIN_EFACTOR) newEFactor = SchedulingAlgorithm.MIN_EFACTOR; // with 1.3 or 小於 1.3 being the hardest
		return newEFactor;
	}
}
