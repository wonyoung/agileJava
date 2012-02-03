package com.lge.agileJava.sis.studentinfo;

import com.lge.agileJava.sis.studentinfo.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy {
	@Override
	public int getGradePointsFor(Grade grade) {
		int points = basicGradePointsFor(grade);
		if (points > 0)
			points += 1;
		return points;
	}
}
