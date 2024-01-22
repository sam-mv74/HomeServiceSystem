package com.maktab.final_project.model;

import com.maktab.final_project.base.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "user_table")
public class User extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String password;
    private LocalDateTime registrationDate;
    @Column(unique = true)
    private String email;
    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User() {
        registrationDate = LocalDateTime.now();
    }

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        registrationDate = LocalDateTime.now();
    }
}
