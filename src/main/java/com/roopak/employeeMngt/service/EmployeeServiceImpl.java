package com.roopak.employeeMngt.service;

import com.roopak.employeeMngt.entity.Employee;
import com.roopak.employeeMngt.exception.BadRequestException;
import com.roopak.employeeMngt.exception.EmployeeNotFoundException;
import com.roopak.employeeMngt.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        if(employeeRepository.existsByEmail(employee.getEmail())){
            throw new BadRequestException("Employee with same mail id exists.");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByID(int id){

        Optional<Employee> result = employeeRepository.findById(id);

        Employee theemployee = null;
        if(result.isPresent()){
            theemployee = result.get();
        }else{
            //we didn't find employee id
            throw new EmployeeNotFoundException(" Employee id not found: " + id);
        }

        return theemployee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllWithSorting(String field,String direction) {
        Sort sort;

        //equalsIgnoreCase is  basic string method in java
        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(Sort.Direction.DESC, field);
        } else {
            sort = Sort.by(Sort.Direction.ASC, field);
        }
        //findAll(Sort sort) is a built-in spring data JPA method
        return employeeRepository.findAll(sort);
    }

    @Override
    public Page<Employee> findAllWithPagination(int page, int size) {

        //pageRequest class will return page of the employees.
        Page<Employee> employees  = employeeRepository.findAll(PageRequest.of(page, size));

        return employees;
    }

    @Override
    public Page<Employee> findAllWithPaginationAndSorting(int page, int size, String field, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(Sort.Direction.DESC, field);
        } else {
            sort = Sort.by(Sort.Direction.ASC, field);
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Employee> employees  = employeeRepository.findAll(pageable);
        return employees;
    }

    @Override
    public List<Employee> findByNameContainingIgnoreCase(String name) {

        List<Employee> employees =  employeeRepository.findByNameContainingIgnoreCase(name);

        if(employees.isEmpty()){
            throw new EmployeeNotFoundException("Employee name not found: " +name);
        }

        return employees;

    }

    @Override
    public List<Employee> findByDepartment(String dept) {
        return employeeRepository.findByDepartment(dept);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(emp);
    }
}
