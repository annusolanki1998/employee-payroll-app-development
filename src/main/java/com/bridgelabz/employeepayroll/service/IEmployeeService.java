package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import org.springframework.stereotype.Service;


public interface IEmployeeService {
    EmployeeModel addEmployee(EmployeeDTO employeeDTO);
}
