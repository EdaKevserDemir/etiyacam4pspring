package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findById(int id);

    List<Employee> findEmployeeByReportsTo(int reportsTo);
}
