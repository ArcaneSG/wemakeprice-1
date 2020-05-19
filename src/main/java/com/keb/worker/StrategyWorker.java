package com.keb.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keb.converter.StringConverter;
import com.keb.dto.OutputVO;
import com.keb.sorter.AbstractSorter;
import com.keb.sorter.DefaultSorter;
import com.keb.util.HttpConnectionUtil;

public class StrategyWorker {
	private Logger logger = LoggerFactory.getLogger(StrategyWorker.class);
	
	private StringConverter converter;
	
	private AbstractSorter sorter;
	
	private String url;
	
	private int bundle;
	
	public StrategyWorker(StringConverter converter, String url, int bundle) {
		this.converter = converter;
		this.url = url;
		this.bundle = bundle;
		
		this.sorter = new DefaultSorter();
	} 
	
	public StrategyWorker(StringConverter converter, String url, String bundle) {
		this(converter, url, Integer.parseInt(bundle));
	} 
	
	public OutputVO getResult() {
		String htmlStr = HttpConnectionUtil.httpConnection(url);
    	String convertStr = converter.convert(htmlStr);
    	String sortedStr = sorter.getResult(convertStr);
    	
    	logger.info("working done : url=" + url + " htmlStrLength=" + htmlStr.length() + " convertStrLength=" + convertStr.length() 
		+ " sortedStrLength=" + sortedStr.length() + " bundle=" + bundle);
    	
    	int cutIndex = sortedStr.length() - ((bundle == 0) ? 0 : sortedStr.length()%bundle);
    	OutputVO outputVO = new OutputVO(sortedStr, cutIndex, url);
    	
    	logger.info("result : " + outputVO.getLogging());
    	
    	return outputVO;
	}
	
}
