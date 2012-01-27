package com.lge.agileJava.sis.studentinfo;

import java.util.ArrayList;

public class Student {
	enum Grade { A, B, C, D, F };
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private ArrayList<Grade> grades = new ArrayList<Grade>();
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
		for (Grade grade: grades)
			total += gradePointsFor(grade);
		return total / grades.size();
	}

	int gradePointsFor(Grade grade) {
		if (grade == Grade.A) return 4;
		if (grade == Grade.B) return 3;
		if (grade == Grade.C) return 2;
		if (grade == Grade.D) return 1;
		return 0;
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}

}
