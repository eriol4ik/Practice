package hibernate_enumeration.entity;

import hibernate_enumeration.enums.Gender;
import hibernate_enumeration.enums.Position;

import javax.persistence.*;

/**
 * Created by eriol4ik on 12.02.2017.
 */

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Position position;

    public Employee() {}

    public Employee(String name, Gender gender, Position position) {
        this.name = name;
        this.gender = gender;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + gender;
    }
}
