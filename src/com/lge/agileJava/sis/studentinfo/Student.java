package com.lge.agileJava.sis.studentinfo;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
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

}
