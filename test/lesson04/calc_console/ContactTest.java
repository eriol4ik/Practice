package lesson04.calc_console;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by eriol4ik on 25/12/2016.
 */
public class ContactTest extends Assert {
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @Before
    public void init() {
        contact1 = new Contact("test1", "test1", 50, 1234567);
        contact2 = new Contact("test1", "test1", 50, 1234567);
        contact3 = new Contact("test2", "test2", 45, 7654321);
    }

    @Test
//    @Ignore // - тест не будет учитываться
    public void contactEqualsTest() {
        assertTrue("Сравнение контактов (равны)", contact1.equals(contact2));
        assertFalse("Сравнение контактов (не равны)", contact2.equals(contact3));
    }

    @Test
    public void contactHashCodeTest() {
        assertTrue("Сравнение хеш-кодов контактов (равны)", contact1.hashCode()==contact2.hashCode());
        assertFalse("Сравнение хеш-кодов контактов (не равны)", contact2.hashCode()==contact3.hashCode());
    }
}