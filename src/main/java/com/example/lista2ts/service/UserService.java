package com.example.lista2ts.service;

import com.example.lista2ts.dto.UserCreateDTO;
import com.example.lista2ts.dto.UserCreateResponseDTO;
import com.example.lista2ts.dto.UserDTO;
import com.example.lista2ts.entity.UserEntity;
import com.example.lista2ts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<UserDTO> getAll() {
        var users = userRepository.findAll();

        return users.stream().map((user) -> new UserDTO(user.getId(), user.getName(), user.getMail())).collect(Collectors.toList());
    }

    public UserDTO getOne(long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
        return new UserDTO(user.getId(), user.getName(), user.getMail());
    }

    public UserCreateResponseDTO create(UserCreateDTO user) {
        var userEntity = new UserEntity();

        userEntity.setMail(user.getMail());
        userEntity.setName(user.getName());

        var newUser = userRepository.save(userEntity);

        return new UserCreateResponseDTO(newUser.getId(), newUser.getName(), newUser.getMail());
    }

    public void delete(long userId){
        if (!userRepository.existsById(userId)){
            throw new RuntimeException();
        }
        userRepository.deleteById(userId);
    }
}
