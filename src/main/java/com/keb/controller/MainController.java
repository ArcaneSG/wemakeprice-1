package com.keb.controller;

import java.net.URLDecoder;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.converter.ConverterType;
import com.keb.converter.OnlyTextConverter;
import com.keb.converter.TagRemoveConverter;
import com.keb.worker.StrategyWorker;
 
@Controller
public class MainController {
 
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping("/url")
    public @ResponseBody Map<String, Object> url(String url, String type, String bundle) throws Exception {
    	url = (url == null) ? "https://www.naver.com" : URLDecoder.decode(url, "UTF-8");
    	type = (type == null) ? "ONLY_TEXT" : type;
    	bundle = (bundle == null) ? "1" : bundle;
    	//enum에 없을 경우 에러처리해야함
    	
    	if(ConverterType.TAG_REMOVE.equals(ConverterType.valueOf(type))) {
    		return new StrategyWorker(new TagRemoveConverter(), url, bundle).getResult();
    	}
    	
    	return new StrategyWorker(new OnlyTextConverter(), url, bundle).getResult();
//    	System.out.println(url); //로그에 남길 것 url, 결과 길이
    	
    }
    
}