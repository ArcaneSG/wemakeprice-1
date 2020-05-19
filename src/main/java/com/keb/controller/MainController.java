package com.keb.controller;

import java.net.URLDecoder;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.converter.ConverterType;
import com.keb.converter.OnlyTextConverter;
import com.keb.converter.TagRemoveConverter;
import com.keb.worker.StrategyWorker;
 
@Controller
public class MainController {
 
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping(value="/url", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> url(@RequestBody Map<String, Object> params) throws Exception {
    	String url = (String) params.get("url");
    	String type = (String) params.get("type");
    	String bundle = (String) params.get("bundle");
    	if(url == null || type == null || bundle == null) {
    		throw new Exception();
    	}
    	
    	url = URLDecoder.decode(url, "UTF-8");
    	
    	if(ConverterType.TAG_REMOVE.equals(ConverterType.valueOf(type))) {
    		return new StrategyWorker(new TagRemoveConverter(), url, bundle).getResult();
    	}
    	
    	return new StrategyWorker(new OnlyTextConverter(), url, bundle).getResult();
    }    
}