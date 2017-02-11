package hibernate_onetomany.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by eriol4ik on 11.02.2017.
 */

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @SequenceGenerator(name = "car_id", sequenceName = "seq_car_id",
                       allocationSize = 25, initialValue = 10_000)
    @GeneratedValue(generator = "car_id")
    @Column(name = "car_id")
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @OneToMany
    private Set<Driver> drivers;

    public Long getId() {
        return id;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Set<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}
