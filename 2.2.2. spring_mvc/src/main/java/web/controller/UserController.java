package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
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

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteUser(ModelAndView modelAndView, @PathVariable("id") int id) {
        userService.delete(id);
        modelAndView.setViewName("redirect:/admin");
        return new ResponseEntity<>(HttpStatus.OK);
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

    private void modifyUserRole(User user, String roleId) {
        String[] sRoles = roleId.split(",");
        Collection roles = new ArrayList();
        for(int i = 0; i < sRoles.length; i++) {
            Role role = new Role(sRoles[i]);
            roles.add(role);
        }

        user.setRoles(roles);

    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user = userService.findById(id);

        return user;
    }

    @PostMapping(value = "/users/{id}")
    public ResponseEntity<?>  EdiUser(@RequestBody User user, @PathVariable("id") int id) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users")
    public List<User> getAllUsers(Principal principal) {
        List<User> users = userService.allUsers();

        return users;
    }

    @RequestMapping(value = "/current")
    public User getCurrentUser(Principal principal) {
        User user = userService.getByEmail(principal.getName());

        return user;
    }
}
