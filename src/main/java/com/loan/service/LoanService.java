package com.loan.service;

import com.loan.service.dto.LoanDTO;
import com.loan.service.dto.LoanResponseDTO;
import com.loan.service.exception.NoLoansAvailableException;
import com.loan.service.model.LoanType;
import com.loan.service.dto.CustomerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public LoanResponseDTO determineEligibleLoans(CustomerRequestDTO customer) {
        List<LoanDTO> loans = new ArrayList<>();

        double income = customer.getIncome();
        int age = customer.getAge();
        String location = customer.getLocation();

        // Rule for Personal Loan
        if (income <= 3000 || (income > 3000 && income <= 5000 && age < 30 && "SP".equals(location))) {
            loans.add(new LoanDTO(LoanType.PERSONAL.name(), LoanType.PERSONAL.getInterestRate()));
        }

        // Rule for Consignment Loan
        if (income >= 5000) {
            loans.add(new LoanDTO(LoanType.CONSIGNMENT.name(), LoanType.CONSIGNMENT.getInterestRate()));
        }

        // Rule for Guaranteed Loan
        if (income <= 3000 || (income > 3000 && income <= 5000 && age < 30 && "SP".equals(location))) {
            loans.add(new LoanDTO(LoanType.GUARANTEED.name(), LoanType.GUARANTEED.getInterestRate()));
        }

        if (loans.isEmpty()) {
            throw new NoLoansAvailableException("No loan found!");
        }

        return new LoanResponseDTO(customer.getName(), loans);
    }
}
