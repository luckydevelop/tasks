package ua.luckydev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.luckydev.model.Worker;

@Repository
public class WorkerDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addWorker(Worker worker)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(worker);
    }


}
