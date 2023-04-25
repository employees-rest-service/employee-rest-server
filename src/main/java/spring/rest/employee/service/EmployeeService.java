package spring.rest.employee.service;

import spring.rest.employee.entity.Employee;
import spring.rest.employee.exception.handler.NoSuchEmployeeException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getById(int id) throws NoSuchEmployeeException;

    void save(Employee employee) throws NoSuchEmployeeException;

    void delete(Employee employee) throws NoSuchEmployeeException;
}
