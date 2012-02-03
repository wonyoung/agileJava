package com.lge.agileJava.sis.studentinfo;

import com.lge.agileJava.sis.studentinfo.Student.Grade;

public class RegularGradingStrategy extends BasicGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Grade grade) {
		return basicGradePointsFor(grade);
	}

}
