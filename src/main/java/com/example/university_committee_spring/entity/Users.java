package com.example.university_committee_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private float school_mark;
    private Integer math_mark;
    private Integer english_mark;
    private Integer history_mark;
    private String cache;
    private boolean confirmed;
    private String type_auth;

    @OneToMany(mappedBy = "users")
    private List<Registration> registrations;

    public Users(String firstName, String lastName, String email, String hashPassword, String type_auth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cache = hashPassword;
        this.type_auth = type_auth;
    }
}

