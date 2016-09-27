package util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Author: Zhouyue
 * Date: 2008-8-26
 * Time: 14:09:05
 * Copyright Daifuku Shanghai Ltd.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


//    public static void initSessionFactory() {
//        if (sessionFactory == null) {
//            newSessionFactory();
//        }
//    }

    private static synchronized void newSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (RuntimeException ex) {
            sessionFactory = null;
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw ex;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getCurrentSession() {
//        initSessionFactory();
        return getSessionFactory().getCurrentSession();
    }

    public static Session openSession() {
//        initSessionFactory();
        return getSessionFactory().openSession();
    }

    public static void renewSessionFactory() {
        if( getSessionFactory() !=null) {
            getSessionFactory().close();
        }
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static int nextSeq(String seqName) {
        Session session = HibernateUtil.getCurrentSession();
        Query q = session.createSQLQuery("select " + seqName + ".nextval as seq from dual");
        String a = String.valueOf(q.uniqueResult());
        return Integer.parseInt(a);
    }

}
