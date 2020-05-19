package com.keb.dto;

import com.keb.converter.ConverterType;

public class InputVO {
	private String url;
	
	private ConverterType type;
	
	private int bundle;
	
	public InputVO() {
	}
	
	public InputVO(String url, String type, String bundle) {
		this(url, ConverterType.valueOf(type), Integer.parseInt(bundle));
	}
	
	public InputVO(String url, ConverterType type, int bundle) {
		this.url = url;
		this.type = type;
		this.bundle = bundle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ConverterType getType() {
		return type;
	}

	public void setType(ConverterType type) {
		this.type = type;
	}

	public int getBundle() {
		return bundle;
	}

	public void setBundle(int bundle) {
		this.bundle = bundle;
	}
}
