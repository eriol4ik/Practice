package lesson10.hibernate.DAO;


import lesson10.hibernate.entity.Contact;

import java.util.List;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public interface ContactDAO {
    Long createContact(Contact contact);

    Contact readContact(Long id);

    void updateContact(Contact contact);

    void deleteContact(Contact contact);

    List<Contact> findAll();
}
