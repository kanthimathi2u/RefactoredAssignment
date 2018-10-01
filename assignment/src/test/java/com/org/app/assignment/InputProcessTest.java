package com.org.app.assignment;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.org.app.input.InputProcess;

public class InputProcessTest {
	private InputProcess inProcess;
	
	String filePath;
	String filePath1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		filePath = "testInput";
		filePath1 = "src/test/resources/testInput";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testInProcessNegTest1(){
		try {
			inProcess.ProcessFile(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals("testInput (The system cannot find the file specified)", e.getMessage());
		}
    }
	
	@SuppressWarnings("static-access")
	@Test
	public void testInProcessPosTest1(){
		try {
			System.out.println(new File(filePath1).getAbsolutePath());
			inProcess.ProcessFile(filePath1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//assertEquals("testInput (The system cannot find the file specified)", e.getMessage());
		}
    }
}
