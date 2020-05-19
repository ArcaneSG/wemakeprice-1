package com.keb.converter;

public enum ConverterType {
	TAG_REMOVE("태그제거", "\\<.*?\\>"),
	ONLY_TEXT("TEXT만", "[^0-9a-zA-Z]");
	
	private final String description;
	
	private final String regex;

	ConverterType(String description, String regex) {
		this.description = description;
		this.regex = regex;
	}

	public String getDescription() {
		return description;
	}
	
	public String getRegex() {
		return regex;
	}
}
