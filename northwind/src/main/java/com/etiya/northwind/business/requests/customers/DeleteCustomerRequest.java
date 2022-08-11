package com.etiya.northwind.business.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCustomerRequest {
    @NotNull
    private String customerId;
}
