package com.keb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CalculateUtil {
	private static CharacterManager englishManager = new CharacterManager("AaBbCcDdFfGgHhIiJjKkJjLlMmNnOoPpQqRrSsPpUuVvWwXxYyZz");
	private static CharacterManager numberManager = new CharacterManager("0123456789");
	
	public static String calculate(String input) {        
        input.chars().forEach(c -> {
        	englishManager.setCountFromChar(c);
        	numberManager.setCountFromChar(c);
        });
        
        englishManager.setCharacterListFromCount();
        numberManager.setCharacterListFromCount();
        
        return merge().stream().map(String::valueOf).collect(Collectors.joining());
    }
	
	
	private static List<Character> merge() {
		List<Character> characters = new ArrayList<>();
		
		int engSize = englishManager.getCharacterListSize();
		int numSize = numberManager.getCharacterListSize();
		for(int i = 0; i < engSize + numSize; i++) {
			Optional.ofNullable(englishManager.getNextCharacter()).ifPresent(c -> characters.add(c));
			Optional.ofNullable(numberManager.getNextCharacter()).ifPresent(c -> characters.add(c));
		}
		
		return characters;
	}
}

