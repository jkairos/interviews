package com.studies.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostFixTest {

	@Test
	public void test() {
		String infix = "a+b";
		InfixToPostFix infixToPostfix = new InfixToPostFix();
		assertEquals("ab+",infixToPostfix.convertInfixToPosFix(infix));
		assertEquals("ac+hb/r*-",infixToPostfix.convertInfixToPosFix("a+c-h/b*r"));
		assertEquals("abc-+",infixToPostfix.convertInfixToPosFix("a+(b-c)"));
		assertEquals("ach-br*/+",infixToPostfix.convertInfixToPosFix("a+(c-h)/(b*r)"));
	}

}
