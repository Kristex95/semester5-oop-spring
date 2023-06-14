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
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    public Faculty(String name){
        this.name = name;
    }

    @OneToMany(mappedBy = "faculty")
    private List<Registration> registrations;
}
