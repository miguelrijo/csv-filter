package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

/**
 * This class is responsible of the values  validation  
 * @author Miguel Rijo
 */

public class Validator {

	public final static String DATEPATTERN = "([1-2][0-9][0-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])";

	/* verify the length of a string */

	public static boolean verifyLenghtOfString(int lenght, String stringToVerify) {
		if (stringToVerify.toCharArray().length < lenght) {
			return false;
		}
		return true;
	}

	/*
	 * method used to verify the date. For example 2011-02-29... it is a wrong
	 * date and the method is going to return false
	 * 
	 * @throws ParseException
	 */

	public static boolean verifyDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/*
	 * this is a method with the purpose to transform the Hyphen character to
	 * the slash character
	 */

	public static String transformHyphenToSlash(String original) {
		String transformed = "";
		char[] dateChar = original.toCharArray();

		for (int counter = 0; dateChar.length > counter; counter++) {
			if (String.valueOf(dateChar[counter]).equals("-")) {
				transformed += "/";
			} else {
				transformed += dateChar[counter];
			}
		}
		return transformed;
	}

	/*
	 * method used to verify a pattern as date yyyy-mm-yy
	 */

	public static boolean verifyPattern(String pattern, String stringToVerify) {
		boolean verify = Pattern.matches(pattern, stringToVerify);
		return verify;
	}

}
