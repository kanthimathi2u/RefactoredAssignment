package com.org.app.assignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.org.app.rules.Rules;

public class RomanToDecRulesTest {
	
	private Rules romanToDecConRules;
	private Character[] testArray1 = {'D', 'L', 'V'}; 
	private Character testLiteral1;
	private Character testLiteral2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		romanToDecConRules = new Rules();
		testLiteral1 = 'D';
		testLiteral2 = 'M';
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRomToDecConRulesPosTest1(){
        @SuppressWarnings("static-access")
		boolean testResult = romanToDecConRules.checkIfLiteralPresent(testArray1, testLiteral1);
        assertEquals(true, testResult);
    }
	
	@Test
	public void testRomToDecConRulesNegTest2(){
        @SuppressWarnings("static-access")
		boolean testResult = romanToDecConRules.checkIfLiteralPresent(testArray1, testLiteral2);
        assertEquals(false, testResult);
    }


}
