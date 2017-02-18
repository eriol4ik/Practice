package spring_first.ioc.spring_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eriol4ik on 18.02.2017.
 */

@Configuration
public class SpringConfig {
    @Bean(name = "bobik")
    public Dog beanDog() {
        return new Bobik("Bobik", "vooof");
    }

    @Bean(name = "sharik")
    public Dog beanDogSharik() {
        return new Bobik("Sharik", "vooof");
    }

    @Bean(name = "ferrari")
    public Car ferrari() {
        return new Ferrari("Ferrari");
    }

    @Bean(name = "vasyaDriver")
    public Driver vasya() {
        return new Vasya("Vasya", "V.", ferrari());
    }
}
