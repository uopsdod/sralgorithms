package com.ideabulbs.sralgorithms.sm.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

import com.ideabulbs.sralgorithms.sm.SM2;
import com.ideabulbs.sralgorithms.sm.SchedulingAlgorithm;

public class TestSM2 {

	@Test
	public void testIntervalOne() {
		SM2 sm2 = new SM2(2.5f, 5);
		int intercal_index = 0;
		int newInterval = sm2.getNextInterval(intercal_index++);
		double newEF = sm2.getNewEFactor();
		System.out.println("****************");
//		assertEquals(newInterval, 1);
//		assertTrue((2.4 < newEF) && (newEF < 2.6));
		
		sm2 = new SM2(newEF, 5);
		sm2.getNextInterval(intercal_index++);
		newEF = sm2.getNewEFactor();
		System.out.println("****************");
		
		sm2 = new SM2(newEF, 4);
		sm2.getNextInterval(intercal_index++);
		newEF = sm2.getNewEFactor();
		System.out.println("****************");
		
		sm2 = new SM2(newEF, 3);
		sm2.getNextInterval(intercal_index++);
		newEF = sm2.getNewEFactor();
		System.out.println("****************");
		
		sm2 = new SM2(newEF, 2);
		sm2.getNextInterval(intercal_index++);
		newEF = sm2.getNewEFactor();
		System.out.println("****************");
		
		sm2 = new SM2(newEF, 1);
		sm2.getNextInterval(intercal_index++);
		newEF = sm2.getNewEFactor();
		System.out.println("****************");
		
	}
	
	@Test
	public void testIntervals() {
		
		// we are simulating that we have answered the same question for 14 times.
		Vector<Integer> grades = new Vector<Integer>();
		grades.add(0);
		grades.add(3);
		grades.add(4);
		grades.add(5);
		grades.add(5);
		grades.add(1);
		grades.add(4);
		grades.add(5);
		grades.add(5);
		grades.add(5);
		grades.add(4);
		grades.add(3);
		grades.add(4);
		grades.add(5); // 14th

		Vector<Double> efs = new Vector<Double>();
		efs.add(2.5);

		Vector<Integer> intervals = new Vector<Integer>();
		intervals.add(1);
		
		// and each time, we will evaluate our answer and get two values: 
		// 1. efactor (how easy it is now to me)
		// 2. next interval (how long it should be reviewed again)
		for (int i=0; i<grades.size(); i++) {
			// efs 可得 next interval
			// grade + efs 可得 next efs
			// 將 next efs 加入倒 efs list中，當作下次的當前efs使用
			
			SM2 sm2 = new SM2(efs.get(i), grades.get(i));
			double newEF = sm2.getNewEFactor();
			int newInterval = sm2.getNextInterval(i);
			efs.add(newEF);
			intervals.add(newInterval);
		}
//		System.out.println("after efs.size(): " + efs.size());
//		System.out.println("efs: " + efs);

		assertTrue(intervals.get(0) == 1);
		assertTrue(intervals.get(1) == 0);
		assertTrue(intervals.get(2) == 1);
		assertTrue(intervals.get(3) == 6);
		assertTrue(intervals.get(4) == 3);
		assertTrue(intervals.get(5) == 4);
		assertTrue(intervals.get(6) == 7);
		assertTrue(intervals.get(7) == 6);
		assertTrue(intervals.get(8) == 7);
		assertTrue(intervals.get(9) == 9);
		assertTrue(intervals.get(10) == 12);
		assertTrue(intervals.get(11) == 14);
		assertTrue(intervals.get(12) == 16);
		assertTrue(intervals.get(13) == 16);
		assertTrue(intervals.get(14) == 17);
		
		System.out.print("EF : ");
		for (Double f : efs) {
			System.out.print(String.format("%.2f", f) + "\t");
		}
		System.out.println();
		System.out.print("Int: \t");
		for (Integer i : intervals) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

}
