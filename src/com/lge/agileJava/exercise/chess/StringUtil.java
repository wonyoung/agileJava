package com.lge.agileJava.exercise.chess;

public class StringUtil {
	private StringUtil() { }
	static final String NEWLINE = System.getProperty("line.separator");
	static String appendNewLine(String string) {
		return string + NEWLINE;
	}
}
