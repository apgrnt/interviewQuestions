package utils;

import java.util.*;

public class StringUtilsExt {

	char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	public static boolean dupChars(String str) {
		Set<Character> set = new HashSet<Character>();
		for(char c : str.toCharArray()){
			if(set.contains(c)){
				return true;
			} else {
				set.add(c);
			}
		}
		return false;
	}

	public static boolean arePermutations(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		Map<Character, Integer> str1CharCount = new HashMap();
		for(char c : str1.toCharArray()){
			if(str1CharCount.containsKey(c)){
				int i = str1CharCount.get(c);
				str1CharCount.put(c, i++);
			} else {
				str1CharCount.put(c, 1);
			}
		}
		for(char c : str2.toCharArray()) {
			if(str1CharCount.containsKey(c)){
				int i = str1CharCount.get(c);
				i--;
				if(i > 0){
					return false;
				}
				str1CharCount.put(c, i);
			}else{
				return false;
			}
		}
		return true;
	}

	public static boolean arePermutations2(String str1, String str2) {
		if(str1.length() != str2.length()){
			return false;
		}
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		String sortedStr1 = new String(str1Arr);
		String sortedStr2 = new String(str2Arr);

		if(sortedStr1.equalsIgnoreCase(sortedStr2)){
			return true;
		}
		return false;
	}

	public static boolean oneEditAway(String string1, String string2) {
	    if(string1.equals(string2)){
		return true;
	    } else if (string1.length()+1 < string2.length() || string2.length()-1 > string2.length()){
		return false;
	    } else if (string1.length() == string2.length()){
		char[] str1Arr = string1.toCharArray();
		char[] str2Arr = string2.toCharArray();
		boolean alreadyMadeEdit = false;
		for(int i = 0; i < string1.length(); i++){
		    if(str1Arr[i] == str2Arr[i]){
			continue;
		    } else if (alreadyMadeEdit) {
			return false;
		    } else {
			alreadyMadeEdit = true;
			continue;
		    }
		}
		return true;
	    } else {
		//String one is shorter
		if(string1.length()+1 == string2.length()){
		    char[] str1Arr = string1.toCharArray();
		    char[] str2Arr = string2.toCharArray();
		    for(int i = 0; i < str1Arr.length; i++){
			if(str1Arr[i] == str2Arr[i]){
			    continue;
			} else if (str2Arr[i+1] != str1Arr[i]){
			    return false;
			}
		    }
		    return true;
		//String one is longer (or string 2 is shorter)
		} else if (string1.length()-1 == string2.length()){
		    char[] str1Arr = string1.toCharArray();
		    char[] str2Arr = string2.toCharArray();
		    for(int i = 0; i < str2Arr.length; i++){
			if(str1Arr[i] == str2Arr[i]){
			    continue;
			} else if (str1Arr[i+1] != str2Arr[i]){
			    return false;
			}
		    }
		    return true;
		}
		return false;
	    }
	}

	public boolean beautifulString(String inputString) {
		Map<Character, Integer> hitMap = new HashMap<>();
		String sanatizedString = trimWhitespace(inputString).toLowerCase();
		if (sanatizedString.isEmpty()) {
			return true;
		}
		for (Character c : ALPHABET) {
			hitMap.put(c, 0);
		}
		for (Character c : sanatizedString.toCharArray()) {
			hitMap.put(c, hitMap.get(c)+1);
		}
		for (int i = 0; i < ALPHABET.length; i++) {
			if ((i<ALPHABET.length-1) && hitMap.get(ALPHABET[i]) < hitMap.get(ALPHABET[i+1])) {
				return false;
			}
		}
		return true;
	}

	public static String trimWhitespace(String var0) {
		if (var0 == null) {
			return var0;
		} else {
			StringBuffer var1 = new StringBuffer();

			for(int var2 = 0; var2 < var0.length(); ++var2) {
				char var3 = var0.charAt(var2);
				if (var3 != '\n' && var3 != '\f' && var3 != '\r' && var3 != '\t') {
					var1.append(var3);
				}
			}

			return var1.toString().trim();
		}
	}
}
