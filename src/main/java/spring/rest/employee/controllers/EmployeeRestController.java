package spring.rest.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.rest.employee.entity.Employee;
import spring.rest.employee.exception.handler.NoSuchEmployeeException;
import spring.rest.employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeRestController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll(){return employeeService.getAllEmployees();}

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) throws NoSuchEmployeeException{
        Employee employee = employeeService.getById(id);
        if(employee == null) throw new NoSuchEmployeeException("Employee with id = " + id + " is not found");
        return employee;}

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Employee employee, BindingResult result) throws NoSuchEmployeeException{
        Map<String, String> errors = ControllerUtils.valid(result);
        if(!errors.isEmpty()) return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

        if(getAll().stream().anyMatch(emp -> emp.getEmail().equals(employee.getEmail())))
            throw new NoSuchEmployeeException("Employee with email = "+ employee.getEmail()+" already exists");

        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Employee updatedEmployee, BindingResult result) throws NoSuchEmployeeException{
        Map<String, String> errors = ControllerUtils.valid(result);
        Employee employee = getById(updatedEmployee.getId());

        if(!errors.isEmpty()) return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

        employeeService.save(updatedEmployee);
        return  new ResponseEntity<>(getById(employee.getId()), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws NoSuchEmployeeException{
        Employee employee = getById(id);
        employeeService.delete(employee);
        return new ResponseEntity<>("Delete employee with id " + id, HttpStatus.OK);
    }

}