package com.www.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellocONTROLLER {
    @RequestMapping("/")
    public String hello (){
    return "index";
    }
}