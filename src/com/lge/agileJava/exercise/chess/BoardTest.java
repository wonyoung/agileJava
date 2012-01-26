package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Pawn;
import static com.lge.agileJava.exercise.chess.StringUtil.NEWLINE;

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
		System.out.println(board.print());
		assertEquals(
				"........" + NEWLINE +
				"PPPPPPPP" + NEWLINE +
				"........" + NEWLINE +
				"........" + NEWLINE +
				"........" + NEWLINE +
				"........" + NEWLINE +
				"pppppppp" + NEWLINE +
				"........" + NEWLINE,
				board.print()
				);
	}

}
