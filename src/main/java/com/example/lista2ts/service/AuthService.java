package com.example.lista2ts.service;

import com.example.lista2ts.commonTypes.UserRole;
import com.example.lista2ts.dto.LoginDTO;
import com.example.lista2ts.dto.LoginResponseDTO;
import com.example.lista2ts.dto.RegisterDTO;
import com.example.lista2ts.dto.RegisterResponseDTO;
import com.example.lista2ts.entity.AuthEntity;
import com.example.lista2ts.entity.UserEntity;
import com.example.lista2ts.repository.AuthRepository;
import com.example.lista2ts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public RegisterResponseDTO register(RegisterDTO dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setMail(dto.getMail());
        userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(dto.getPassword());
        authEntity.setUsername(dto.getUsername());
        authEntity.setRole(dto.getRole());
        authEntity.setUser(userEntity);

        authRepository.save(authEntity);

        return new RegisterResponseDTO(userEntity.getId(), authEntity.getUsername(), authEntity.getRole());
    }

    public LoginResponseDTO login(LoginDTO dto) {
        AuthEntity authEntity = authRepository.findByUsername(dto.getUsername()).orElseThrow(RuntimeException::new);

        if (!authEntity.getPassword().equals(dto.getPassword())){
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(authEntity);

        return new LoginResponseDTO(token);
    }
}
