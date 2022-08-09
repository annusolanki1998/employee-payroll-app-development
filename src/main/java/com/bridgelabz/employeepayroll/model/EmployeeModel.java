package com.bridgelabz.employeepayroll.model;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeModel {

    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String companyName;

    private long salary;
    private String department;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    public EmployeeModel(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.salary = employeeDTO.getSalary();
        this.companyName = employeeDTO.getCompanyName();
        this.department = employeeDTO.getDepartment();
    }

    public EmployeeModel() {

    }
}
