package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Piece;
import com.lge.agileJava.exercise.pieces.Piece.Color;

public class BoardTest {
	private static final double STRENGTH_TOLERANCE = 0.05;
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
	
	@Test
	public void testGetScore() {
		board.setEmpty();
		board.set(Piece.createBlackKing(), "b8");
		veryfyStrength(Piece.createBlackRook(), "c8", 5.0, Piece.Color.BLACK);
		veryfyStrength(Piece.createBlackBishop(), "d7", 8.0, Piece.Color.BLACK);
		veryfyStrength(Piece.createBlackQueen(), "e6", 17.0, Piece.Color.BLACK);
		veryfyStrength(Piece.createBlackPawn(), "a7", 18.0, Piece.Color.BLACK);
		veryfyStrength(Piece.createBlackPawn(), "b6", 19.0, Piece.Color.BLACK);
		veryfyStrength(Piece.createBlackPawn(), "c7", 20.0, Piece.Color.BLACK);
		
		board.set(Piece.createWhiteKing(), "f1");
		veryfyStrength(Piece.createWhiteRook(), "e1", 5.0, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhiteQueen(), "g4", 14.0, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhiteKnight(), "f4", 16.5, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhitePawn(), "f3", 17.5, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhitePawn(), "g2", 18.5, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhitePawn(), "h3", 19.5, Piece.Color.WHITE);
		veryfyStrength(Piece.createWhitePawn(), "f2", 19.5, Piece.Color.WHITE);
	}

	private void veryfyStrength(Piece piece, String location,
			double strength, Color color) {
		board.set(piece, location);
		assertEquals(strength, board.getStrength(color), STRENGTH_TOLERANCE);
	}
}
