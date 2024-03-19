package com.example.lista2ts.service;

import com.example.lista2ts.entity.UserEntity;
import com.example.lista2ts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<UserEntity> getAll() {return userRepository.findAll();}

    public UserEntity getOne(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public UserEntity create(UserEntity user) { return userRepository.save(user);}

    public void delete(long userId){
        userRepository.deleteById(userId);
    }
}
