package hibernate_onetomany.domain;

import javax.persistence.*;

/**
 * Created by eriol4ik on 11.02.2017.
 */

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @SequenceGenerator(name = "driver_id", sequenceName = "seq_driver_id",
                       allocationSize = 25, initialValue = 10_000)
    @GeneratedValue(generator = "driver_id")
    @Column(name = "DRIVER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Driver() {}

    public Driver(String name, String surname, Car car) {
        this.name = name;
        this.surname = surname;
        this.car = car;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return name + " " + surname /*+ ", " + car.getModel()*/;
    }
}
