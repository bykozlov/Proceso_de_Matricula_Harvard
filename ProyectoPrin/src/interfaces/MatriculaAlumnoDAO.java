package interfaces;

import java.util.List;

import entidad.MatriculaAlumno;

public interface MatriculaAlumnoDAO {
	public int guardar(MatriculaAlumno ma);
	public int actualizar(MatriculaAlumno ma);
	public int eliminar(int cod);
	public MatriculaAlumno findById(int cod);
	public List<MatriculaAlumno> listAll();
	int getLastIMatricula();
}
