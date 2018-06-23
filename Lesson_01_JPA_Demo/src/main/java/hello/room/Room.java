package hello.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ROOMS")
@NamedQueries({
	@NamedQuery(
			name="RoomGetAll", 
			query="SELECT r FROM Room AS r ORDER BY r.id DESC")
})
public class Room {
	private Long roomId;
	private String floor;
	private String type;
	private String number;

	public Room() {
		super();
	}

	public Room(Long id, String floor, String type, String number) {
		this();
		this.roomId = id;
		this.floor = floor;
		this.type = type;
		this.number = number;
	}

	public Room(String floor, String type, String number) {
		this(null, floor, type, number);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_OF_ROOM")
	public Long getId() {
		return roomId;
	}

	public void setId(Long id) {
		this.roomId = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Transient
	public String getDetails() {
		return toString();
	}

	@Override
	public String toString() {
		return "Room [id=" + roomId + ", floor=" + floor + ", type=" + type + ", number=" + number + "]";
	}

}
