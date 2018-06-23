package app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.constants.Diffculty;
import app.constants.TempType;
import app.entity.Product;
import app.entity.Recepie;
import app.service.CookingService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private CookingService cookingService;
	
	@Autowired
	public void setCookingService(CookingService cookingService) {
		this.cookingService = cookingService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Recepie tomatoSoup = new Recepie ("Tomato Soup", Diffculty.EASY, TempType.HOT, 39, new Date()); 
		
		
		// get T ... of products and return List<T>
		Collection<Product> products = 
				Arrays.asList(
						new Product ("137", "Tomato Bag", 4.99),
						new Product ("317", "Cumin", 0.81),
						new Product ("713", "Onions", 3.9),
						new Product ("11111", "A sip of Salt", 0.06));
		
		this.cookingService.create(tomatoSoup, products);
		int size = 3;
		int page = 0;
		
		Collection<Product> productsPage;
		do {
			productsPage = this.cookingService.getPrductsByPrice (5, size, page++);
			productsPage.forEach(System.err::println);
		}while(productsPage.size() == size);
	}
}
















