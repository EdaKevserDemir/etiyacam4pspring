package com.etiya.northwind.business.requests.customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
    @NotNull
    @NotBlank
    private String customerId;
    @NotNull
    @NotBlank
    @Size(min=2,max=15)
    private String companyName;
    @NotNull
    @NotBlank
    @Size(min=2,max=15)
    private String contactName;
    @NotNull
    @NotBlank
    @Size(min=2,max=15)
    private String contactTitle;


}
