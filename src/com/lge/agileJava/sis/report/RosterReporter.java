package com.lge.agileJava.sis.report;

import com.lge.agileJava.sis.studentinfo.Session;
import com.lge.agileJava.sis.studentinfo.Student;
import static com.lge.agileJava.sis.report.ReportConstant.NEWLINE;

public class RosterReporter {
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "----" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

	private Session session;
	
	public RosterReporter(Session session) {
		this.session = session;
	}
	
	String getReport() {
		StringBuilder buffer = new StringBuilder();
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}

	void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}	
	void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}
	void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
	}
}

