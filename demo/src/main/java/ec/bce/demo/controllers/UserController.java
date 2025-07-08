package ec.bce.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import ec.bce.demo.entities.User;
import ec.bce.demo.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User usuarioencontrado = userService.getUserById(id);
        if (usuarioencontrado != null) {
            return userService.update(user);
        }
        return usuarioencontrado;
    }

    @PatchMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.delete(userId);
    }

}
