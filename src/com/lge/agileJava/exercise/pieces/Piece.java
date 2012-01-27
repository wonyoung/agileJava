package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Piece {
	public static final String whiteColor = "white";
	public static final String blackColor = "black";
	private static int count;

	private String color;
	private String name;
	private char representation;
	
	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		Piece.count = 0;
	}
	
	public static Piece create(String color, String name) {
		count++;
		return new Piece(color, name);
	}
	
	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
		switch(name) {
		case "pawn":
		case "rook":
		case "bishop":
		case "queen":
		case "king":
			this.representation = this.name.charAt(0);
			break;
		case "knight":
			this.representation = 'n';
			break;
		default:
			this.representation = '.';
			break;
		}
		if (color.equals(blackColor))
			this.representation = Character.toUpperCase(this.representation);
		else
			this.representation = Character.toLowerCase(this.representation);
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

	public boolean isWhite() {
		return this.color.equals(whiteColor);
	}

	public boolean isBlack() {
		return this.color.equals(blackColor);
	}
}

