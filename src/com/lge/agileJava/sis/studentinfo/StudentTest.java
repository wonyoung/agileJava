package com.lge.agileJava.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testFullTime() {
		Student student = new Student("a");
		assertFalse(student.isFullTime());
	}
	
	@Test
	public void testStudentStatus() {
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	@Test
	public void testInState() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
		student.setState("co");
		assertTrue(student.isInState());
	}
}
