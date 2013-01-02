package org.slstudio.vigenere;

public class Runner {
	public static void main(String[] args) {
		if (args.length != 3){
			printUsage();
			return;
		}
		String inputStr = args[1];
		String cipher = args[2];
		if("-e".equalsIgnoreCase(args[0])){
			System.out.println(Runner.encrypt(args[1], args[2]));
		}else if("-d".equalsIgnoreCase(args[0])){
			System.out.println(Runner.decrypt(args[1], args[2]));
		}else{
			printUsage();
		}
		
	}
	
	private static void printUsage(){
		System.out.println("Usage: Runner -e <srouce string> <cipher> " +
				"//Encrypt source string with the cipher by vigenere algorithm;");
		System.out.println("       Runner -d <encrypted string> <cipher> " +
				"//Decrypt encrypted string with the cipher by vigenere algorithm;");
	}
	
	public static String encrypt(String sourceStr, String cipher){
		StringBuffer result = new StringBuffer();
		for(int i = 0, j = 0; i < sourceStr.length(); i++) {
			char srcChar = sourceStr.toUpperCase().charAt(i);
			if((srcChar >= 'A') && (srcChar <= 'Z')){
				char cipherChar = cipher.toUpperCase().charAt(j % cipher.length());
				result.append((char)((((cipherChar - 'A') + (srcChar - 'A')) % 26) + 'A'));
				j++;
			}else{
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	public static String decrypt(String encryptedStr, String cipher){
		StringBuffer result = new StringBuffer();
		for(int i = 0, j = 0; i < encryptedStr.length(); i++) {
			char encChar = encryptedStr.toUpperCase().charAt(i);
			if((encChar >= 'A') && (encChar <= 'Z')){
				char cipherChar = cipher.toUpperCase().charAt(j % cipher.length());
				result.append((char)(((encChar + 26 - cipherChar) % 26) + 'A'));
				j++;
			}else{
				result.append(" ");
			}
		}
		return result.toString();
	}

}
