package spring_first.ioc.spring_annotations;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public interface Driver {
    String getName();
    void setName(String name);

    String getSurname();
    void setSurname(String surname);

    Car getCar();
    void setCar(Car car);
}
