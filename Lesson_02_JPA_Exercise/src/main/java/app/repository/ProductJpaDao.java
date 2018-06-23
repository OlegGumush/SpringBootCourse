package app.repository;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entity.Product;

@Repository
public class ProductJpaDao implements ProductDao{
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Product create(Product product) {
		this.entityManager.persist(product);
		return product;
	}

	@Override
	public Collection<Product> getAll(int size, int page) {
		return this.entityManager
			.createNamedQuery("ProductGetAll", Product.class)
			.setMaxResults(size)
			.setFirstResult(page*size)
			.getResultList();
	}

	@Override
	public Collection<Product> getByMaxPrice(double maxPrice, int size, int page) {
		return this.entityManager
				.createNamedQuery("ProductGetByPrice", Product.class)
				.setParameter("maxPrice", maxPrice)
				.setMaxResults(size)
				.setFirstResult(page*size)
				.getResultList();
	}

}










