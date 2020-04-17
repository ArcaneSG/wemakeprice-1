package com.keb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CharacterUtil {
	
	public static String sort(String input) {
		List<CharacterManager> managers = new ArrayList<>();
		managers.add(new CharacterManager("AaBbCcDdFfGgHhIiJjKkJjLlMmNnOoPpQqRrSsPpUuVvWwXxYyZz"));
		managers.add(new CharacterManager("0123456789"));
		
        input.chars().forEach(c -> {
        	managers.forEach(m -> m.setCountFromChar(c));
        });
        
        managers.forEach(m -> m.setCharacterListFromCount());
        
        return merge(managers).stream().map(String::valueOf).collect(Collectors.joining());
    }
	
	
	private static List<Character> merge(List<CharacterManager> managers) {
		List<Character> characters = new ArrayList<>();
		
		int maxSize = managers.stream().mapToInt(m -> m.getCharacterList().size()).max().getAsInt();
		for(int i = 0; i < maxSize; i++) {
			for(int j = 0; j < managers.size(); j++) {
				Optional.ofNullable(managers.get(j).getNextCharacter()).ifPresent(c -> characters.add(c));
			}
		}
		
		return characters;
	}
}

