package app.service;

import java.util.Collection;

import app.entity.Product;
import app.entity.Recepie;

public interface CookingService {

	public Recepie create(Recepie recepie, Iterable<Product> products);
	public Collection<Recepie> getAllRecepies(int size, int page);
	public Collection<Product> getAllProducts(int size, int page);
	public Collection<Product> getPrductsByPrice(double maxPrice, int size, int page);
}
