package com.roopak.employeeMngt.service;

import com.roopak.employeeMngt.entity.Employee;
import com.roopak.employeeMngt.exception.EmployeeNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findByID(int id);

    List<Employee> findAll();

    List<Employee>  findAllWithSorting(String field,String direction);

    Page<Employee> findAllWithPagination(int page, int size);

    Page<Employee> findAllWithPaginationAndSorting(int page,int size,String field,String direction);

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartment(String dept);

    void deleteById(int id);
}
