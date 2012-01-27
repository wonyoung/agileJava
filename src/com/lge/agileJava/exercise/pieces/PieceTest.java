package com.lge.agileJava.exercise.pieces;

import static org.junit.Assert.assertEquals;

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
}