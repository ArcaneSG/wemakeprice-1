package com.keb.converter;

public class OnlyTextConverter implements StringConverter {

	@Override
	public String convert(String input) {
		return input.replaceAll("[^0-9a-zA-Z]", "");
	}
}
