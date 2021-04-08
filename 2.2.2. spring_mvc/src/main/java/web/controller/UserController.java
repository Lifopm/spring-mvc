package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, @RequestParam String roleId) {
        modifyUserRole(user, roleId);
        userService.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(ModelAndView modelAndView, @PathVariable("id") int id) {
        userService.delete(id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView adminView(Principal principal) {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        modelAndView.addObject("users", users);
        modelAndView.addObject("currentuser", userService.getByEmail(principal.getName()));

        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPage(Principal principal) {
        User user = userService.getByEmail(principal.getName());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    private void modifyUserRole(User user, String roleId) {
        String[] sRoles = roleId.split(",");
        Collection roles = new ArrayList();
        for(int i = 0; i < sRoles.length; i++) {
            Role role = new Role(sRoles[i]);
            roles.add(role);
        }

        user.setRoles(roles);

    }

}
