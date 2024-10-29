package com.project.picpayexec.dtos;

import com.project.picpayexec.domain.enums.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal amount,
                      String email, String password, UserType userType) {
}
