package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeModel addEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDTO);
        employeeModel.setRegisterDate(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return employeeModel;
    }
}

