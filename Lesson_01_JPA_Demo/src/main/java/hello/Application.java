package hello;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hello.hotel.Hotel;
import hello.room.Room;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	private Hotel hotel;
	private long number;
	
	@Autowired
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		number = 1000;
		System.err.println("creating rooms...");
		
		String [][] rooms= {new String[]{"Delux", "1"}, 
					   new String[]{"Standard", "floor"}, 
				       new String[]{"Presidential Suite", "top"}, 
				       new String[]{"Closet", "Attic"}};
		
		for (int i = 0; i < rooms.length; i++) {
			hotel.create(new Room(rooms[i][0],rooms[i][1], ""+number++));
		}
		
		int size = 3;
		int page = 0;
		
		Collection<Room> roomsPage;
		do {
			// get 3 roomes
			roomsPage = hotel.getRooms(size, page++);
			// There is an result
			if (!roomsPage.isEmpty()) {
				System.err.println("page #" + page);
			}
			// print rooms
			roomsPage.forEach(room->System.err.println("\t" + room));
		
		} while(roomsPage.size() == size);

	}
}








