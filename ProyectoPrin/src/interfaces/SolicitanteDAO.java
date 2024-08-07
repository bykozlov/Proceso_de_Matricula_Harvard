package interfaces;

import java.util.ArrayList;

import entidad.Solicitante;

public interface SolicitanteDAO {
	public int save(Solicitante so);
	public ArrayList <Solicitante> findAll();
	public int existedni(String dni);
	public int existetele(String tele);
	public boolean Email(String correo);
}
