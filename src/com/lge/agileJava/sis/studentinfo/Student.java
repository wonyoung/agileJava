package com.lge.agileJava.sis.studentinfo;

public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	private String name;
	private int credits;
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCredits() {
		return credits;
	}

	void addCredits(int credits) {
		this.credits += credits;
	}

}
