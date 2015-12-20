package ua.luckydev.ejb;




import ua.luckydev.entity.PersonEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PersonEntityEJB implements Serializable
{

    @PersistenceContext
    private EntityManager em;

//    public EntityManager getEm() {
//        return em;
//    }
//
//    public void setEm(EntityManager em) {
//        this.em = em;
//    }

//    @Transactional
    public void addPersonEntity(PersonEntity person) {
        this.em.persist(person);
    }

    public PersonEntity getPersonEntity(int id) {
        System.out.println("IDD - " + id);
       return em.find(PersonEntity.class, id);
    }

    public void deletePersonEntity (PersonEntity person)
    {
        PersonEntity toBeRemoved = em.merge(person);
        em.remove(toBeRemoved);
    }

    @SuppressWarnings("unchecked") //-????
    public List<PersonEntity> listPersonEntitys() {

        List<PersonEntity> personList = em.createQuery("SELECT p FROM PersonEntity p").getResultList(); //?????????? ?? ???????????

        return personList;
    }

    public void updatePersonEntity (PersonEntity person)
    {
        em.merge(person);
    }
}