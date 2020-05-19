package com.keb.converter;

public enum ConverterType {
	TAG_REMOVE("태그제거"),
	ONLY_TEXT("TEXT만");
	
	private final String description;

	ConverterType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
