package com.roopak.employeeMngt.repository;

import com.roopak.employeeMngt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartment(String dept);

    boolean existsByEmail(String email);
}
