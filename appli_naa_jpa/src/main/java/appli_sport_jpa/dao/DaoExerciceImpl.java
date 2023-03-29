package appli_sport_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import appli_sport_jpa.entities.Exercice;

public class DaoExerciceImpl implements DaoExercice {

	@Override
	public Exercice save(Exercice obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Exercice obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}
	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Exercice.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Exercice findByKey(Long key) {
		Exercice exercice = null;
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		exercice = em.find(Exercice.class, key);
		em.close();
		return exercice;
	}

	@Override
	public List<Exercice> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Exercice> query = em.createQuery("from Exercice p", Exercice.class);
		List<Exercice> exercices = query.getResultList();
		em.close();
		return exercices;
	}

}
