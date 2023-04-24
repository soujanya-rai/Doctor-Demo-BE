package com.example.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

	@Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pwd")
    private String password;
    
    @Column(name = "role")
    private String role;
    
}
