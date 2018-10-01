package com.org.app.assignment.info;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class AssignmentInfo{

	public static int decimal;
	public static Map<String, String> QnR;
	public static Map<String, String> tokenMapping;
	public static ArrayList<String> missedVals;

	 public int getDecimal() {
        return decimal;
    }

	 public static void setDecimal(int decimalNum) {
        decimal = decimalNum;
    }
	 
	 public static Map<String, String> setTokenMapping () {
		 return tokenMapping = new LinkedHashMap<String, String>();
	 }
	 
	 public static Map<String, String> setQnR () {
		 return QnR = new LinkedHashMap<String, String>();
	 }
 	
	 public static ArrayList<String> setMissedVals () {
		 return missedVals = new ArrayList<String>();
	 }
 	
 }