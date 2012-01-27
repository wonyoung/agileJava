package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Piece {
	private static final char whiteRepresentation = 'p';
	private static final char blackRepresentation = 'P';
	public static final String whiteColor = "white";
	public static final String blackColor = "black";

	private String color;
	private String name;
	private char representation;
	
	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
		if (color.equals(blackColor))
			this.representation = blackRepresentation;
		else
			this.representation = whiteRepresentation;
	}
	
	public static Piece create(String color, String name) {
		return new Piece(color, name);
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

