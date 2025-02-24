package com.loan.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoanResponseDTO {
    private String customer;
    private List<LoanDTO> loans;

    public LoanResponseDTO(String customer, List<LoanDTO> loans) {
        this.customer = customer;
        this.loans = loans;
    }
}
