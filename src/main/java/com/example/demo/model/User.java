package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(unique = true)
    private String username;


    private String password;


    @Column(unique = true)
    private String contactNumber;

    private int pinCode;
}
