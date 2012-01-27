package com.lge.agileJava.exercise.chess;

import java.util.ArrayList;
import com.lge.agileJava.exercise.pieces.Piece;

/**
 * Board class for chess game world.
 * 
 * @author wonyoung.jang
 *
 */
public class Board {
	private ArrayList<Piece> pawns = new ArrayList<Piece>();
	private ArrayList<Piece> firstRanks = new ArrayList<Piece>();
	private ArrayList<Piece> secondRanks = new ArrayList<Piece>();
	private ArrayList<Piece> seventhRanks = new ArrayList<Piece>();
	private ArrayList<Piece> eighthRanks = new ArrayList<Piece>();
	
	Board() { }
	/**
	 * Get a number of pieces pawn
	 * @return number of pieces
	 */
	public int pieceCount() {
		return Piece.getCount();
	}

	/**
	 * Add Pawn object to Board
	 * @param pawn
	 */
	public void add(Piece pawn) {
		pawns.add(pawn);
		if (pawn.getColor().equals(Piece.blackColor)) {
			if (firstRanks.size() < 8) {
				firstRanks.add(pawn);
			}
			else {
				secondRanks.add(pawn);
			}
		}
		else {
			if (seventhRanks.size() < 8) {
				seventhRanks.add(pawn);
			}
			else {
				eighthRanks.add(pawn);
			}
		}
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
		Piece.resetCount();
		add(Piece.create("black", "rook"));
		add(Piece.create("black", "knight"));
		add(Piece.create("black", "bishop"));
		add(Piece.create("black", "queen"));
		add(Piece.create("black", "king"));
		add(Piece.create("black", "bishop"));
		add(Piece.create("black", "knight"));
		add(Piece.create("black", "rook"));
		for (int i=0; i<8;i++) {
			add(Piece.create("black", "pawn"));
			add(Piece.create("white", "pawn"));
		}
		add(Piece.create("white", "rook"));
		add(Piece.create("white", "knight"));
		add(Piece.create("white", "bishop"));
		add(Piece.create("white", "queen"));
		add(Piece.create("white", "king"));
		add(Piece.create("white", "bishop"));
		add(Piece.create("white", "knight"));
		add(Piece.create("white", "rook"));
	}
	public String get2ndRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : secondRanks)
			string.append(pawn.toChar());
		
		return string.toString();
	}
	public String get1stRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : firstRanks)
			string.append(pawn.toChar());

		return string.toString();
	}
	public String get7thRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : seventhRanks)
			string.append(pawn.toChar());

		return string.toString();
	}
	public String get8thRank() {
		StringBuilder string = new StringBuilder();
		for (Piece pawn : eighthRanks)
			string.append(pawn.toChar());

		return string.toString();
	}
	public String print() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(StringUtil.appendNewLine(get1stRank()));
		buffer.append(StringUtil.appendNewLine(get2ndRank()));

		for (int i=2;i<6;i++) {
			buffer.append(StringUtil.appendNewLine("........"));			
		}
		
		buffer.append(StringUtil.appendNewLine(get7thRank()));
		buffer.append(StringUtil.appendNewLine(get8thRank()));
		
		return buffer.toString();
	}
}
