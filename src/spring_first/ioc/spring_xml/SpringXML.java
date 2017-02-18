package spring_first.ioc.spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class SpringXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_first/ioc/spring-config.xml");
        Cat cat = context.getBean("murka", Cat.class);
        System.out.println(cat.getName());
        System.out.println(cat.getVoice());

        Cat cat2 = context.getBean("bars", Cat.class);
        System.out.println(cat2.getName());
    }
}
