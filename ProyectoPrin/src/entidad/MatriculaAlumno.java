package entidad;

import java.sql.Date;

public class MatriculaAlumno {
	private int codigo, codAlumno, codCiclo, codCarrera, codEstado, codMatriculs;
	private Date fecha;
	private String nomCiclo, nomCarrera, nomEstado, nomAlum, apes;

	public String getNomAlum() {
		return nomAlum;
	}

	public String getApes() {
		return apes;
	}

	public void setApes(String apes) {
		this.apes = apes;
	}

	public void setNomAlum(String nomAlum) {
		this.nomAlum = nomAlum;
	}

	public int getCodMatriculs() {
		return codMatriculs;
	}

	public void setCodMatriculs(int codMatriculs) {
		this.codMatriculs = codMatriculs;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCiclo() {
		return codCiclo;
	}

	public void setCodCiclo(int codCiclo) {
		this.codCiclo = codCiclo;
	}

	public int getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(int codCarrera) {
		this.codCarrera = codCarrera;
	}

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNomCiclo() {
		return nomCiclo;
	}

	public void setNomCiclo(String nomCiclo) {
		this.nomCiclo = nomCiclo;
	}

	public String getNomCarrera() {
		return nomCarrera;
	}

	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
}
