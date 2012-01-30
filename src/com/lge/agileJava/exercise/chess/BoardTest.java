package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Piece;

public class BoardTest {
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
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

	@Test
	public void testRetrievePiece() {
		board.initialize();
		assertTrue(board.retrievePiece("a8").isBlack());
		assertEquals(Piece.Type.ROOK, board.retrievePiece("a8").getType());
		assertTrue(board.retrievePiece("e1").isWhite());
		assertEquals(Piece.Type.KING, board.retrievePiece("e1").getType());
	}
	
	@Test
	public void testCreateArbitaryPosition() {
		board.setEmpty();
		board.set(Piece.createWhiteKing(), "c4");
		board.set(Piece.createBlackKing(), "b6");
		board.set(Piece.createBlackRook(), "b5");
		assertEquals(3, board.pieceCount());
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(
				blankRank + blankRank +
				StringUtil.appendNewLine(".K......") +
				StringUtil.appendNewLine(".R......") +
				StringUtil.appendNewLine("..k.....") +
				blankRank + blankRank + blankRank,
				board.print());		
	}
}
