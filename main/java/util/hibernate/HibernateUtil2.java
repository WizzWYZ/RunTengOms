package util.hibernate;

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
public class HibernateUtil2
{
        private static SessionFactory sessionFactory;

        static
        {
                try
                {
                        // Create the SessionFactory from hibernate.cfg.xml
//                        sessionFactory = new Configuration().configure().buildSessionFactory();
                        sessionFactory = new AnnotationConfiguration().configure("hibernate2.cfg.xml").buildSessionFactory();
                }
                catch (Throwable ex)
                {
                        // Make sure you log the exception, as it might be swallowed
                        System.err.println("Initial SessionFactory creation failed." + ex);
                        throw new ExceptionInInitializerError(ex);
                }
        }

        public static SessionFactory getSessionFactory()
        {
                return sessionFactory;
        }

        public static Session getCurrentSession()
        {
                SessionFactory sessionFactory = getSessionFactory();
                return sessionFactory.getCurrentSession();
        }

        public static Session openSession()
        {
                return getSessionFactory().openSession();
        }

        public static void renewSessionFactory()
        {
                getSessionFactory().close();
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }

        public static int nextSeq(String seqName)
        {
                Session session = HibernateUtil2.getCurrentSession();
                Query q = session.createSQLQuery("select " + seqName + ".nextval as seq from dual");
                String a = String.valueOf(q.uniqueResult());
                return Integer.parseInt(a);
        }

}
