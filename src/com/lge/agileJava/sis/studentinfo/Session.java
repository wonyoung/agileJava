package com.lge.agileJava.sis.studentinfo;

import java.util.*;

abstract public class Session implements Comparable<Session> {
	private String department;
	private String number;
	private Date startDate;
	private List<Student> students = new ArrayList<Student>();
	private int numberOfCredits;

	protected Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	@Override
	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	Student get(int index) {
		return students.get(index);
	}


	protected Date getStartDate() {
		return startDate;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	abstract protected int getSessionLength();
	
	/**
	 * 
	 * @return Date the last date of the course session
	 */
	public Date getEndDate() {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		
		return calendar.getTime();
	}

}