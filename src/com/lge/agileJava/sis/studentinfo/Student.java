package com.lge.agileJava.sis.studentinfo;

import java.util.ArrayList;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private ArrayList<String> grades = new ArrayList<String>();
	private String name;
	private int credits;
	private String state = "";
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	boolean isFullTime() {
		return credits >= Student.CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}
	
	void setState(String state) {
		this.state = state.toUpperCase();		
	}

	public boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

	public double getGpa() {
		if (grades.isEmpty())
			return 0.0;
		double total = 0.0;
		for (String grade: grades)
			total += gradePointsFor(grade);
		return total / grades.size();
	}

	int gradePointsFor(String grade) {
		if (grade.equals("A"))
			return 4;
		if (grade.equals("B"))
			return 3;
		if (grade.equals("C"))
			return 2;
		if (grade.equals("D"))
			return 1;
		return 0;
	}

	public void addGrade(String grade) {
		grades.add(grade);
	}

}
