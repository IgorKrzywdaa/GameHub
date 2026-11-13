package com.gamehub.service;

import com.gamehub.model.Employee;
import com.gamehub.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + email));
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setPosition(updatedEmployee.getPosition());
        existingEmployee.setEmail(updatedEmployee.getEmail());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}