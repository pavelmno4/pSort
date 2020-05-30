package com.example.pSort.controller;

import com.example.pSort.domain.User;
import com.example.pSort.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")                   //Регистрация пользователя
    public String addUser(User user, Model model) {


        if(!userService.addUser(user)) {
            model.addAttribute("message", "Пользователь уже сущестует!");
            return "registration";
        }


        return "redirect:/login";
    }
}
