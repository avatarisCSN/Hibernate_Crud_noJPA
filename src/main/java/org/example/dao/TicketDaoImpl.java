package org.example.dao;

import org.example.model.Client;
import org.example.model.Ticket;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDaoImpl implements TicketDaoService {
   private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(ticket);
            tx.commit();
        }
    }



    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }


    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(ticket);
            tx.commit();
        }
    }


    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(ticket);
            tx.commit();
        }
    }

}
