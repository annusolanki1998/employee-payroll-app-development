package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;


public interface IEmployeeService {
    EmployeeModel addEmployee(EmployeeDTO employeeDTO);

    EmployeeModel updateEmployee(long id, EmployeeDTO employeeDTO);
}
