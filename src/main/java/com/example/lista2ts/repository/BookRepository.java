package com.example.lista2ts.repository;

import com.example.lista2ts.entity.BookEntity;
import com.example.lista2ts.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
