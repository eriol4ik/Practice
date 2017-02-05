package lesson10.hibernate.entity;

/**
 * Created by eriol4ik on 29/01/2017.
 */
//@Entity
//@Table(name = "CONTACTS_BOOK")
public class Contact {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;

    /* Обязательное условие для POJO */
    public Contact() {}

    public Contact(String name, String surname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return id + ". " + name + ", " + surname;
    }
}
