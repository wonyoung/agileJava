package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Piece;

public class BoardTest {
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	
	public Piece createWhitePawn() {
		return Piece.create(Piece.Color.WHITE, Piece.Type.PAWN);
	}
	
	public Piece createBlackPawn() {
		return Piece.create(Piece.Color.BLACK, Piece.Type.PAWN);
	}	
	
	@Test
	public void testCreate() {
		board.initialize();
		assertEquals(32, board.pieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
				StringUtil.appendNewLine("RNBQKBNR") +
				StringUtil.appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("pppppppp") +
				StringUtil.appendNewLine("rnbqkbnr") ,
				board.print());
	}
	
	@Test
	public void testGetNumberofPieces() {
		board.initialize();
		assertEquals(2, board.getNumberofPieces(Piece.Color.WHITE, Piece.Type.BISHOP));
		assertEquals(8, board.getNumberofPieces(Piece.Color.WHITE, Piece.Type.PAWN));
	}

}
