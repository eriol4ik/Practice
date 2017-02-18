package spring_first.ioc.spring_xml;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class Driver {
    private String name;
    private String surname;
    private Car car;

    public Driver(String name, String surname, Car car) {
        this.name = name;
        this.surname = surname;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
