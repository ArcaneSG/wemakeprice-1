package com.keb.worker;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keb.converter.StringConverter;
import com.keb.util.CharacterUtil;
import com.keb.util.HttpConnectionUtil;

public class StrategyWorker {
	private Logger logger = LoggerFactory.getLogger(StrategyWorker.class);
	
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
    	
    	logger.info("working done : url=" + url + " htmlStrLength=" + htmlStr.length() + " convertStrLength=" + convertStr.length() 
    					+ " sortedStrLength=" + sortedStr.length() + " bundle=" + bundle);
    	
    	return model;
	}
	
}
