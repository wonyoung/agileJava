package com.lge.agileJava.sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author wonyoung.jang
 * 
 */
public class CourseSession {
	private static int count;
	private String department;
	private String number;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * Constructs a CourseSession starting on a specific date
	 * 
	 * @param department
	 * @param number
	 * @param startDate the date on which the CourseSession begins
	 */
	private CourseSession(String department, String number, Date startDate) {
		// TODO Auto-generated constructor stub
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	public static CourseSession create(
			String department,
			String number,
			Date startDate) {
		incrementCount();
		return new CourseSession(department, number, startDate);
	}

	private static void incrementCount() {
		++count;
	}

	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		CourseSession.count = 0;
	}
	
	String getDepartment() {
		// TODO Auto-generated method stub
		return department;
	}

	String getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	int getNumberOfStudents() {
		// TODO Auto-generated method stub
		return students.size();
	}

	public void enroll(Student student) {
		// TODO Auto-generated method stub
		students.add(student);
	}
	
	Student get(int index) {
		// TODO Auto-generated method stub
		return students.get(index);
	}

	/**
	 * 
	 * @return Date the last date of the course session
	 */
	Date getEndDate() {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3;	// weeks * days per week - 3 days
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		
		return calendar.getTime();
	}

	Date getStartDate() {
		// TODO Auto-generated method stub
		return startDate;
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

}

