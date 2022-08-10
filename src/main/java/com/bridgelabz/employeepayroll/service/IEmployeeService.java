package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;

import java.util.List;


public interface IEmployeeService {
    EmployeeModel addEmployee(EmployeeDTO employeeDTO);

    EmployeeModel updateEmployee(long id, EmployeeDTO employeeDTO);

    List<EmployeeModel> getEmployee();
}
