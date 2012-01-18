package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Pawn;

public class BoardTest {
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	@Test
	public void testCreate() {
		assertEquals(0, board.getNumberOfPieces());
	}
	
	@Test
	public void testAddPawns() {
		Pawn pawn1 = createBlackPawn();
		board.add(pawn1);
		assertEquals(1, board.getNumberOfPieces());
		
		Pawn pawn2 = createWhitePawn();
		board.add(pawn2);
		assertEquals(2, board.getNumberOfPieces());
		assertEquals(pawn1, board.get(0));
		assertEquals(pawn2, board.get(1));
	}
	public Pawn createWhitePawn() {
		return new Pawn(Pawn.whiteColor);
	}
	
	public Pawn createBlackPawn() {
		return new Pawn(Pawn.blackColor);
	}	

}
