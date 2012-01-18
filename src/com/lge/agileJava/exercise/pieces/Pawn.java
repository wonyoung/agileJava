package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Pawn {
	public static final String whiteColor = "white";
	public static final String blackColor = "black";

	private String color;

	/**
	 * Constructor
	 * @param color
	 */
	public Pawn(String color) {
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	/**
	 * Constructor
	 */
	Pawn() {
		// TODO Auto-generated constructor stub
		this.color = whiteColor;
	}

	/**
	 * Get color of pawn
	 * @return
	 */
	String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	@Override
	public String toString() {
		return "P";
	}

	public char toChar() {
		return 'P';
	}
}

