package com.loan.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDTO {
    private String type;
    private double interestRate;

    public LoanDTO(String type, double interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }
}

