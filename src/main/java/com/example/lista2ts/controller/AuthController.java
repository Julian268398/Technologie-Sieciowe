package com.example.lista2ts.controller;

import com.example.lista2ts.dto.LoginDTO;
import com.example.lista2ts.dto.LoginResponseDTO;
import com.example.lista2ts.dto.RegisterDTO;
import com.example.lista2ts.dto.RegisterResponseDTO;
import com.example.lista2ts.service.AuthService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<RegisterResponseDTO> register (@RequestBody RegisterDTO requestBody) {
        RegisterResponseDTO dto = authService.register(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    @SecurityRequirements
    public ResponseEntity<LoginResponseDTO> register (@RequestBody LoginDTO requestBody) {
        LoginResponseDTO dto = authService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
