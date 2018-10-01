package com.org.app.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.org.app.output.OutputProcess;

public class OutputProcessTest {
	
	private OutputProcess opProc;
	
	ArrayList<String> tstStringArray1 = new ArrayList<String>();
	ArrayList<String> tstStringArray2 = new ArrayList<String>();
	ArrayList<String> tstStringArray3 = new ArrayList<String>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tstStringArray1.add("Hello");
		tstStringArray1.add("World");
		
		tstStringArray2.add("Hello &");
		tstStringArray2.add("[World]");
		
		tstStringArray3.add("Hello");
		tstStringArray3.add("[World]");
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testOutputProcessPosTest1(){
		boolean testResult1 = opProc.isValidinput("Test");
        assertEquals(true, testResult1);
    }
	
	@SuppressWarnings("static-access")
	@Test
	public void testOutputProcessNegTest1(){
		boolean testResult2 = opProc.isValidinput("Test#$");
        assertEquals(false, testResult2);
    }
	
	@SuppressWarnings("static-access")
	@Test
	public void testOutputProcessPosTest2(){
		String testResult3 = opProc.outputFormatter(tstStringArray1);
        assertEquals("Hello World", testResult3);
    }
	
	@SuppressWarnings("static-access")
	@Test
	public void testOutputProcessNegTest2(){
		String testResult4 = opProc.outputFormatter(tstStringArray2);
        assertEquals("Hello & World", testResult4);
    }
	
	@SuppressWarnings("static-access")
	@Test
	public void testOutputProcessPosTest3(){
		String testResult4 = opProc.outputFormatter(tstStringArray3);
        assertEquals("Hello World", testResult4);
    }


}
