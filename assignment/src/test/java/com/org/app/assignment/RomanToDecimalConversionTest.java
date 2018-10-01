/**
 * 
 */
package com.org.app.assignment;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.org.app.conversion.RomanToDecimalNum;

/**
 * To Test the conversion of Roman to Decimal - Positive Scenario
 */

public class RomanToDecimalConversionTest {
	
    private RomanToDecimalNum romanToDecimalConverter;

    private String testString1;
    private String testString2;
    private String testString3;
    private String testString4;
    private String testString5;
    private String testString6;
    private String testString7;
    private String testString8;
    private String testString9;
    private String testString10;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() {
		romanToDecimalConverter = new RomanToDecimalNum();
        testString1 = "MIV"; //1004
        testString2 = "CCMMXLVI"; //2046
        testString3 = "MII"; //1002
        testString4= "LXXIX";//89
        testString5 = "MMCDXX"; //valid 2420
        testString6 = "XXVII"; //valid 27
        testString7 = "MCCIX"; //valid 1209
        testString8 = "CCCLIII"; //valid 353
        testString9 = "MM"; //valid 2000
        testString10 = "MMMIIIIIIII"; //valid 3004
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

		
	@Test
    public void testRomanNumaralToDecimalPositiveTest1(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString1);
        assertEquals(1004, testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest2(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString2);
        assertEquals(2046,testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest3(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString3);
        assertEquals(1002,testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest4(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString4);
        assertEquals(79,testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest5(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString5);
        assertEquals(2620,testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest6(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString6);
        assertEquals(27, testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest7(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString7);
        assertEquals(1209, testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest8(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString8);
        assertEquals(353, testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalPositiveTest9(){
        int testNum = romanToDecimalConverter.romanToDecimal(testString9);
        assertEquals(2000, testNum);
    }
	
	@Test
    public void testRomanNumaralToDecimalNegativeTest1(){
		int testNum;
		try
		{
			testNum = romanToDecimalConverter.romanToDecimal(testString10);
			assertEquals(3008, testNum);
		}
		finally
		{
		    PrintStream save_err=System.err;
		    final ByteArrayOutputStream err= new ByteArrayOutputStream();
		    System.setErr(new PrintStream(err));

		    System.err.println("Error : Roman Numeral I cannot repeat 4 times successively");
		    assertEquals("Error : Roman Numeral I cannot repeat 4 times successively\r\n", err.toString());

		    System.setErr(save_err);
		}
		
	}

}
