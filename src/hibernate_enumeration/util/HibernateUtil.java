package hibernate_enumeration.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by eriol4ik on 12.02.2017.
 */
public class HibernateUtil {
    private static final SessionFactory factory = build();

    private static SessionFactory build() {
        Configuration config = new Configuration();
        config.configure("/hibernate_enumeration/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }
}
