package com.org.app.assignment;

import com.org.app.input.InputProcess;
import com.org.app.output.OutputProcess;

public class AssignmentProgram{

	/**
	 * If no argument is provided then the input file present inside 
	 * com.org.app.assignment.resources package is picked up as input file by default.
	 * @param args
	 */
	public static void main(String[] args) {
		AssignmentProgram testProgram = new AssignmentProgram();
				
		String filePath = null;
		if (args.length != 0)
			filePath = args[0];
		
		testProgram.getStarted(filePath);
	}
	
	public void getStarted(String filePath) {
		try{
			InputProcess.ProcessFile(filePath);
			InputProcess.MapTokentoIntegerValue();
			OutputProcess.processReplyForQuestion();
		}
		catch(Exception e){
			System.out.println("Something went wrong....File Not Found ");
		}
	}

}