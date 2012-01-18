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
	private ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	private ArrayList<Pawn> ranks = new ArrayList<Pawn>();
	
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
		add(new Pawn("white"));
		add(new Pawn("black"));
	}
}
