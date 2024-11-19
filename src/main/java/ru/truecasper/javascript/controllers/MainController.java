package ru.truecasper.javascript.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.truecasper.javascript.models.User;
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
        System.out.println(" --- MainController.adminPage");
        User user = userService.getUser(principal.getName());
        model.addAttribute("user", user);
        return "admin13";
    }

    @GetMapping("/user")
    public String userPage(ModelMap model, Principal principal) {
        System.out.println(" --- MainController.userPage");
        User user = userService.getUser(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}
