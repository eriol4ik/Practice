package hibernate_enumeration;

import hibernate_enumeration.dao.EmployeeDAO;
import hibernate_enumeration.dao.EmployeeDAOImpl;
import hibernate_enumeration.entity.Employee;
import hibernate_enumeration.enums.Gender;
import hibernate_enumeration.enums.Position;
import hibernate_enumeration.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by eriol4ik on 12.02.2017.
 */
public class EnumEx {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> list = employeeDAO.employeeByName("Test2");

        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }
}
