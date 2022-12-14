package com.etiya.northwind.dataAccess.concretes.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeByIdResponse {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String title;
    private int reportsTo;
}
