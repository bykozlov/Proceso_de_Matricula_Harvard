package interfaces;

import java.util.ArrayList;

import entidad.Carrera;

public interface CarreraDAO {
	public int save(Carrera crso);
	public int deleteById(int cod);
	public Carrera findById(int cod);
	public ArrayList<Carrera> findAll();
	
	int getLastICurso();
}
