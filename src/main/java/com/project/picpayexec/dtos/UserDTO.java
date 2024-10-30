package com.project.picpayexec.dtos;

import com.project.picpayexec.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String document;
    private BigDecimal amount;
    private String email;
    private String password;
    private UserType userType;
}
