package lesson10.hibernate.service;

import lesson10.hibernate.DAO.ContactDAO;
import lesson10.hibernate.DAO.ContactDAOImpl;
import lesson10.hibernate.entity.Contact;

import java.util.List;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public class ContactServiceImpl implements ContactService {
    private ContactDAO contactDAO;

    public ContactServiceImpl() {
        contactDAO = new ContactDAOImpl();
    }

    @Override
    public void createContact(Contact contact) {
        Long id = contactDAO.createContact(contact);
        contact.setId(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }
}
