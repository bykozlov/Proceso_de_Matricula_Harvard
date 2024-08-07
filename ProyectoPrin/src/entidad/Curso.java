package entidad;

public class Curso {
	private int codCurso, ciclo, credi, horas, codCiclo;
	private String asignatura, nom_ciclo,nombreAlm;
	
	
	
	
	public String getNombreAlm() {
		return nombreAlm;
	}
	public void setNombreAlm(String nombreAlm) {
		this.nombreAlm = nombreAlm;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int cod) {
		this.codCurso = cod;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public int getCredi() {
		return credi;
	}
	public void setCredi(int credi) {
		this.credi = credi;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getCodCiclo() {
		return codCiclo;
	}
	public void setCodCiclo(int codCiclo) {
		this.codCiclo = codCiclo;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public String getNom_ciclo() {
		return nom_ciclo;
	}
	public void setNom_ciclo(String nom_ciclo) {
		this.nom_ciclo = nom_ciclo;
	}
}
