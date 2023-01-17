package com.java.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestControllerTest {
	
	@Test
	public void testFuncation(){
		TestController test = new TestController();
		assertEquals("This is the test url",test.testFuncation());
		//assertEquals("This is the test url",test.testFuncation());
	}

}
