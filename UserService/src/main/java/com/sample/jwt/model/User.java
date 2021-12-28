package com.sample.jwt.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="TBL_EMPLOYEES")
public class User {
    @Id
    private Long id;
    @Column(name = "emp_name")
    private String empName;
    private String department;
    private String email;
    private String username;
    private String password;
    private String company;
}
