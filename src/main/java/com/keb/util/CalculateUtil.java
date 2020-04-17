package com.keb.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateUtil {
	private static String ENGLISH_CHARS = "AaBbCcDdFfGgHhIiJjKkJjLlMmNnOoPpQqRrSsPpUuVvWwXxYyZz";
	private static String NUMBER_CHARS = "0123456789";
	
	public static String calculate(String input) {
        int[] englishCount = new int[ENGLISH_CHARS.length()];
        int[] numberCount = new int[NUMBER_CHARS.length()];
        
        input.chars().forEach(c -> {
        	int englishIndex = ENGLISH_CHARS.indexOf(c);
        	int numberIndex = NUMBER_CHARS.indexOf(c);
        	
        	if(englishIndex >= 0) {
        		englishCount[englishIndex]++;
        	}
        	
        	if(numberIndex >= 0) {
        		numberCount[numberIndex]++;
        	}
        });
        
        System.out.println(Arrays.toString(englishCount));
        System.out.println(Arrays.toString(numberCount));
        
        System.out.println(merge(getCharacterList(englishCount, ENGLISH_CHARS), getCharacterList(numberCount, NUMBER_CHARS))
        						.stream().map(String::valueOf).collect(Collectors.joining()));
        
        return "";
    }
	
	private static List<Character> getCharacterList(int[] arr, String str) {
		List<Character> characters = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				char ch = (char) str.charAt(i);
				for(int j = 0; j < arr[i]; j++) {
					characters.add(ch);
				}
			}
		}
		
		return characters;
	}
	
	private static List<Character> merge(List<Character> englishs, List<Character> num) {
		List<Character> characters = new ArrayList<>();
		
		int engSize = englishs.size();
		int numSize = num.size();
		int engIndex = 0;
		int numIndex = 0;
		for(int i = 0; i < engSize + numSize; i++) {
			if(engIndex < engSize) {
				characters.add(englishs.get(engIndex++));
			}
			if(numIndex < numSize) {
				characters.add(num.get(numIndex++));
			}
		}
		
		return characters;
	}
	
	public static void main(String[] args) {
		CalculateUtil.calculate("gdafdsafdsafa");
	}
}
