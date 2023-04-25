package spring.rest.employee.service.impl;

import spring.rest.employee.dao.EmployeeDAO;
import spring.rest.employee.entity.Employee;
import spring.rest.employee.exception.handler.NoSuchEmployeeException;
import spring.rest.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    @Override
    @Transactional
    public Employee getById(int id) throws NoSuchEmployeeException {return employeeDAO.getById(id);}

    @Override
    @Transactional
    public void save(Employee employee) throws NoSuchEmployeeException {employeeDAO.save(employee);}

    @Override
    @Transactional
    public void delete(Employee employee) throws NoSuchEmployeeException {employeeDAO.delete(employee);}
}
