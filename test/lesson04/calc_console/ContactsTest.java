package lesson04.calc_console;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class ContactsTest extends Assert {
    private Contacts contacts;


    @Before
    public void initialize() {
        contacts = new Contacts();
    }

    @Test
    public void initContactTest() {
        assertNull("Пустая переменная", contacts.contact);
        contacts.initContact(contacts.contact);
        assertNotNull("Непустая переменная", contacts.contact);
    }

}