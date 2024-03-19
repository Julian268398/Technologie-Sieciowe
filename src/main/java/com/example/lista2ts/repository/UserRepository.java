package com.example.lista2ts.repository;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
