package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Piece {
	public enum Color { WHITE, BLACK };
	enum Type { PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING };  
	private static int count;

	private Color color;
	private String name;
	private char representation;
	
	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		Piece.count = 0;
	}
	
	public static Piece create(Piece.Color white, String name) {
		count++;
		return new Piece(white, name);
	}
	
	private Piece(Piece.Color color, String name) {
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
		if (color == Piece.Color.BLACK)
			this.representation = Character.toUpperCase(this.representation);
		else
			this.representation = Character.toLowerCase(this.representation);
	}

	/**
	 * Get color of pawn
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	
	public char toChar() {
		return representation;
	}

	public boolean isWhite() {
		return this.color == Piece.Color.WHITE;
	}

	public boolean isBlack() {
		return this.color == Piece.Color.BLACK;
	}
}

