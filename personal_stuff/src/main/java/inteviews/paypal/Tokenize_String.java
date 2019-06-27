package inteviews.paypal;

import java.util.ArrayList;

public class Tokenize_String {
	/**
	 * tokenize a string by space. but if input string contain anything in " " then
	 * do not tokenize it. i.e everything inside the " " become one token.
	 */

	public static void main(String[] args) {
		String input = "test \" test1 test12\" test3 ";
		System.out.println("input is : " + input);
		System.out.println("tokens are : ");
		System.out.println(tokenize(input));
	}

	/**
	 * method to tokenize the input
	 */
	public static ArrayList<String> tokenize(String input) {
		boolean start_quotes = false;
		int start_index = 0;
		int end_index = -1;
		boolean extract_token = false;
		ArrayList<String> tokens = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			// if current char is "
			if (input.charAt(i) == '"') {
				// if we are looking at closing double quotes ( i.e this is closing quotes)
				if (start_quotes == true) {
					extract_token = true;
					end_index = i + 1; // include double quotes
					start_quotes = false;
				} else {
					start_quotes = true;
					extract_token = false; // no extracting of tokens
				}
				// if current char is a space , and it is not inside double quoted string ""
			} else if (input.charAt(i) == ' ' && start_quotes == false) {
				end_index = i; // do not include space
				extract_token = true;
			}
			// extract token
			if (extract_token == true) {
				// avoid single space string
				if (!(start_index == end_index && input.charAt(start_index) == ' '))
					tokens.add(input.substring(start_index, end_index));
				extract_token = false;
				start_index = i + 1; // next char is
			}
		}
		return tokens;
	}
}
