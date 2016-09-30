package runnable;

import client.Client;
import client.ClientManager;
import domain.OrderEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.exceptions.ClientNotFoundException;
import util.exceptions.KeyNotFoundException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyz on 16/9/23.
 */
public class CaculateOrderChargePrice implements Runnable {
    private final int pageSize = 1000; //第一次开线程,每次拿1000条数据


    public void run() {
        try {
            Session session = HibernateUtil.getCurrentSession();
            session.beginTransaction();
            Query q = session.createQuery("select count(1) from OrderEntity o where o.chargePrice is null and o.shippingStatus = '6'");
            Long count = (Long) q.uniqueResult();
            session.getTransaction().commit();
            for (int i = 0; i < Math.floor(count / pageSize + 1); i++) {
                Session pageSession = HibernateUtil.getCurrentSession();
                pageSession.beginTransaction();
                Query pageQuery = pageSession.createQuery("from OrderEntity o where o.chargePrice is null and o.shippingStatus = '6' ");
                pageQuery.setFirstResult(i * pageSize);
                pageQuery.setMaxResults(pageSize);
                List<OrderEntity> pageData = pageQuery.list();
                pageSession.getTransaction().commit();
                Thread pageCalculate = new Thread(new pageCalculate(pageData));
                pageCalculate.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class pageCalculate implements Runnable {
        private final int calculateSize = 100;   //第二次开线程,每条线程计算100条数据
        private List<OrderEntity> pageData = new ArrayList<OrderEntity>();
        private List<List<OrderEntity>> pageDataList = new ArrayList<List<OrderEntity>>();

        public pageCalculate(List pageData) {
            this.pageData = pageData;
        }

        public void run() {
            List<OrderEntity> calculateData = null;
            for (int i = 0; i < pageData.size(); i++) {
                if (i % calculateSize == 0) {
                    calculateData = new ArrayList<OrderEntity>();
                    pageDataList.add(calculateData);
                }
                calculateData.add(pageData.get(i));
            }
            for (List<OrderEntity> orderEntities : pageDataList) {
                Thread calculate = new Thread(new calculate(orderEntities));
                calculate.run();
            }
        }
    }

    private class calculate implements Runnable {
        private List<OrderEntity> calculateData = new ArrayList<OrderEntity>();

        public calculate(List<OrderEntity> calculateData) {
            this.calculateData = calculateData;
        }

        public void run() {
            for (OrderEntity order : calculateData) {
                try {
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    Client client = ClientManager.getClient(order.getClient());
                    client.startCalculate(session, order.getAddressProvince(), order.getActualWeight(), order);
                    session.merge(order);
                    session.getTransaction().commit();
                } catch (KeyNotFoundException e) {
                    e.printStackTrace();
                    HibernateUtil.getCurrentSession().getTransaction().rollback();
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    order.setChargePrice(new BigDecimal(-1));
                    order.setCostPrice(new BigDecimal(-1));
                    order.setCalculateMemo("配置文件主键未找到");
                    session.merge(order);
                    session.getTransaction().commit();
                } catch (IOException e) {
                    e.printStackTrace();
                    HibernateUtil.getCurrentSession().getTransaction().rollback();
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    order.setChargePrice(new BigDecimal(-1));
                    order.setCostPrice(new BigDecimal(-1));
                    order.setCalculateMemo("IO异常");
                    session.merge(order);
                    session.getTransaction().commit();
                } catch (ClientNotFoundException e) {
                    e.printStackTrace();
                    HibernateUtil.getCurrentSession().getTransaction().rollback();
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    order.setChargePrice(new BigDecimal(-1));
                    order.setCostPrice(new BigDecimal(-1));
                    order.setCalculateMemo("货主未找到");
                    session.merge(order);
                    session.getTransaction().commit();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    HibernateUtil.getCurrentSession().getTransaction().rollback();
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    order.setChargePrice(new BigDecimal(-1));
                    order.setCostPrice(new BigDecimal(-1));
                    order.setCalculateMemo("类文件错误");
                    session.merge(order);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    HibernateUtil.getCurrentSession().getTransaction().rollback();
                    Session session = HibernateUtil.getCurrentSession();
                    session.beginTransaction();
                    order.setChargePrice(new BigDecimal(-1));
                    order.setCostPrice(new BigDecimal(-1));
                    order.setCalculateMemo("未知错误");
                    session.merge(order);
                    session.getTransaction().commit();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread test = new Thread(new CaculateOrderChargePrice());
        test.run();
    }
}
