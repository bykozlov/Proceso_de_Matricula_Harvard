package interfaces;

import java.util.ArrayList;

import entidad.Consulta;
import entidad.Curso;


public interface ConsultasDAO {
	public ArrayList<Consulta> findAllEstado(String nombre,String estado);
	public ArrayList<Consulta> findAllCurso(String nombre, String curso);
	
}
