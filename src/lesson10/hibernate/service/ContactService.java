package lesson10.hibernate.service;


import lesson10.hibernate.entity.Contact;

import java.util.List;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public interface ContactService {
    void createContact(Contact contact);

    List<Contact> findAll();
}
