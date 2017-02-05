package lesson04.calc_console;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class Contact {
    private String name;
    private String surname;
    private int age;
    private int phone;

    public Contact(String name, String surname, int age, int phone) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (age != contact.age) return false;
        if (phone != contact.phone) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        return surname != null ? surname.equals(contact.surname) : contact.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + phone;
        return result;
    }
}
