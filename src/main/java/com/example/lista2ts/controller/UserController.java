package com.example.lista2ts.controller;

import com.example.lista2ts.dto.UserCreateDTO;
import com.example.lista2ts.dto.UserCreateResponseDTO;
import com.example.lista2ts.dto.UserDTO;
import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.UserEntity;
import com.example.lista2ts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("permitAll()")
    public @ResponseBody Iterable<UserDTO> getAll() {

        return userService.getAll();
    }

    @GetMapping("/get/{userId}")
    @PreAuthorize("permitAll()")
    public UserDTO getOne(@PathVariable int userId) {
        return userService.getOne(userId);
    }


    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }
}
