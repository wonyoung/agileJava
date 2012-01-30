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
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
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
			total += gradingStrategy.getGradePointsFor(grade);
		return total / grades.size();
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	void setHonors() {		
	}

	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy  = gradingStrategy;		
	}

}
