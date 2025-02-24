package com.loan.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {
    private int age;
    private String cpf;
    private String name;
    private double income;
    private String location;
}
