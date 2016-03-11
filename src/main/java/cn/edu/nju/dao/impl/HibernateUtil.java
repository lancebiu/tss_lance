package cn.edu.nju.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
