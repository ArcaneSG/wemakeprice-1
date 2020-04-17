package com.keb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.converter.ConverterType;
import com.keb.converter.OnlyTextConverter;
import com.keb.converter.TagRemoveConverter;
import com.keb.util.HttpConnectionUtil;
 
@Controller
public class MainController {
 
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping("/url")
    public @ResponseBody String url(String url, String type) throws Exception {
    	url = (url == null) ? "https://www.naver.com" : url;
    	type = (type == null) ? "ONLY_TEXT" : type;
    	//enum에 없을 경우 에러처리해야함
    	
    	if(ConverterType.TAG_REMOVE.equals(ConverterType.valueOf(type))) {
    		return new TagRemoveConverter().convert(HttpConnectionUtil.httpConnection(url));
    	}
    	
    	return new OnlyTextConverter().convert(HttpConnectionUtil.httpConnection(url));
    	
    }
    
}