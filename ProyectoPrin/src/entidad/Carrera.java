package entidad;

public class Carrera {
	int codCarrera,codCurso,CodCarCurso;
	String nomCarrera,nomCurso;
	
	public int getCodCarCurso() {
		return CodCarCurso;
	}
	public void setCodCarCurso(int codCarC) {
		CodCarCurso = codCarC;
	}
	public int getCodCarrera() {
		return codCarrera;
	}
	public void setCodCarrera(int codCarrera) {
		this.codCarrera = codCarrera;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getNomCarrera() {
		return nomCarrera;
	}
	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}
	public String getNomCurso() {
		return nomCurso;
	}
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	
}
