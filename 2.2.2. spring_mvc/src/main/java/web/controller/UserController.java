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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, @RequestParam String roleId) {

        String[] sRoles = roleId.split(",");
        Collection roles = new ArrayList();
        for(int i = 0; i < sRoles.length; i++) {
            Role role = new Role(sRoles[i]);
            roles.add(role);
        }

        user.setRoles(roles);

        userService.add(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        userService.delete(id);
        return modelAndView;
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView adminView() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPage");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPage(Principal principal) {
        User user = userService.getByName(principal.getName());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPage");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

}
