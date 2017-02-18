package spring_first.ioc.spring_xml;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
