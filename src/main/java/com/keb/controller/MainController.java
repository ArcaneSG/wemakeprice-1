package com.keb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keb.util.HttpConnectionUtil;
 
@Controller
public class MainController {
 
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
    
    @RequestMapping("/url")
    public @ResponseBody String url() throws Exception {
        return HttpConnectionUtil.httpConnection("https://www.naver.com");
    }
    
}