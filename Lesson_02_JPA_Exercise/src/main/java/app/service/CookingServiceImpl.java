package app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Product;
import app.entity.Recepie;
import app.repository.ProductDao;
import app.repository.RecepieDao;

@Service
public class CookingServiceImpl implements CookingService{
	
	// repositories
	private RecepieDao recepiesDao;
	private ProductDao productsDao;
	
	@Autowired
	public void setRecepies(RecepieDao recepiesDao) {
		this.recepiesDao = recepiesDao;
	}
	
	@Autowired
	public void setProducts(ProductDao productsDao) {
		this.productsDao = productsDao;
	}
	
	@Override
	@Transactional
	public Recepie create(Recepie recepie, Iterable<Product> products) {
		
		this.recepiesDao.create(recepie);
		
		for (Product product : products) {
			productsDao.create(product);
		}
		
		return recepie;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Recepie> getAllRecepies(int size, int page) {
		return this.recepiesDao.getAll(size, page);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Product> getAllProducts(int size, int page) {
		return this.productsDao.getAll(size, page);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Product> getPrductsByPrice(double maxPrice, int size, int page) {
		return this.productsDao.getByMaxPrice (maxPrice, size, page);
	}

}
