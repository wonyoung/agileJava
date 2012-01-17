package com.lge.agileJava;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class RosterReporterTest {
	@Test
	public void testRosterReport() {
		CourseSession session = new CourseSession("ENGL", "101", new DateUtil().createDate(2003, 1, 6));
		session .enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER + 
				"A" + RosterReporter.NEWLINE + 
				"B" + RosterReporter.NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER + "2" +
				RosterReporter.NEWLINE, rosterReport);
		
	}		
}
