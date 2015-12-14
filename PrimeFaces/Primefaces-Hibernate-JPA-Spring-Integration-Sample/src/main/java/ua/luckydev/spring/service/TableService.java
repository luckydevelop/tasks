package ua.luckydev.spring.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.luckydev.jpa.data.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TableService {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void register(Worker emp) {
        // Save employee
        this.em.persist(emp);
    }


    @SuppressWarnings("unchecked")
    public List<Worker> listPersons() {

        List<Worker> workerList = em.createQuery("SELECT t FROM Worker t").getResultList();

        return workerList;
    }

//    @Override
//    public void addPersonne(Personne personne) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            session.save(personne);
//            session.getTransaction().commit();
//            session.close();
//            System.out.print("bien ajouté");
//        } catch (Exception e) {
//            System.out.print("erreur insertion" + e.getMessage());
//        }
//    }
//
//    @Override
//    public void updatePersonne(Personne personne) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            session.update(personne);
//            session.getTransaction().commit();
//            session.close();
//            System.out.print("bien ajouté");
//        } catch (Exception e) {
//            System.out.print("erreur insertion" + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deletpersonne(Personne personne) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            session.delete(personne);
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.print("erreur suppression" + e.getMessage());
//            session.beginTransaction().rollback();
//        }
//    }
//
//    @Override
//    public Personne getPersonne(int id) {
//
//        Personne personne = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            personne = (Personne) session.get(Personne.class, id);
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.print("erreur suppression" + e.getMessage());
//            session.beginTransaction().rollback();
//            return personne;
//        }
//        return personne;
//    }
//
//    @Override
//    public List<Personne> getListPersonne() {
//        List<Personne> listPersonne = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            session.beginTransaction();
//            listPersonne = session.createQuery("from Personne").list();
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception e) {
//            System.out.print("erreur suppression" + e.getMessage());
//            session.beginTransaction().rollback();
//            return listPersonne;
//        }
//        return listPersonne;
//    }
}
