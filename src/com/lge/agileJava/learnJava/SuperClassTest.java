package com.lge.agileJava.learnJava;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuperClassTest {
	@Test
	public void testConstructorCalls() {
		SuperClass superClass = new SubClass("parm");
		assertTrue(SuperClass.constructorWasCalled);
	}

}
