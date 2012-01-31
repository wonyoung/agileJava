package com.lge.agileJava.exercise.chess;

import java.util.ArrayList;
import java.util.Collections;

import com.lge.agileJava.exercise.pieces.Piece;
import com.lge.agileJava.exercise.pieces.Piece.Color;
import com.lge.agileJava.exercise.pieces.Piece.Type;

/**
 * Board class for chess game world.
 * 
 * @author wonyoung.jang
 *
 */
public class Board {
	private static final double ROOK_STRENGTH = 5.0;
	private static final double BISHOP_STRENGTH = 3.0;
	private static final double QUEEN_STRENGTH = 9.0;
	private static final double KNIGHT_STRENGTH = 2.5;
	private static final double PAWN_STRENGTH = 1.0;
	private static final double PAWN_SAME_FILE_STRENGTH = 0.5;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private ArrayList<Piece> whitePieces = new ArrayList<Piece>();
	private ArrayList<Piece> blackPieces = new ArrayList<Piece>();
	
	Board() { }
	/**
	 * Get a number of pieces pawn
	 * @return number of pieces
	 */
	public int pieceCount() {
		return Piece.getCount();
	}

	/**
	 * Get Pawn object from Board
	 * @param index
	 * @return
	 */
	public Piece get(int index) {
		return pieces.get(index);
	}
	
	public void initialize() {
		setEmpty();
		
		set(Piece.createWhiteRook(), "a1");
		set(Piece.createWhiteKnight(), "b1");
		set(Piece.createWhiteBishop(), "c1");
		set(Piece.createWhiteQueen(), "d1");
		set(Piece.createWhiteKing(), "e1");
		set(Piece.createWhiteBishop(), "f1");
		set(Piece.createWhiteKnight(), "g1");
		set(Piece.createWhiteRook(), "h1");
		set(Piece.createWhitePawn(), "a2");
		set(Piece.createWhitePawn(), "b2");
		set(Piece.createWhitePawn(), "c2");
		set(Piece.createWhitePawn(), "d2");
		set(Piece.createWhitePawn(), "e2");
		set(Piece.createWhitePawn(), "f2");
		set(Piece.createWhitePawn(), "g2");
		set(Piece.createWhitePawn(), "h2");

		set(Piece.createBlackPawn(), "a7");
		set(Piece.createBlackPawn(), "b7");
		set(Piece.createBlackPawn(), "c7");
		set(Piece.createBlackPawn(), "d7");
		set(Piece.createBlackPawn(), "e7");
		set(Piece.createBlackPawn(), "f7");
		set(Piece.createBlackPawn(), "g7");
		set(Piece.createBlackPawn(), "h7");

		set(Piece.createBlackRook(), "a8");
		set(Piece.createBlackKnight(), "b8");
		set(Piece.createBlackBishop(), "c8");
		set(Piece.createBlackQueen(), "d8");
		set(Piece.createBlackKing(), "e8");
		set(Piece.createBlackBishop(), "f8");
		set(Piece.createBlackKnight(), "g8");
		set(Piece.createBlackRook(), "h8");
	}
	public String getRank(int rank) {
		StringBuilder string = new StringBuilder();
		int i = 0;
		for (Piece pawn : pieces) {
			if (i >= rank*8 && i < (rank+1) * 8)
				string.append(pawn.getRepresentation());
			i++;
		}
		
		return string.toString();
	}
	
	public String print() {
		StringBuilder buffer = new StringBuilder();

		for (int i=7;i>=0;i--) {
			buffer.append(StringUtil.appendNewLine(getRank(i)));
		}
		
		return buffer.toString();
	}
	
	public int getNumberofPieces(Color color, Type type) {
		int count = 0;
		for (Piece piece : pieces) {
			if (piece.getColor() == color && piece.getType() == type)
				count++;
		}
		return count;
	}
	public Piece retrievePiece(String location) {
		return pieces.get(getIndexAt(location));
	}
	
	public void set(Piece piece, String location) {
		int index = getIndexAt(location);
		pieces.set(index, piece);
		double strength = 0.0;
		if (piece.getType() == Type.ROOK)
			strength = ROOK_STRENGTH;
		else if (piece.getType() == Type.BISHOP)
			strength = BISHOP_STRENGTH;
		else if (piece.getType() == Type.QUEEN)
			strength = QUEEN_STRENGTH;
		else if (piece.getType() == Type.KNIGHT)
			strength = KNIGHT_STRENGTH;
		else if (piece.getType() == Type.PAWN) {
			boolean isExistSameType = false;
			for (int i=0;i<8;i++) {
				if (index != i*8+(index%8)) {
					Piece p = pieces.get(i*8+(index%8));
					if (p.getColor() == piece.getColor()
							&& p.getType() == piece.getType()) {
						p.setStrength(PAWN_SAME_FILE_STRENGTH);
						isExistSameType = true;
					}
				}
			}
			if (isExistSameType)
				strength = PAWN_SAME_FILE_STRENGTH;
			else
				strength = PAWN_STRENGTH;
		}
		piece.setStrength(strength);
		if (piece.isWhite()) {
			whitePieces.add(piece);
			Collections.sort(whitePieces);
		}
		else if (piece.isBlack()) {
			blackPieces.add(piece);
			Collections.sort(blackPieces);
		}
	}
	private int getIndexAt(String location) {
		int index;
		index = Character.codePointAt(location, 0) - 'a';
		index += (Character.codePointAt(location,1) - '1') * 8;
		return index;
	}
	public void setEmpty() {
		Piece.resetCount();
		for (int i=0; i<8*8;i++) {
			pieces.add(Piece.noPiece());
		}		
	}
	public double getStrength(Color color) {
		double strength = 0.0;
		for (Piece piece : pieces)
			if (piece.getColor() == color)
				strength += piece.getStrength();
		
//				if (piece.getType() == Type.ROOK)
//					strength += ROOK_STRENGTH;
//				else if (piece.getType() == Type.BISHOP)
//					strength += BISHOP_STRENGTH;
//				else if (piece.getType() == Type.QUEEN)
//					strength += QUEEN_STRENGTH;
//				else if (piece.getType() == Type.KNIGHT)
//					strength += KNIGHT_STRENGTH;
//				else if (piece.getType() == Type.PAWN) {
//					if (getNumberofSameFile(pieces.indexOf(piece), piece.getColor(), Type.PAWN) > 1)
//						strength += PAWN_SAME_FILE_STRENGTH;
//					else
//						strength += PAWN_STRENGTH;
//				}
//						
						

//		strength = getNumberofPieces(color, Type.ROOK) * ROOK_STRENGTH;
//		strength += getNumberofPieces(color, Type.BISHOP) * BISHOP_STRENGTH;
//		strength += getNumberofPieces(color, Type.QUEEN) * QUEEN_STRENGTH;
//		strength += getNumberofPieces(color, Type.KNIGHT) * KNIGHT_STRENGTH;
//		strength += getNumberofPieces(color, Type.PAWN) * PAWN_STRENGTH;
		
		return strength;
	}
}
