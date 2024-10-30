package com.project.picpayexec.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDTO {
    private BigDecimal value;
    private Long senderId;
    private Long receiverId;
}
