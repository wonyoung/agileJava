package com.lge.agileJava.sis.studentinfo;

import com.lge.agileJava.sis.studentinfo.Student;

public class BasicGradingStrategy implements GradingStrategy {
	@Override
	public int getGradePointsFor(Student.Grade grade) {
		return grade.getPoints();
	}

}