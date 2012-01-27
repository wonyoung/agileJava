package com.lge.agileJava.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest {
	private CourseSession session;
	private Date startDate;
	private static final int CREDITS = 3;
	
	@Before
	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createCourseSession();
	}

	private CourseSession createCourseSession() {
		CourseSession session = 
				CourseSession.create("ENGL", "101", startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
	
	@Test
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	@Test
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee Devaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	
	@Test
	public void testCourseDates() {
		Date sixteenWeeksOut = DateUtil.createDate(2003,4,25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test
	public void testCount() {
		CourseSession.resetCount();
		createCourseSession();
		assertEquals(1, CourseSession.getCount());
		createCourseSession();
		assertEquals(2, CourseSession.getCount());
	}
	
	@Test
	public void testComparable() {
		final Date date = new Date();
		CourseSession sessionA = CourseSession.create("CMSC", "101", date);
		
		CourseSession sessionB = CourseSession.create("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		CourseSession sessionC = CourseSession.create("CMSC", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));
	}
}

