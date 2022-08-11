package com.etiya.northwind.dataAccess.concretes.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListResponse {
    private String customerId;
    private String companyName;
    private String contactName;
}
