package interfaces;

import java.util.ArrayList;
import entidad.Alumno;

public interface AlumnoDAO {

	/* MÉTODOS */
	public int save(Alumno bean);
	public int update(Alumno bean);
	public int deleteById(int cod);
	public Alumno findById(int cod);
	public ArrayList <Alumno> findAll();
	public int existedni(String dni);
	public int existetele(String tele);
	
}
