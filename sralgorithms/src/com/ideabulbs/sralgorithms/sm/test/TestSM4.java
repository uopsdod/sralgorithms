package com.ideabulbs.sralgorithms.sm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ideabulbs.sralgorithms.sm.SM2;
import com.ideabulbs.sralgorithms.sm.*;

public class TestSM4 {

	@Test
	public void testIntervalOne() {
		SM4 sm4 = new SM4(1.7, 1);
		int newInterval = sm4.getNextInterval(5);
		double newEF = sm4.getNewEFactor();
		System.out.println(newInterval + " " + newEF);
	}

}
