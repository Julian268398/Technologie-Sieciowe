package com.example.lista2ts.security;

import com.example.lista2ts.LoginForm;
import com.example.lista2ts.controller.LoginController;
import com.example.lista2ts.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.token.key}")
    private  String key;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public String login(LoginForm loginForm){
//        User user = userRepository.getUserByLogin(loginForm.getLogin());
        if(passwordEncoder.matches(loginForm.getPassword(),/*user.getPassword()*/ " ")){
            long timeMillis = System.currentTimeMillis();
            Jwts.builder()
                    .issuedAt(new Date(timeMillis))
                    .expiration(new Date(timeMillis+5*60*1000))
                    .claim("id", "userId")
                    .claim("userRole", "ROLE_")
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
            return token;
        }
    }
}
