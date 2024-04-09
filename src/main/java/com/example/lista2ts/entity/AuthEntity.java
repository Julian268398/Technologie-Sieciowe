package com.example.lista2ts.entity;

import com.example.lista2ts.commonTypes.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "auth", schema = "library_w11")
public class AuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authId")
    private long id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity user;
}
