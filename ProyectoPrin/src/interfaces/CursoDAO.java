package interfaces;

import java.util.ArrayList;

import entidad.Curso;

public interface CursoDAO {
	public int save(Curso crso);
	public int update(Curso crso);
	public int deleteById(int cod);
	public Curso findById(int cod);
	public ArrayList<Curso> findAll();

	int getLastICurso();
}
