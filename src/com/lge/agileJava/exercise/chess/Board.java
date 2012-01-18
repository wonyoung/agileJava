package com.lge.agileJava.exercise.chess;

import java.util.ArrayList;

import com.lge.agileJava.exercise.pieces.Pawn;

/**
 * Board class for chess game world.
 * 
 * @author wonyoung.jang
 *
 */
public class Board {
	static final String NEWLINE = System.getProperty("line.separator");
	private ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	private ArrayList<Pawn> secondRanks = new ArrayList<Pawn>();
	private ArrayList<Pawn> seventhRanks = new ArrayList<Pawn>();
	
	Board() {
		initialize();
	}
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
	public void add(Pawn pawn) {
		pawns.add(pawn);
		if (pawn.getColor().equals(Pawn.blackColor))
			secondRanks.add(pawn);
		else
			seventhRanks.add(pawn);
	}

	/**
	 * Get Pawn object from Board
	 * @param index
	 * @return
	 */
	public Pawn get(int index) {
		return pawns.get(index);
	}
	
	public void initialize() {
		for (int i=0; i<8;i++) {
			add(new Pawn("white"));
			add(new Pawn("black"));
		}
	}
	public String get2ndRank() {
		StringBuilder string = new StringBuilder();
		for (Pawn pawn : secondRanks)
			string.append(pawn.toChar());
		
		return string.toString();
	}
	public String get7thRank() {
		StringBuilder string = new StringBuilder();
		for (Pawn pawn : seventhRanks)
			string.append(pawn.toChar());

		return string.toString();
	}
	public String print() {
		String buffer = new String();

		buffer = buffer.concat("........");
		buffer = buffer.concat(Board.NEWLINE);
		
		buffer = buffer.concat(get2ndRank());
		buffer = buffer.concat(Board.NEWLINE);

		for (int i=2;i<6;i++) {
			buffer = buffer.concat("........");
			buffer = buffer.concat(Board.NEWLINE);			
		}
		
		buffer = buffer.concat(get7thRank());
		buffer = buffer.concat(Board.NEWLINE);
		
		buffer = buffer.concat("........");
		buffer = buffer.concat(Board.NEWLINE);
		
		return buffer.toString();
	}
}
