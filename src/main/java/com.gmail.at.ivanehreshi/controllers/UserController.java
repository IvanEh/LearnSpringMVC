package com.gmail.at.ivanehreshi.controllers;

import com.gmail.at.ivanehreshi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/{userName}")
    @ResponseBody
    public String userInfo(@PathVariable("userName") String name) {
        User user = users.get(name);
        if(user == null)
            return "No such user";
        return user.toString();
    }
    
    @GetMapping("/new/{userName}/{password},{age:[0-9]+}")
    public String addUser(@PathVariable("userName") String userName,
                          @PathVariable("password") String password,
                          @PathVariable("age") int age) {
        User user = new User(userName, password, age);
        users.put(user.getName(), user);
        return "redirect:/user/" + userName;
    }

}
