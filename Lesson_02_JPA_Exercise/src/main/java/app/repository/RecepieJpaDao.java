package app.repository;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entity.Recepie;

@Repository
public class RecepieJpaDao implements RecepieDao{
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Recepie create(Recepie recepie) {
		this.entityManager.persist(recepie);
		return recepie;
	}

	@Override
	public Collection<Recepie> getAll(int size, int page) {
		return this.entityManager
					.createNamedQuery("RecepieGetAll", Recepie.class)
					.setMaxResults(size)
					.setFirstResult(size*page)
					.getResultList();
	}

}
