package com.bridgelabz.employeepayroll.controller;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import com.bridgelabz.employeepayroll.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/addemployee")
    public EmployeeModel addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @PutMapping("/updateemployee/{id}")
    public EmployeeModel updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @GetMapping("/getemployeedata")
    public List<EmployeeModel> getEmployee(@RequestHeader String token) {
        return employeeService.getEmployee(token);
    }

    @DeleteMapping("deleteemployee/{id}")
    public EmployeeModel deleteemployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/login")
    public Response login(@RequestParam String email, @RequestParam String password) {
        return employeeService.login(email, password);
    }


}
