package com.gmail.at.ivanehreshi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UriController {

    @GetMapping("/uri/{var1}/{var2}")
    public String uriNav(Model model) {
        UriComponents uriComponents =
                MvcUriComponentsBuilder.fromMethodName(HomeController.class, "home")
                .scheme("xttp").build().encode();
        model.addAttribute("uri", uriComponents.toString());

        return "uriNav";
    }

    @PostMapping("/uri/{var1}/{var2}")
    public String uriNavRedirect(HttpServletRequest request,
                                 @RequestParam String var1,
                                 @RequestParam String var2) {

        UriComponents uriComponents =
                UriComponentsBuilder.fromPath("/uri/{var1}/{var2}")
                .build();
        uriComponents = uriComponents.expand(var1, var2);
        return "redirect:" + uriComponents.getPath();
    }

}
