package com.loan.service.exception;

public class NoLoansAvailableException extends RuntimeException {
    public NoLoansAvailableException(String message) {
        super(message);
    }
}