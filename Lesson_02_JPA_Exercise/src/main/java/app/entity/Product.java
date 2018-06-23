package app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ProductGetAll", query="SELECT p FROM Product AS p"),
	@NamedQuery(name="ProductGetByPrice", query="SELECT p FROM Product AS p WHERE p.price <= :maxPrice"),
})
public class Product {
	private String serialNumber;
	private String name;
	private double price;

	public Product() {
	}

	public Product(String serialNumber, String name, double price) {
		super();
		this.serialNumber = serialNumber;
		this.name = name;
		this.price = price;
	}

	@Id
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [serialNumber=" + serialNumber + ", name=" + name + ", price=" + price + "]";
	}

}
