package com.keb.dto;

public class OutputVO {
	private String quotient;
	
	private String rest;
	
	private String url;
	
	public OutputVO(String sortedStr, int cutIndex, String url) {
		this.quotient = sortedStr.substring(0, cutIndex);
		this.rest = sortedStr.substring(cutIndex);
		this.url = url;		
	}

	public String getQuotient() {
		return quotient;
	}

	public String getRest() {
		return rest;
	}

	public String getUrl() {
		return url;
	}
	
	public String getLogging() {
		return "quotientSize=" + this.quotient.length() + " restSize=" + this.rest.length() + " url=" + this.url;
	}
}
