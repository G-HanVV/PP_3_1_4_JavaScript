package ru.truecasper.javascript.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.truecasper.javascript.services.UserService;

import java.security.Principal;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPage(ModelMap model, Principal principal) {
        model.addAttribute("user", userService.getUser(principal.getName()));
        return "admin";
    }

    @GetMapping("/user")
    public String userPage(ModelMap model, Principal principal) {
        model.addAttribute("user", userService.getUser(principal.getName()));
        return "user";
    }
}
