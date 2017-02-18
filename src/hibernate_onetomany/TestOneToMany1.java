package hibernate_onetomany;

import hibernate_onetomany.domain.Car;
import hibernate_onetomany.domain.Driver;
import hibernate_onetomany.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by eriol4ik on 11.02.2017.
 */
public class TestOneToMany1 {
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

        factory.close();
    }
}
