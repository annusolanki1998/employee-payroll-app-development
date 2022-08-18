package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class DepartmentDTO {
    @NotNull
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "Department name is invalid")
    private String departmentName;

    @NotNull
    @Pattern(regexp = "[A-Z][a-zA-z]{2,}", message = "Department description is invalid")
    private String departmentDescription;
}
