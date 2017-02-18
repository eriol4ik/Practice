package hibernate_enumeration.dao;

import hibernate_enumeration.entity.Employee;
import hibernate_enumeration.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Temporal;
import java.util.List;

/**
 * Created by eriol4ik on 12.02.2017.
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> employeeByName(String name) {
        Session session = HibernateUtil.getSession();
        /*return session.getCriteriaBuilder()
                .createQuery(Employee.class)
                .where();*/
        return null;
    }
}
