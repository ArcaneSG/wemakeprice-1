package com.keb.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.converter.ConverterType;
import com.keb.converter.OnlyTextConverter;
import com.keb.converter.TagRemoveConverter;
import com.keb.dto.InputVO;
import com.keb.worker.StrategyWorker;
 
@Controller
public class MainController {
 
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) throws Exception {
    	model.addAttribute("defaultInputVO", new InputVO("https://www.naver.com", ConverterType.TAG_REMOVE, 30));
    	model.addAttribute("converterTypes", ConverterType.values());
    	
        return "index";
    }
    
    @RequestMapping(value="/url", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> url(@RequestBody InputVO params) throws Exception {
    	if(ConverterType.TAG_REMOVE.equals(params.getType())) {
    		return new StrategyWorker(new TagRemoveConverter(), params.getUrl(), params.getBundle()).getResult();
    	}
    	
    	return new StrategyWorker(new OnlyTextConverter(), params.getUrl(), params.getBundle()).getResult();
    }    
}