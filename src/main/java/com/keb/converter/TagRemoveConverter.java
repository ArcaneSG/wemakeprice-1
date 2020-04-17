package com.keb.converter;

public class TagRemoveConverter implements StringConverter {

	@Override
	public String convert(String input) {
		return input.replaceAll("\\<.*?\\>", "");
	}

}
