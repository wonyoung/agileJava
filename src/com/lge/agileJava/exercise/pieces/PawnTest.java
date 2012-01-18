package com.lge.agileJava.exercise.pieces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {
	@Test
	public void testCreate() {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.whiteColor, pawn.getColor());

		Pawn secondPawn = new Pawn(Pawn.blackColor);
		assertEquals(Pawn.blackColor, secondPawn.getColor());
		
	}
	
	@Test
	public void testPrintableRepresentation() {
		assertEquals('P', new Pawn(Pawn.blackColor).toChar());
	}
}