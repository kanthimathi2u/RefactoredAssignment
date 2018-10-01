package com.org.app.output;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.org.app.conversion.RomanToDecimalNum;
import com.org.app.input.InputProcess;

public class OutputProcess extends InputProcess{

	/**
	 * processReplyForQuestion() iterates over the questionAndReply map that contain all the valid queries as keys.
	 * It further invokes processReply() on each key for processing the response.
	 */
	public static void processReplyForQuestion(){
		Map<String, String> map = questionAndReply;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			processReply(entry.getKey());
		}
	}

	private static void processReply(String query){
		if (query.toLowerCase().startsWith("how much")){
			findValueOfRoman(query);
		}
		else if (query.toLowerCase().startsWith("how many")){
			findValueOfElement(query);
		}

	}

	/**
	 * findValueOfRoman() processes those queries seeking the decimal equivalent of any RomanNumeral and prints the result.
	 * @param query
	 */
	public static void findValueOfRoman(String query){
		if (isValidinput(query)== true){
			ArrayList<String> tokenValueToRoman = new ArrayList<String>();
			ArrayList<String> tokenValue = splitQuery(query);
			for (int i = 0; i < tokenValue.size(); i++) {
				tokenValueToRoman.add(InputProcess.tokenRomanValueMapping.get(tokenValue.get(i)));
			}
			int value = new RomanToDecimalNum().romanToDecimal(tokenValueToRoman.toString());
			tokenValue.add("is");tokenValue.add(Integer.toString(value));
			System.out.println(outputFormatter(tokenValue));
		}
		else{
			System.err.println("I have no idea what you are talking about while finding the value of Roman");
		}
	}


	/**
	 * findValueOfElement() processes those queries seeking the Credit value of any quantity of elements and prints the result.
	 * @param query
	 */
	private static void findValueOfElement(String query){
		if (isValidinput(query) == true){
			ArrayList<String> tokenValue = splitQuery(query);
			ArrayList<String> tokenValueToRoman = new ArrayList<String>();
			String element = null;
			for (int i = 0; i < tokenValue.size(); i++) {
				if(InputProcess.tokenRomanValueMapping.get(tokenValue.get(i)) != null){
					tokenValueToRoman.add(InputProcess.tokenRomanValueMapping.get(tokenValue.get(i)));
				}
				else if (elementValueList.get(tokenValue.get(i)) != null){
					element = tokenValue.get(i);
				}
				else{
					System.err.println("I have no idea what you are talking about while finding the value of Element");
				}
			}
			int elementValue = (new RomanToDecimalNum().romanToDecimal(tokenValueToRoman.toString()) * elementValueList.get(element));
			tokenValue.add("is");tokenValue.add(Integer.toString(elementValue));tokenValue.add("Credits");
			System.out.println(outputFormatter(tokenValue));
		}
		else{
			System.err.println("I have no idea what you are talking about");
		}
	}

	/**
	 * Formats the response to a query and displays it in readable format
	 * @param output
	 * @return the formatted output String
	 */
	public static String outputFormatter(ArrayList<String> output){
		return output.toString().replace(",", "").replace("[", "").replace("]", "");
	}

	/**
	 * Applies regex on each input in the file to figure out the valid ones.
	 * @param query
	 * @return boolean value based on the input validity
	 */
	public static boolean isValidinput(String query){
		Pattern regex = Pattern.compile("[$&+,:;=@#|]");
		Matcher matcher = regex.matcher(query);
		if (matcher.find()){
			return false;
		}
		else{
			return true;
		}

	}

	/**
	 * Splits the query and returns an ArrayList containing only Roman numerals and elements
	 * @param query
	 * @return
	 */
	private static ArrayList<String> splitQuery(String query){
		ArrayList<String> queryArray = new ArrayList<String>(Arrays.asList(query.split("((?<=:)|(?=:))|( )")));
		int startIndex = 0, endIndex = 0;
		for (int i = 0; i < queryArray.size(); i++) {
			if(queryArray.get(i).toLowerCase().equals("is")){
				startIndex = i+1;
			}
			else if(queryArray.get(i).toLowerCase().equals("?")){
				endIndex = i;

			}
		}
		String[] array = queryArray.toArray(new String[queryArray.size()]);
		return new ArrayList<String>(Arrays.asList(java.util.Arrays.copyOfRange(array, startIndex, endIndex)));

	}

}

