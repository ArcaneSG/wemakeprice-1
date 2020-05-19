package com.keb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.converter.ConverterType;
import com.keb.dto.InputVO;
import com.keb.dto.OutputVO;
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
    public @ResponseBody OutputVO url(@RequestBody InputVO params) throws Exception {
    	return new StrategyWorker(params).getResult();
    }    
}