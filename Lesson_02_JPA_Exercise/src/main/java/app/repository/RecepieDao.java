package app.repository;

import java.util.Collection;

import app.entity.Recepie;

public interface RecepieDao {

	public Recepie create(Recepie recepie);

	public Collection<Recepie> getAll(int size, int page);

}
