package com.bridgelabz.employeepayroll.service;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import com.bridgelabz.employeepayroll.util.Response;
import com.bridgelabz.employeepayroll.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TokenUtil tokenUtil;

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

    @Override
    public List<EmployeeModel> getEmployee(String token) {
        Long empId = tokenUtil.decodeToken(token);
        Optional<EmployeeModel> isEmployeePresent = employeeRepository.findById(empId);
        List<EmployeeModel> getallemployee = employeeRepository.findAll();
        if (getallemployee.size() > 0)
            return getallemployee;
        else
            throw new EmployeeNotFoundException(400, "No DATA Present");
    }

    @Override
    public EmployeeModel deleteEmployee(Long id) {
        Optional<EmployeeModel> isEmployeePresent = employeeRepository.findById(id);
        if (isEmployeePresent.isPresent()) {
            employeeRepository.delete(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee Not Present");
    }

    @Override
    public Response login(String email, String password) {
        Optional<EmployeeModel> isEmailPresent = employeeRepository.findByEmailId(email);
        if (isEmailPresent.isPresent()) {
            if (isEmailPresent.get().getPassword().equals(password)) {
                String token = tokenUtil.createToken(isEmailPresent.get().getEmployeeId());
                return new Response(200, "login succesfull", token);
            }
            throw new EmployeeNotFoundException(400, "Invald credentials");
        }
        throw new EmployeeNotFoundException(400, "Employee not found");
    }


}





