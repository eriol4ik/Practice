package spring_first.ioc.spring_annotations;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class Ferrari implements Car {
    String model;

    public Ferrari(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}
