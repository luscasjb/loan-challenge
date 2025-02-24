package com.loan.service.model;

public enum LoanType {
    PERSONAL(4),
    CONSIGNMENT(2),
    GUARANTEED(3);

    private final double interestRate;

    LoanType(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
