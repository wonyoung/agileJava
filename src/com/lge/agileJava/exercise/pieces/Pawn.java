package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Pawn {
	private static final char whiteRepresentation = 'p';
	private static final char blackRepresentation = 'P';
	public static final String whiteColor = "white";
	public static final String blackColor = "black";

	private String color;
	private char representation;

	public Pawn(String color, char representation) {
		this.color = color;
		this.representation = representation;
	}
	
	/**
	 * Constructor
	 * @param color
	 */
	public Pawn(String color) {
		// TODO Auto-generated constructor stub
		this.color = color;
		if (color.equals(blackColor))
			this.representation = blackRepresentation;
		else
			this.representation = whiteRepresentation;
	}

	/**
	 * Constructor
	 */
	Pawn() {
		// TODO Auto-generated constructor stub
		this.color = whiteColor;
		this.representation = whiteRepresentation;
	}

	/**
	 * Get color of pawn
	 * @return
	 */
	public String getColor() {
		return color;
	}
	
	public char toChar() {
		return representation;
	}
}

