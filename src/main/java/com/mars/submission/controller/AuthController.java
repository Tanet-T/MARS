package com.mars.submission.controller;

import com.mars.submission.reposotiry.model.User;
import com.mars.submission.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm() {
        return "login";
    }

    @PostMapping
    public ModelAndView check(@RequestParam String username, @RequestParam String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        userService.registerUser(user);
        return new ModelAndView("redirect:/admin");
    }
}