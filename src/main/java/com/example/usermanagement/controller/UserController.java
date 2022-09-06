package com.example.usermanagement.controller;


import com.example.usermanagement.domains.Users;
import com.example.usermanagement.response.BaseResponse;
import com.example.usermanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user/{id}")
    public BaseResponse<Optional<Users>>getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public BaseResponse<Users> createUser(@RequestBody Users users){
        return  userService.createUser(users);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/all-User")
    public BaseResponse<List<Users>> allUser(){
        return userService.getAll();
    }
}
