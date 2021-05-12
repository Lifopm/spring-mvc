package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/login"})
    public ModelAndView loginView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");

        return modelAndView;
    }

    @GetMapping(value="/admin")
    public ModelAndView adminView(Principal principal) {

        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        modelAndView.addObject("users", users);
        modelAndView.addObject("currentuser", userService.getByEmail(principal.getName()));

        return modelAndView;
    }

    @GetMapping(value = "/user")
    public ModelAndView userPage(Principal principal) {
        User user = userService.getByEmail(principal.getName());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
