package com.lge.agileJava.sis.summer;

import java.util.Date;

import com.lge.agileJava.sis.studentinfo.CourseSession;

public class SummerCourseSession extends CourseSession {
	public static SummerCourseSession create(
			String department,
			String number,
			Date startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	
	private SummerCourseSession(
			String department,
			String number,
			Date startDate) {
		super(department, number, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
}
