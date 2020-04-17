package com.keb.util;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
	private String chars;
	
	private int[] count;
	
	private List<Character> characterList;
	
	private int characterListSize;
	
	private int currentIndex;

	public CharacterManager(String chars) {
		this.chars = chars;
		this.count = new int[chars.length()];
		this.characterList = new ArrayList<>();
		this.characterListSize = 0;
		this.currentIndex = 0;
	}

	public String getChars() {
		return chars;
	}

	public int[] getCount() {
		return count;
	}
	
	public List<Character> getCharacterList() {
		return characterList;
	}
	
	public int getCharacterListSize() {
		return characterListSize;
	}
	
	public void setCountFromChar(int c) {
		int index = chars.indexOf((char) c);
		
		if(index >= 0) {
			count[index]++;
		}
	}
	
	public void setCharacterListFromCount() {
		for(int i = 0; i < count.length; i++) {
			if(count[i] > 0) {
				char ch = (char) chars.charAt(i);
				for(int j = 0; j < count[i]; j++) {
					characterList.add(ch);
				}
			}
		}
		
		currentIndex = 0;
		characterListSize = characterList.size();
	}
	
	public Character getNextCharacter() {
		if(currentIndex < characterListSize) {
			return characterList.get(currentIndex++);
		}
		
		return null;
	}
}
