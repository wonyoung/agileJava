package com.lge.agileJava.exercise.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PieceTest {
	@Test
	public void testCreate() {
		Piece pawn = Piece.create(Piece.whiteColor, "pawn");
		assertEquals(Piece.whiteColor, pawn.getColor());

		Piece secondPawn = Piece.create(Piece.blackColor, "pawn");
		assertEquals(Piece.blackColor, secondPawn.getColor());
		
	}
	
	@Test
	public void testPrintableRepresentation() {
		assertEquals('P', Piece.create(Piece.blackColor, "pawn").toChar());
	}
	
	@Test
	public void testColor() {
		Piece piece = Piece.create(Piece.whiteColor, "pawn");
		assertTrue(piece.isWhite());
		assertFalse(piece.isBlack());
		Piece piece2 = Piece.create(Piece.blackColor, "pawn");
		assertFalse(piece2.isWhite());
		assertTrue(piece2.isBlack());
	}
}