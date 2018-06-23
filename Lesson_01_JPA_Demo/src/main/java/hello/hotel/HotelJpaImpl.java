package hello.hotel;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.room.Room;

@Repository
public class HotelJpaImpl implements Hotel{
	
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public Room create(Room room) {
		this.entityManager.persist(room);
		return room;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Room> getRooms(int size, int page) {
		return this.entityManager
			.createNamedQuery("RoomGetAll", Room.class)
			.setMaxResults(size)
			.setFirstResult(page*size)
			.getResultList();
	}
}






