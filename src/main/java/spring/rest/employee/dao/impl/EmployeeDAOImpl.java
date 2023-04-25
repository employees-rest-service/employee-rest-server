package spring.rest.employee.dao.impl;
import spring.rest.employee.dao.EmployeeDAO;
import spring.rest.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.rest.employee.exception.handler.NoSuchEmployeeException;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll(){
        return openSession().createQuery("from Employee").getResultList();
    }

    @Override
    public Employee getById(int id) throws NoSuchEmployeeException{
        return openSession().get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) throws NoSuchEmployeeException{
        openSession().saveOrUpdate(employee);
    }

    @Override
    public void delete(Employee employee) throws NoSuchEmployeeException{
        openSession().delete(employee);

    }

    private Session openSession(){return sessionFactory.getCurrentSession();}
}
