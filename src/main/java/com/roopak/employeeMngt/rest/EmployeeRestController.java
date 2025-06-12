package com.roopak.employeeMngt.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.roopak.employeeMngt.entity.Employee;
import com.roopak.employeeMngt.exception.EmployeeNotFoundException;
import com.roopak.employeeMngt.service.EmployeeService;
import jakarta.validation.Valid;
import org.hibernate.metamodel.internal.EmbeddableInstantiatorPojoIndirecting;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    EmployeeService employeeService;
    ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("")
    public List<Employee> findALL(){
        return employeeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Employee findById(@PathVariable int id){

        return employeeService.findByID(id);
    }

    @GetMapping("/search-by-name")
    public List<Employee> findByName(@RequestParam String name){
        return employeeService.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/search-by-department")
    public List<Employee> findByDept(@RequestParam String dept){
        return employeeService.findByDepartment(dept);
    }

    @GetMapping("/sorted")
    public List<Employee> findAllWithSorting(@RequestParam String field,
                                             @RequestParam(defaultValue = "asc") String direction){
        return employeeService.findAllWithSorting(field,direction);
    }

    @GetMapping("/paginated")
    public Page<Employee> findAllWithPaginated(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int size){

        return employeeService.findAllWithPagination(page, size);
    }

    @GetMapping("/paginated-sorted")
    public Page<Employee> findAllWithPaginatedAndSorting(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "2") int size,
                                                         @RequestParam String field,
                                                         @RequestParam(defaultValue = "asc") String direction) {

        return employeeService.findAllWithPaginationAndSorting(page, size, field, direction);
    }

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){

        //just in case client pass an id in JSON - set to 0
        //this is to force a save of new item - not update
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);
        return new ResponseEntity<>(dbEmployee, HttpStatus.CREATED);
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "Deleted employee with id: "+id;
    }

    @PatchMapping("/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String,Object> patchPayLoad) throws EmployeeNotFoundException {

        Employee employee = employeeService.findByID(id);

        Employee patchedEmployee = apply(employee, patchPayLoad);

        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }

    private Employee apply(Employee employee, Map<String, Object> patchPayLoad) {
        //convert employee into node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        //convert payload into node
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        //merge them
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }


}
