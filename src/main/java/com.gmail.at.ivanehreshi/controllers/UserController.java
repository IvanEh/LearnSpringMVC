package com.gmail.at.ivanehreshi.controllers;

import com.gmail.at.ivanehreshi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Target: the most 'specific' match
 * What does specific mean?
 * - less URI variables
 * - less wildcards (** counts as two entries)
 * - longer URI
 * - /** is less specific then other patterns
 * - /prefix-pattern/** is less specific than any other with
 *  the given prefix
 */
@Controller
@RequestMapping("/user")
public class UserController {
    Map<String, User> users = new HashMap<>();
    {
        User user = new User("fake_user", "passw0rd", 19);
        users.put(user.getName(), user);
    }

    /**
     * Invoked before mapping
     */
    @ModelAttribute(value = "date")
    public String date() {
        return new Date().toString();
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("userNamesStr", String.join(", ", users.keySet()));
        return "users";
    }

    /**
     *  "date" property still available in jsp
     *  "user" can be accessed too(e.g. user.name)
     */
    @GetMapping("/{user}")
    public ModelAndView userInfo(@PathVariable String user) {
        return new ModelAndView("user", "user", users.get(user));
    }

    @GetMapping("/new")
    public String addUserGet() {
        return "newUser";
    }

    @PostMapping("/new")
    public String addUser(@RequestParam String name, @RequestParam int age) {
        User newUser = new User(name, "password", age);
        users.put(newUser.getName(), newUser);
        return "redirect:/user/" + name;
    }

}
