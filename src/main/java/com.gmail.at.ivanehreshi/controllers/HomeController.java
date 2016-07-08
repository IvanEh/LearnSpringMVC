package com.gmail.at.ivanehreshi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "redirect:index.html" ;
    }

    @GetMapping("/index.html")
    public String index() {
        System.out.println("TEST");
        return "index";
    }

    /**
     * Maps /index as well as /index.htm
     */
    @GetMapping("/index")
    @ResponseBody
    public String indexDir() {
        return "<Error> Check index.html";
    }

    @GetMapping("/**/q")
    @ResponseBody
    public String q() {
        return "qq";
    }
}
