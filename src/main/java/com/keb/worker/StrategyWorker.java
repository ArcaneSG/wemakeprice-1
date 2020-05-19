package com.keb.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.keb.converter.ConverterType;
import com.keb.dto.InputVO;
import com.keb.dto.OutputVO;
import com.keb.sorter.AbstractSorter;
import com.keb.sorter.DefaultSorter;
import com.keb.util.HttpConnectionUtil;

public class StrategyWorker {
	private Logger logger = LoggerFactory.getLogger(StrategyWorker.class);
	
	private AbstractSorter sorter;
	
	private InputVO inputVO;
	
	public StrategyWorker(InputVO inputVO) {
		this.inputVO = inputVO;
		
		this.sorter = new DefaultSorter();
	}  
	
	public OutputVO getResult() {
		String url = inputVO.getUrl();
		ConverterType converterType = inputVO.getType();
		int bundle = inputVO.getBundle();
		 
		String htmlStr = HttpConnectionUtil.httpConnection(url);
    	String convertStr = htmlStr.replaceAll(converterType.getRegex(), "");
    	String sortedStr = sorter.getResult(convertStr);
    	
    	logger.info("working done : url=" + url + " htmlStrLength=" + htmlStr.length() + " convertStrLength=" + convertStr.length() 
		+ " sortedStrLength=" + sortedStr.length() + " bundle=" + bundle);
    	
    	int cutIndex = sortedStr.length() - ((bundle == 0) ? 0 : sortedStr.length()%bundle);
    	OutputVO outputVO = new OutputVO(sortedStr, cutIndex, url);
    	
    	logger.info("result : " + outputVO.getLogging());
    	
    	return outputVO;
	}
	
}
