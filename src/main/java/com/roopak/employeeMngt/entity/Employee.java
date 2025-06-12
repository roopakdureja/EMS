package com.roopak.employeeMngt.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Employee {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name="email")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name="department")
    @NotBlank(message = "Department cannot be empty")
    private String department;

    @Column(name="salary")
    @Positive(message = "Salary must be greater than 0")
    private double salary;

    @Column(name="date_of_joining")
    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate dateOfJoining;

    //constructors
    public Employee() {}

    public Employee(String name, String email, String department, double salary, LocalDate dateOfJoining) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    //getters/setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    //toString() method

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
