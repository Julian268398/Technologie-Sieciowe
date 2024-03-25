package com.example.lista2ts.controller;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.UserEntity;
import com.example.lista2ts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<UserEntity> getAll() {
        return userService.getAll();
    }

    @GetMapping("/get/{userId}")
    public UserEntity getOne(@PathVariable int userId) {
        return userService.getOne(userId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody UserEntity create(@RequestBody UserEntity user) {
        return userService.create(user);
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }
}
