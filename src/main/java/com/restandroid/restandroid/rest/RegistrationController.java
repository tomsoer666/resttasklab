package com.restandroid.restandroid.rest;

import com.restandroid.restandroid.model.Role;
import com.restandroid.restandroid.model.User;
import com.restandroid.restandroid.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActivity(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
    @GetMapping("/allusers")
    public List<User> viewUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }
    @GetMapping("/")
    public String home() {
        return "fuck you";
    }
}
