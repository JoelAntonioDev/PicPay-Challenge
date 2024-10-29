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
        this.firstName=data.firstName();
        this.lastName=data.lastName();
        this.document=data.document();
        this.email=data.email();
        this.password=data.password();
        this.userType=data.userType();
        this.balance=data.amount();
    }
}
