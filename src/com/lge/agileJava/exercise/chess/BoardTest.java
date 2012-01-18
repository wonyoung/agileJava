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
		assertEquals(16, board.getNumberOfPieces());
		assertEquals("PPPPPPPP", board.get2ndRank());
		assertEquals("pppppppp", board.get7thRank());		
	}
	
	public Pawn createWhitePawn() {
		return new Pawn(Pawn.whiteColor);
	}
	
	public Pawn createBlackPawn() {
		return new Pawn(Pawn.blackColor);
	}	
	
	@Test
	public void testBoardPrint() {
		assertEquals(
				"........" + Board.NEWLINE +
				"PPPPPPPP" + Board.NEWLINE +
				"........" + Board.NEWLINE +
				"........" + Board.NEWLINE +
				"........" + Board.NEWLINE +
				"........" + Board.NEWLINE +
				"pppppppp" + Board.NEWLINE +
				"........" + Board.NEWLINE,
				board.print()
				);
	}

}
