package appli_sport_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import appli_sport_jpa.entities.Programme;


public class DaoProgrammeImpl implements DaoProgramme{

	@Override
	public Programme save(Programme obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Programme obj) {
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
		em.remove(em.find(Programme.class, key));
		tx.commit();
		em.close();
		
	}

	@Override
	public Programme findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Programme programme = em.find(Programme.class, key);
		em.close();
		return programme;
	}

	@Override
	public List<Programme> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Programme> query = em.createQuery("from Programme f", Programme.class);
		List<Programme> programmes = query.getResultList();
		em.close();
		return programmes;
	}
	
	
	public List<Programme> findByIdCoach(Long id){
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Programme> query = 
				em.createQuery(
						"select distinct p from Programme p "
						+"left join fetch p.coachCreateur c "
						+"where c.id=:id ", 
						Programme.class);
		query.setParameter("id", id);
		List<Programme> programmes = query.getResultList();
		em.close();
		return programmes;
	}
	
	

}
