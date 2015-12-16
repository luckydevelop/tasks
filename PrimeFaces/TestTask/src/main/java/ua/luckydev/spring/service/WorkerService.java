package ua.luckydev.spring.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.luckydev.jpa.data.Worker;

import java.io.Serializable;
import java.util.List;

@Repository
public class WorkerService implements Serializable
{
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

}
