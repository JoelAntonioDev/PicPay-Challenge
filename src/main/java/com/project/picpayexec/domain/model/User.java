package com.project.picpayexec.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.picpayexec.domain.enums.UserType;
import com.project.picpayexec.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){
        this.firstName=data.getFirstName();
        this.lastName=data.getLastName();
        this.document=data.getDocument();
        this.email=data.getEmail();
        this.password=data.getPassword();
        this.userType=data.getUserType();
        this.balance=data.getAmount();
    }
}
