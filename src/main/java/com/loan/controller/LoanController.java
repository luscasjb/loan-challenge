package com.loan.controller;

import com.loan.service.dto.CustomerRequestDTO;
import com.loan.service.dto.LoanResponseDTO;
import com.loan.service.LoanService;
import com.loan.service.exception.NoLoansAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponseDTO> postAvailableLoans(@RequestBody CustomerRequestDTO customerRequestDTO) {
        LoanResponseDTO response = loanService.determineEligibleLoans(customerRequestDTO);
        return ResponseEntity.ok(response);
    }

    // Catch the exception and returns the message
    @ExceptionHandler(NoLoansAvailableException.class)
    public ResponseEntity<String> handleNoLoansAvailable(NoLoansAvailableException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
