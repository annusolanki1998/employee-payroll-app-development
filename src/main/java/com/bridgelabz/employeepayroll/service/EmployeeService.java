package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel addEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDTO);
        employeeModel.setRegisterDate(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeModel> isEmployeePresent = employeeRepository.findById(id);
        if (isEmployeePresent.isPresent()) {
            isEmployeePresent.get().setFirstName(employeeDTO.getFirstName());
            isEmployeePresent.get().setLastName(employeeDTO.getLastName());
            isEmployeePresent.get().setCompanyName(employeeDTO.getCompanyName());
            isEmployeePresent.get().setDepartment(employeeDTO.getDepartment());
            isEmployeePresent.get().setSalary(employeeDTO.getSalary());
            isEmployeePresent.get().setUpdateDate(LocalDateTime.now());
            employeeRepository.save(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }
}


