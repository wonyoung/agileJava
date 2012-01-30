package com.lge.agileJava.exercise.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lge.agileJava.exercise.pieces.Piece.Type;

public class PieceTest {
	@Test
	public void testCreate() {
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(),
				Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
		verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(),
				Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
		verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(),
				Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(),
				Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
		verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
				Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
		verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
				Piece.Type.KING, Piece.KING_REPRESENTATION);
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());		
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece,
			Type name, char representation) {
		assertTrue(whitePiece.isWhite());
		assertEquals(name, whitePiece.getType());
		assertEquals(representation, whitePiece.getRepresentation());

		assertTrue(blackPiece.isBlack());
		assertEquals(name, blackPiece.getType());
		assertEquals(Character.toUpperCase(representation), 
				blackPiece.getRepresentation());		
	}

	@Test
	public void testPrintableRepresentation() {
		assertEquals('P', Piece.create(Piece.Color.BLACK, Piece.Type.PAWN).getRepresentation());
	}
	
	@Test
	public void testColor() {
		Piece piece = Piece.create(Piece.Color.WHITE, Piece.Type.PAWN);
		assertTrue(piece.isWhite());
		assertFalse(piece.isBlack());
		Piece piece2 = Piece.create(Piece.Color.BLACK, Piece.Type.PAWN);
		assertFalse(piece2.isWhite());
		assertTrue(piece2.isBlack());
	}	
}