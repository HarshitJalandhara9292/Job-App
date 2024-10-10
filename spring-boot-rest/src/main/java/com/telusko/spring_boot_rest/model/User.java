package com.telusko.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// It represents a table

@Data
@Entity
@Table(name="users")
public class User {

@Id
    private int id;
    private  String username;
    private String password;
}
