package com.lge.agileJava.sis.studentinfo;

import java.util.Date;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author wonyoung.jang
 * 
 */
public class CourseSession extends Session {
	private static int count;
	
	public static CourseSession create(
			String department,
			String number,
			Date startDate) {
		return new CourseSession(department, number, startDate);
	}

	protected CourseSession(String department, String number, Date startDate) {
		super(department, number, startDate);
		CourseSession.incrementCount();		
	}
	
	static private void incrementCount() {
		++count;
	}

	static public void resetCount() {
		CourseSession.count = 0;
	}

	static int getCount() {
		return count;
	}
	
	@Override
	protected int getSessionLength() {
		return 16;
	}

}

