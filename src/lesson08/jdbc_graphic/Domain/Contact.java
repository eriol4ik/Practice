package lesson08.jdbc_graphic.Domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by eriol4ik on 22/01/2017.
 */
public class Contact {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty surname;
    private IntegerProperty age;
    private StringProperty email;
    private IntegerProperty mobile;

    public Contact(Integer id, String name, String surname, Integer age, String email, Integer mobile) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.age = new SimpleIntegerProperty(age);
        this.email = new SimpleStringProperty(email);
        this.mobile = new SimpleIntegerProperty(mobile);
    }

    public int getId() {return id.get();}
    public String getName() {return name.get();}
    public String getSurname() {return surname.get();}
    public int getAge() {return age.get();}
    public String getEmail() {return email.get();}
    public int getMobile() {return mobile.get();}


    /*
    * Contacts are equal if their ids are identical
    * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Contact contact = (Contact) obj;
        return id.get() == contact.getId();
    }
}
