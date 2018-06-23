package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import app.constants.Diffculty;
import app.constants.TempType;

@Entity
@NamedQuery(name = "RecepieGetAll", query = "SELECT r FROM Recepie AS r ORDER BY r.publicationDate DESC")
public class Recepie {
	
	
	private Long id;
	private String name;
	private Diffculty diffculty;
	private TempType temp;
	private int minutesOfCooking;
	private Date publicationDate;

	public Recepie() {
	}

	public Recepie(String name, Diffculty diffculty, TempType temp, int minutesOfCooking, Date publicationDate) {
		super();
		this.name = name;
		this.diffculty = diffculty;
		this.temp = temp;
		this.minutesOfCooking = minutesOfCooking;
		this.publicationDate = publicationDate;
	}

	@Id
	@Column(name = "REC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// enum to string
	@Enumerated(EnumType.STRING)
	public Diffculty getDiffculty() {
		return diffculty;
	}

	public void setDiffculty(Diffculty diffculty) {
		this.diffculty = diffculty;
	}

	// enum to number
	@Enumerated(EnumType.ORDINAL)
	public TempType getTemp() {
		return temp;
	}

	public void setTemp(TempType temp) {
		this.temp = temp;
	}

	public int getMinutesOfCooking() {
		return minutesOfCooking;
	}

	public void setMinutesOfCooking(int minutesOfCooking) {
		this.minutesOfCooking = minutesOfCooking;
	}

	// special for date
	@Temporal(TemporalType.DATE)
	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public String toString() {
		return "Recepie [id=" + id + ", name=" + name + ", diffculty=" + diffculty + ", temp=" + temp
				+ ", minutesOfCooking=" + minutesOfCooking + ", publicationDate=" + publicationDate + "]";
	}

}
