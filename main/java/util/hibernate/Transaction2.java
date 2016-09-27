package util.hibernate;

import org.hibernate.Session;

/**
 * Author: Zhouyue
 * Date: 2008-9-3
 * Time: 17:58:53
 * Copyright Daifuku Shanghai Ltd.
 */
public class Transaction2
{
      public static void begin()
      {            
            Session session = HibernateUtil2.getCurrentSession();
            session.beginTransaction();
      }

      public static void commit()
      {
            HibernateUtil2.getCurrentSession().getTransaction().commit();
      }

      public static void rollback()
      {
            try
            {
                  HibernateUtil2.getCurrentSession().getTransaction().rollback();
            }
            catch (RuntimeException rbEx)
            {
            }
      }

}
