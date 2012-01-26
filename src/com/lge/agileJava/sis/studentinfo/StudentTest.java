package com.lge.agileJava.sis.studentinfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testCreate() {
		final String studentName = "Jane Doe";
		Student student = new Student(studentName);
		assertEquals(studentName, student.getName());

		final String secondStudentName = "Joe Blow";
		Student secondStudent = new Student(secondStudentName);
		assertEquals(secondStudentName, secondStudent.getName());

		assertEquals(studentName, student.getName());		
	}
	
	@Test
	public void testBadStatic() {
		Student studentA = new Student("a");
		assertEquals("a", studentA.getName());
		Student studentB = new Student("b");
		assertEquals("b", studentB.getName());
		assertEquals("a", studentA.getName());
	}
}
