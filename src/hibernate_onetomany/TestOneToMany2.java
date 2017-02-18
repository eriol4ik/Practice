package hibernate_onetomany;

import hibernate_onetomany.domain.Car;
import hibernate_onetomany.domain.Driver;
import hibernate_onetomany.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by eriol4ik on 11.02.2017.
 */
public class TestOneToMany2 {
    public static void main(String[] args) {
        SessionFactory factory = HibernateSessionFactory.getSessionFactory();

        Car car = new Car("Test", "Test");
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();

        Driver driver1 = new Driver("Test1", "Test1", car);
        Driver driver2 = new Driver("Test2", "Test2", car);

        session.beginTransaction();
        session.saveOrUpdate(driver1);
        session.saveOrUpdate(driver2);
        session.getTransaction().commit();

        Driver driver = (Driver) session.get(Driver.class, 2L);
        System.out.println(driver);

        Car car1 = (Car) session.get(Car.class, 1L);

        /*System.out.println(car1.getDrivers());
        for (Driver driver3 : car1.getDrivers()) {
            System.out.println(driver3);
        }*/

        factory.close();
    }
}
