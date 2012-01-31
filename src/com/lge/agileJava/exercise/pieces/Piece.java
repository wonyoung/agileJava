package com.lge.agileJava.exercise.pieces;

/**
 * Pawn class for chess game.
 * 
 * @author wonyoung.jang
 *
 */
public class Piece implements Comparable<Piece> {
	public enum Color { WHITE, BLACK };
	public enum Type { NO_PIECE, PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING }
	static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';  
	private static int count;

	private Color color;
	private Type type;
	private char representation;
	private double strength;
	
	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		Piece.count = 0;
	}
	
	public static Piece create(Piece.Color white, Piece.Type type) {
		count++;
		return new Piece(white, type);
	}
	

	private Piece(Piece.Color color, Piece.Type type) {
		this.color = color;
		this.type = type;
		if (type == Piece.Type.PAWN)
			this.representation = PAWN_REPRESENTATION;
		else if (type == Piece.Type.ROOK)
			this.representation = ROOK_REPRESENTATION;
		else if (type == Piece.Type.KNIGHT)
			this.representation = KNIGHT_REPRESENTATION;
		else if (type == Piece.Type.BISHOP)
			this.representation = BISHOP_REPRESENTATION;
		else if (type == Piece.Type.QUEEN)
			this.representation = QUEEN_REPRESENTATION;
		else if (type == Piece.Type.KING)
			this.representation = KING_REPRESENTATION;
		else if (type == Piece.Type.NO_PIECE)
			this.representation = '.';

		if (color == Piece.Color.BLACK)
			this.representation = Character.toUpperCase(this.representation);
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	public char getRepresentation() {
		return representation;
	}

	public boolean isWhite() {
		return this.color == Piece.Color.WHITE;
	}

	public boolean isBlack() {
		return this.color == Piece.Color.BLACK;
	}

	private static Piece createWhite(Type type) {
		return create(Color.WHITE, type);
	}

	private static Piece createBlack(Type type) {
		return create(Color.BLACK, type);
	}

	public static Piece createWhitePawn() {
		return createWhite(Type.PAWN);
	}
	
	public static Piece createWhiteRook() {
		return createWhite(Type.ROOK);
	}

	public static Piece createWhiteKnight() {
		return createWhite(Type.KNIGHT);
	}

	public static Piece createWhiteBishop() {
		return createWhite(Type.BISHOP);
	}

	public static Piece createWhiteQueen() {
		return createWhite(Type.QUEEN);
	}

	public static Piece createWhiteKing() {
		return createWhite(Type.KING);
	}

	public static Piece createBlackPawn() {
		return createBlack(Type.PAWN);
	}

	public static Piece createBlackRook() {
		return createBlack(Type.ROOK);
	}

	public static Piece createBlackKnight() {
		return createBlack(Type.KNIGHT);
	}

	public static Piece createBlackBishop() {
		return createBlack(Type.BISHOP);
	}

	public static Piece createBlackQueen() {
		return createBlack(Type.QUEEN);
	}

	public static Piece createBlackKing() {
		return createBlack(Type.KING);
	}

	public static Piece noPiece() {
		return new Piece(null, Type.NO_PIECE);
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	@Override
	public int compareTo(Piece o) {
		return Double.compare(this.getStrength(), o.getStrength());
	}
}

