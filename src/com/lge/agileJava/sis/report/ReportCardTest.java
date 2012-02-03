package com.lge.agileJava.sis.report;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lge.agileJava.sis.studentinfo.Student;

public class ReportCardTest {

	@Test
	public void testmessage() {
		ReportCard card = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE,
				card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE,
				card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE,
				card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE,
				card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE,
				card.getMessage(Student.Grade.F));
	}
}
