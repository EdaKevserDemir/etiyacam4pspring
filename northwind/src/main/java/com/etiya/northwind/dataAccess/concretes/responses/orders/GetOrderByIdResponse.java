package com.etiya.northwind.dataAccess.concretes.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderByIdResponse {
    private int orderId;
    private LocalDate orderDate;
    private String employeeFirstName ;
    private String employeeLastName ;
    private String customerCompanyName ;
    private String customerContactName ;
}
