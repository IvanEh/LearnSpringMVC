package com.gmail.at.ivanehreshi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.Random;

@Controller
public class RedirectController {

    @ModelAttribute("redirectStr")
    public String modelAttribute() {
        return "modelAttribute_" + new Random().nextInt(7);
    }

    @GetMapping("/redirectDemo")
    public String redirectDemo(Model model) {
        return "redirectDemo";
    }

    @GetMapping("/redirectDemo/redirect")
    public String redirect() {
        return "redirect:/redirectDemo";
    }

}
