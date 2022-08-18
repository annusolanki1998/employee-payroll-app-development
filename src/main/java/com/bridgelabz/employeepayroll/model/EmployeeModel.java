package com.bridgelabz.employeepayroll.model;


import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    @OneToOne
    private EmployeeDepartment employeeDepartment;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private String emailId;
    private String password;
    private String gender;
    private String note;
    private String profilePic;

    public EmployeeModel(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.salary = employeeDTO.getSalary();
        this.companyName = employeeDTO.getCompanyName();
        this.emailId = employeeDTO.getEmailId();
        this.password = employeeDTO.getPassword();
        this.gender = employeeDTO.getGender();
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
    }

    public EmployeeModel() {

    }

}
