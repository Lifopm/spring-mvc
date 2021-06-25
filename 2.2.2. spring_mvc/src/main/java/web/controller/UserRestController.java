package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/current")
    public User getCurrentUser(Principal principal) {
        User user = userService.getByEmail(principal.getName());
        return user;
    }

    @RequestMapping(value = "/users")
    public List<User> getAllUsers(Principal principal) {
        List<User> users = userService.allUsers();
        return users;
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping(value = "/add") // /user
    public User addUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @PutMapping(value = "/users/{id}")
    public User EdiUser(@RequestBody User user, @PathVariable("id") int id) {
        userService.add(user);
        User user2 = userService.findById(user.getId());
        return user2;
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteUser(ModelAndView modelAndView, @PathVariable("id") int id) {
        userService.delete(id);
        modelAndView.setViewName("redirect:/admin");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
