package com.metacoding.dockerserver.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}