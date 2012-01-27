package com.lge.agileJava.exercise.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.lge.agileJava.exercise.chess.BoardTest;
import com.lge.agileJava.exercise.chess.CharacterTest;
import com.lge.agileJava.exercise.pieces.PieceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	BoardTest.class,
	PieceTest.class,
	CharacterTest.class
})

public class AllTests {

}
