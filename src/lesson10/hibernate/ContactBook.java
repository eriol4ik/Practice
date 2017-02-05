package lesson10.hibernate;

import lesson10.hibernate.entity.Contact;
import lesson10.hibernate.service.ContactService;
import lesson10.hibernate.service.ContactServiceImpl;

import java.util.List;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public class ContactBook {
    public static void main(String[] args) {
//        SessionFactory factory = HibernateUtil.getSessionFactory();

        ContactService service = new ContactServiceImpl();
        List<Contact> contacts = service.findAll();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        Contact newContact = new Contact("test4", "test4", "test4", "test4");
        contacts.add(newContact);

        service.createContact(newContact);

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
