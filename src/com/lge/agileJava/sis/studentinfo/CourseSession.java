package com.lge.agileJava.sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author wonyoung.jang
 * 
 */
public class CourseSession implements Comparable<CourseSession> {
	private static int count;
	private String department;
	private String number;
	private Date startDate;
	private List<Student> students = new ArrayList<Student>();
	private int numberOfCredits;

	/**
	 * Constructs a CourseSession starting on a specific date
	 * 
	 * @param department
	 * @param number
	 * @param startDate the date on which the CourseSession begins
	 */
	protected CourseSession(String department, String number, Date startDate) {
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
	
	public String getDepartment() {
		// TODO Auto-generated method stub
		return department;
	}

	public String getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	int getNumberOfStudents() {
		// TODO Auto-generated method stub
		return students.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
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
	public Date getEndDate() {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		
		return calendar.getTime();
	}

	protected Date getStartDate() {
		return startDate;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(CourseSession that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;
	}

}

