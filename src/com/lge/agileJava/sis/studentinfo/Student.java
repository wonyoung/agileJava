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
		for (String grade: grades) {
			if (grade.equals("A"))
				total += 4;
			else if (grade.equals("B"))
				total += 3;
			else if (grade.equals("C"))
				total += 2;
			else if (grade.equals("D"))
				total += 1;
		}

		return total / grades.size();
	}

	public void addGrade(String grade) {
		grades.add(grade);
	}

}
