package com.keb.sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultSorter extends AbstractSorter {
	
	private List<CharacterManager> managers;
	
	private List<Character> characters;
	
	public List<CharacterManager> getManagers() {
		return managers;
	}

	@Override
	void init(String input) {
		super.init(input);
		
		managers = new ArrayList<>();
		managers.add(new CharacterManager("AaBbCcDdFfGgHhIiJjKkJjLlMmNnOoPpQqRrSsPpUuVvWwXxYyZz"));
		managers.add(new CharacterManager("0123456789"));
	}


	@Override
	void sort() {
		input.chars().forEach(c -> {
        	managers.forEach(m -> m.setCountFromChar(c));
        });
        
        managers.forEach(m -> m.setCharacterListFromCount());
	}


	@Override
	void merge() {
		characters = new ArrayList<>();
		
		int maxSize = managers.stream().mapToInt(m -> m.getCharacterList().size()).max().getAsInt();
		for(int i = 0; i < maxSize; i++) {			
			managers.stream().forEach(m -> Optional.ofNullable(m.getNextCharacter()).ifPresent(c -> characters.add(c)));
		}
	}


	@Override
	void setOutput() {
		output = characters.stream().map(String::valueOf).collect(Collectors.joining());
	}

}
