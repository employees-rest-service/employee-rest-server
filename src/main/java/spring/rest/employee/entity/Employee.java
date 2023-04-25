package spring.rest.employee.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name="name")
    @Size(max = 30, message = "Field name must been less than 30 symbols")
    @NotBlank(message = "Field name mustn't been empty")
    private String name;
    @Column(name="surname")
    @Size(max = 30, message = "Field name must been less than 30 symbols")
    @NotBlank(message = "Field surname mustn't been empty")
    private String surname;
    @Column(name="email")
    @Email(message = "Email is incorrect")
    @NotBlank(message = "Field email mustn't been empty")
    private String email;
    @Column(name="salary")
    @Max(value = 5000, message = "Field salary must been less than 5000")
    @Min(value = 500, message = "Field salary must been more than 500")
    private int salary;
    @Column(name="department")
    @Size(max = 30, message = "Field department must been less than 30 symbols")
    @NotBlank(message = "Field department mustn't been empty")
    private String department;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
