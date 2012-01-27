package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Piece;
import static com.lge.agileJava.exercise.chess.StringUtil.NEWLINE;

public class BoardTest {
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	@Test
	public void testCreate() {
		board.initialize();
		assertEquals(16, board.getNumberOfPieces());
		assertEquals("PPPPPPPP", board.get2ndRank());
		assertEquals("pppppppp", board.get7thRank());		
	}
	
	public Piece createWhitePawn() {
		return Piece.create(Piece.whiteColor, "pawn");
	}
	
	public Piece createBlackPawn() {
		return Piece.create(Piece.blackColor, "pawn");
	}	
	
	@Test
	public void testBoardPrint() {
		board.initialize();
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
