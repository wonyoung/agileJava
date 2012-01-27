package com.lge.agileJava.exercise.chess;

import java.util.ArrayList;
import static com.lge.agileJava.exercise.chess.StringUtil.NEWLINE;

import com.lge.agileJava.exercise.pieces.Piece;

/**
 * Board class for chess game world.
 * 
 * @author wonyoung.jang
 *
 */
public class Board {
	private ArrayList<Piece> pawns = new ArrayList<Piece>();
	private ArrayList<Piece> secondRanks = new ArrayList<Piece>();
	private ArrayList<Piece> seventhRanks = new ArrayList<Piece>();
	
	Board() { }
	/**
	 * Get a number of pieces pawn
	 * @return number of pieces
	 */
	public int getNumberOfPieces() {
		return pawns.size();
	}

	/**
	 * Add Pawn object to Board
	 * @param pawn
	 */
	public void add(Piece pawn) {
		pawns.add(pawn);
		if (pawn.getColor().equals(Piece.blackColor))
			secondRanks.add(pawn);
		else
			seventhRanks.add(pawn);
	}

	/**
	 * Get Pawn object from Board
	 * @param index
	 * @return
	 */
	public Piece get(int index) {
		return pawns.get(index);
	}
	
	public void initialize() {
		for (int i=0; i<8;i++) {
			add(Piece.create("white", "pawn"));
			add(Piece.create("black", "pawn"));
		}
	}
	public String get2ndRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : secondRanks)
			string.append(pawn.toChar());
		
		return string.toString();
	}
	public String get7thRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : seventhRanks)
			string.append(pawn.toChar());

		return string.toString();
	}
	public String print() {
		String buffer = new String();

		buffer = buffer.concat("........");
		buffer = buffer.concat(NEWLINE);
		
		buffer = buffer.concat(get2ndRank());
		buffer = buffer.concat(NEWLINE);

		for (int i=2;i<6;i++) {
			buffer = buffer.concat("........");
			buffer = buffer.concat(NEWLINE);			
		}
		
		buffer = buffer.concat(get7thRank());
		buffer = buffer.concat(NEWLINE);
		
		buffer = buffer.concat("........");
		buffer = buffer.concat(NEWLINE);
		
		return buffer.toString();
	}
}
