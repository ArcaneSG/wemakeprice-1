package com.keb.worker;

import java.util.HashMap;
import java.util.Map;

import com.keb.converter.StringConverter;
import com.keb.util.CharacterUtil;
import com.keb.util.HttpConnectionUtil;

public class StrategyWorker {
	private StringConverter converter;
	
	private String url;
	
	private int bundle;
	
	public StrategyWorker(StringConverter converter, String url, int bundle) {
		this.converter = converter;
		this.url = url;
		this.bundle = bundle;
	} 
	
	public StrategyWorker(StringConverter converter, String url, String bundle) {
		this(converter, url, Integer.parseInt(bundle));
	} 
	
	public Map<String, Object> getResult() {
		String htmlStr = HttpConnectionUtil.httpConnection(url);
    	String convertStr = converter.convert(htmlStr);
    	String sortedStr = CharacterUtil.sort(convertStr);
    	
    	Map<String, Object> model = new HashMap<>();
    	int cutIndex = sortedStr.length() - ((bundle == 0) ? 0 : sortedStr.length()%bundle);
    	model.put("quotient", sortedStr.substring(0, cutIndex));
    	model.put("rest", sortedStr.substring(cutIndex));
    	model.put("url", url);
    	
    	return model;
	}
	
}
