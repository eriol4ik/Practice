package hibernate_onetomany.util;

/**
 * Created by eriol4ik on 11.02.2017.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static final SessionFactory factory = build();

    private static SessionFactory build() {
        Configuration config = new Configuration();
        config.configure("/hibernate_enumeration/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
