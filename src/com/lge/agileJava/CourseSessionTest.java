package com.lge.agileJava;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest {
	private CourseSession session;
	private Date startDate;

	Date createDate(int year, int month, int date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, date);
		
		return calendar.getTime();
	}
	
	@Before
	public void setUp() {
		startDate = createDate(2003, 1, 6);
		session = new CourseSession("ENGL", "101", startDate);
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
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee Devaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	
	@Test
	public void testCourseDates() {
		Date sixteenWeeksOut = createDate(2003,4,25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test
	public void testRosterReport() {
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = session.getRosterReport();
		assertEquals(
				CourseSession.ROSTER_REPORT_HEADER + 
				"A" + CourseSession.NEWLINE + 
				"B" + CourseSession.NEWLINE +
				CourseSession.ROSTER_REPORT_FOOTER + "2" +
				CourseSession.NEWLINE, rosterReport);
		
	}
}

