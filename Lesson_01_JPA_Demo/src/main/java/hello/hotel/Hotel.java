package hello.hotel;

import java.util.Collection;

import hello.room.Room;

public interface Hotel {

	public Room create(Room room);

	public Collection<Room> getRooms(int size, int page);

}
