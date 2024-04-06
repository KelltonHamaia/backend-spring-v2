package com.mkt.dev.backendspring.controller;

import com.mkt.dev.backendspring.model.User;
import com.mkt.dev.backendspring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserServices userServices;
    @PostMapping(path="/add")
    public String createNewUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date birthday,
            @RequestParam String password)
    {
        return userServices.createNewUser(name, email, password, birthday);
    };

    @PostMapping(path = "/login")
    public Boolean loginUser( @RequestParam String email, @RequestParam String password) {
        return userServices.loginUser(email, password);
    }

    @PostMapping(path = "/update")
    public String updateUser(
            @RequestParam Long id,
            @RequestParam(required = false) String new_name,
            @RequestParam(required = false) String new_email,
            @RequestParam(required = false) String new_password,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date new_birthday)
    {

        return userServices.updateUser(id, new_name, new_email, new_password, new_birthday);
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping(path = "/birthday")
    public Iterable<User> getUsersByBirthdayBetween(
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date offset,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date limit
    ) {
        return userServices.getUsersByBirthdayBetween(offset, limit);
    }
    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    @GetMapping(path = "/lastloggedusers")
    public Iterable<User> getlastLoggedUsers(){
        return userServices.getLastLoggedUsers();
    }

}
