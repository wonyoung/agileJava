package com.lge.agileJava.exercise.chess;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CharacterTest {
	@Test
	public void testWhitespace() {
		for (char c = 0 ; c<128;c++) {
			switch(c) {
			case '\n':
			case '\t':
			case ' ':
			case 11:
			case 12:
			case 13:
			case 28:
			case 29:
			case 30:
			case 31:
				assertEquals(true, Character.isWhitespace(c));
				break;
			default:
				assertEquals(Integer.toString((int) c), false, Character.isWhitespace(c));
			}
		}
	}
	
	@Test
	public void testJavaIdentifier() {
		assertEquals(false, Character.isJavaIdentifierStart('2'));
		assertEquals(false, Character.isJavaIdentifierPart('^'));
		
		assertEquals(false, isJavaIdentifier("2TestJavaIdentifier"));
		assertEquals(true, isJavaIdentifier("TestJavaIdentifier2"));
	}
	
	boolean isJavaIdentifier(String s) {
		char [] identifier = s.toCharArray();
		if (!Character.isJavaIdentifierStart(identifier[0]))
			return false;
		for (char c : identifier)
			if (!Character.isJavaIdentifierPart(c))
				return false;
		
		return true;
	}

}
