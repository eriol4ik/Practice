package spring_first.ioc.spring_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class SpringAn {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        Dog bobik = context.getBean("bobik", Dog.class);
        bobik.name();
        bobik.voice();

        Dog sharik = context.getBean("sharik", Dog.class);
        sharik.name();
        sharik.voice();

        Driver vasya = context.getBean("vasyaDriver", Driver.class);
        Car ferrari = context.getBean("ferrari", Car.class);

        System.out.println("Driver: " + vasya.getName() + ", " + vasya.getSurname() + ", his car: " + vasya.getCar().getModel());
        System.out.println("Car: " + ferrari.getModel());
    }
}
