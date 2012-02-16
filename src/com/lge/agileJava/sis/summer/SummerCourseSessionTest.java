package com.lge.agileJava.sis.summer;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.lge.agileJava.sis.studentinfo.*;

public class SummerCourseSessionTest extends SessionTest {
	@Test
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session = SummerCourseSession.create("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());		
	}
	
	@Override
	protected Session createSession(String department, String number, Date startDate) {
		return SummerCourseSession.create(department, number, startDate);
	}


}
