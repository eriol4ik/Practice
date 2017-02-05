package lesson10.hibernate.DAO;

import lesson10.hibernate.entity.Contact;
import lesson10.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by eriol4ik on 29/01/2017.
 */
public class ContactDAOImpl implements ContactDAO {
    private SessionFactory factory;

    public ContactDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long createContact(Contact contact) {
       Session session = factory.openSession();
        /*try {
            session.beginTransaction();
            Long id = (Long) session.save(contact);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        }
*/
        return null;
    }

    @Override
    public Contact readContact(Long id) {
        return null;
    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public List<Contact> findAll() {
        return factory.openSession().createCriteria(Contact.class).list();
    }
}
