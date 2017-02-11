package hibernate_onetomany.util;

/**
 * Created by eriol4ik on 11.02.2017.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static final SessionFactory factory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build() {
        Configuration config = new Configuration().
                configure("/hibernate_onetomany/hibernate.cfg.xml");

        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder();
        builder.applySettings(config.getProperties());

        registry = builder.build();

        return config.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}