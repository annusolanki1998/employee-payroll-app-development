package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
    Optional<EmployeeModel> findByEmailId(String email);

    @Query(value = "select * from employee where first_name=:firstName", nativeQuery = true)
    List<EmployeeModel> findFirstName(String firstName);

    @Query(value = "select * from employee order by last_name  ", nativeQuery = true)
    List<EmployeeModel> orderByLastName();
}
