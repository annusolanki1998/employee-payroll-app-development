package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeDTO {
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Employee first name is invalid")
    private String firstName;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Employee last name is invalid")
    private String lastName;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid company name")
    private String companyName;

    @NotNull
    @Min(value=500, message= "Min wage should be more than 500")
    private long salary;

    @NotNull
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid email id")
    private String emailId;

    @NotNull
    @Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}", message = "Invalid password")
    private String password;

    @NotNull
    @Pattern(regexp = "male|female", message = "Gender need to be male or female")
    private String gender;

    @NotNull
    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotNull
    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;


}
