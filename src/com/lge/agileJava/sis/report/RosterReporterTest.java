package com.lge.agileJava.sis.report;

import static com.lge.agileJava.sis.report.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lge.agileJava.sis.studentinfo.CourseSession;
import com.lge.agileJava.sis.studentinfo.DateUtil;
import com.lge.agileJava.sis.studentinfo.Student;

public class RosterReporterTest {
	@Test
	public void testRosterReport() {
		CourseSession session = new CourseSession("ENGL", "101", DateUtil.createDate(2003, 1, 6));
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
		System.out.println(rosterReport);
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER + 
				"A" + NEWLINE + 
				"B" + NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER + "2" +
				NEWLINE, rosterReport);
		
	}		
}
