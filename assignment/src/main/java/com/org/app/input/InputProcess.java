package com.org.app.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.org.app.assignment.resources.Constants;
import com.org.app.conversion.RomanToDecimalNum;
import com.org.app.assignment.info.AssignmentInfo;
	
public class InputProcess{

	/**
	 * Below are sample of the kind of values each map would hold.
	 * tokenRomanValueMapping : {glob=I, prok=V, pish=X, tegj=L}
	 * tokenIntegerValue :{glob=1, prok=5, pish=10, tegj=50}
	 * questionAndReply :{how much is pish tegj glob glob ?, how many Credits is glob prok Silver ?, How many Credits is glob prok Gold ?, How many Credits is glob prok Iron ?, How much wood could a woodchuck chuck if a woodchuck could chuck= wood ?}
	 * missingValues :[glob glob Silver is 34 Credits, glob prok Gold is 57800 Credits, pish pish Iron is 3910 Credits]
	 * elementValueList :{Gold=14450, Iron=195, Silver=17}	
	 */
	
	protected static Map<String, String> tokenRomanValueMapping = AssignmentInfo.setTokenMapping();
	protected static Map<String, String> questionAndReply = AssignmentInfo.setQnR();
	protected static ArrayList<String> missingValues = AssignmentInfo.setMissedVals();
	
	static Map<String, Integer> tokenIntegerValue = new LinkedHashMap<String, Integer>(); //{pish=10.0, tegj=50.0, prok=5.0, glob=1.0}
	//protected static Map<String, String> questionAndReply = new LinkedHashMap<String, String>();  //{how much is pish tegj glob glob ?, how many Credits is glob prok Iron ?}
	//protected static ArrayList<String> missingValues = new ArrayList<String>(); // [glob glob Silver is 34 Credits, glob prok Gold is 57800 Credits, pish pish Iron is 3910 Credits]
	protected static Map<String, Integer> elementValueList = new LinkedHashMap<String, Integer>(); //{Gold=14450.0, Iron=195.5, Silver=17.0}
	
	/**
	 * if file path is specified that is picked up else by default Input inside the same package is pickedup.
	 * Each line is picked up and served to processLine() for processing.
	 * @param filePath
	 * @throws IOException
	 */
	public static void ProcessFile(String filePath) throws IOException {
		BufferedReader bufferedReader = null;
		if (filePath == null){
			InputStream in = InputProcess.class.getResourceAsStream(Constants.default_filePath);
			bufferedReader =new BufferedReader(new InputStreamReader(in));
		}
		else{
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
		}
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			processLine(line);
		}
		bufferedReader.close();
	}

	/**
	 * processline adds the input to various maps<K,T> based on different conditions.
	 * @param line
	 */
	public static void processLine(String line){
		String arr[] = line.split("((?<=:)|(?=:))|( )");
		if (line.endsWith("?")){
			questionAndReply.put(line,"");
		}
		else if (arr.length == 3 && arr[1].equalsIgnoreCase("is")){
			tokenRomanValueMapping.put(arr[0], arr[arr.length-1]);
		}
		else if(line.toLowerCase().endsWith("credits")){
			missingValues.add(line);
		}
	}

	/**
	 * Maps tokens to Integer equivalent  
	 * {pish=10, tegj=50, prok=5, glob=1}
	 */
	@SuppressWarnings("rawtypes")
	public static void MapTokentoIntegerValue(){
		Iterator it = AssignmentInfo.tokenMapping.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry token = (Map.Entry)it.next();
			int integerValue = new RomanToDecimalNum().romanToDecimal(token.getValue().toString());
			tokenIntegerValue.put(token.getKey().toString(), integerValue);
		}
		mapMissingEntities();
	}

	/**
	 * Finds the value of elements by decoding queries like [glob glob Silver is 34 Credits]
	 */
	private static void mapMissingEntities(){
		for (int i = 0; i < missingValues.size(); i++) {
			deCodeMissingQuery(missingValues.get(i));
		}
	}

	/**
	 * Calculates the values of various elements and appends the same to map elementValueList.
	 * elementValueList :{Gold=14450, Iron=195, Silver=17}
	 * @param query
	 */
	private static void deCodeMissingQuery(String query){
		String array[] = query.split("((?<=:)|(?=:))|( )");
		int splitIndex = 0;
		int creditValue = 0; String element= null; String[] valueofElement = null;
		for (int i = 0; i < array.length; i++) {
			if(array[i].toLowerCase().equals("credits")){
				creditValue = Integer.parseInt(array[i-1]);
			}
			if(array[i].toLowerCase().equals("is")){
				splitIndex = i-1;
				element = array[i-1];
			}
			valueofElement = java.util.Arrays.copyOfRange(array, 0, splitIndex);
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0; j < valueofElement.length; j++) {
			stringBuilder.append(AssignmentInfo.tokenMapping.get(valueofElement[j]));
		}
		int valueOfElementInDecimal = new RomanToDecimalNum().romanToDecimal(stringBuilder.toString());
		elementValueList.put(element, creditValue/valueOfElementInDecimal);
	}

}