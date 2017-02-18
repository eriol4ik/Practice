package hibernate_enumeration.dao;

import hibernate_enumeration.entity.Employee;

import java.util.List;

/**
 * Created by eriol4ik on 12.02.2017.
 */
public interface EmployeeDAO {
    List<Employee> employeeByName(String name);
}
