package spring_first.ioc.spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class CarXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring_first/ioc/spring-config.xml");
        Car car = context.getBean(Car.class);
        Driver driver = context.getBean(Driver.class);
        System.out.println("Car: " + car.getModel());
        System.out.println("Driver: " + driver.getName() + ", " + driver.getSurname() + ", his car: " + driver.getCar().getModel());
    }
}
