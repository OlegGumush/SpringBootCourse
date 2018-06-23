package app.repository;

import java.util.Collection;

import app.entity.Product;

public interface ProductDao {
	public Product create (Product product);

	public Collection<Product> getAll(int size, int page);

	public Collection<Product> getByMaxPrice(double maxPrice, int size, int page);
}
