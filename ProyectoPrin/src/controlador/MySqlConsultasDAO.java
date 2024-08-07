package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidad.Consulta;
import interfaces.ConsultasDAO;
import utils.MySqlConexion;


public class MySqlConsultasDAO implements ConsultasDAO{

	@Override
	public ArrayList<Consulta> findAllEstado(String nombre, String estado) {
		ArrayList<Consulta>  lista = new ArrayList<Consulta>();
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
		cn=MySqlConexion.getConexion();
		String sql="call sp_cunsulta_por_estado(?,?)";

		cstm=cn.prepareCall(sql);
		//paso 4 parametros en la sentencia "?????"
		cstm.setString(1, nombre);
		cstm.setString(2, estado);
		
		//paso 5 ejecutar la sentencia y guardar el valor en el objeto "rs"
		rs=cstm.executeQuery();
		//paso 6 bucle para realizar recorrido sobre "rs"
		
		while(rs.next()==true) {
			//paso 7 crear objeto de clase mantenimiento
			Consulta man= new Consulta();
			//paso 8 asignar valor a los atributos del objeto "man" segun la fila actual
			man.setCodMatricula(rs.getInt(1));
			man.setCodEstado(rs.getInt(2));
			man.setNomEstado(rs.getString(3));
			man.setCodAlum(rs.getInt(4));
			man.setNomAlum(rs.getString(5));
			man.setCodCiclo(rs.getInt(6));
			man.setFechaDeIngreso(rs.getDate(7));
			//paso 9 adicionar objeto "lib" dentro del arreglo "lista"
			lista.add(man);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Consulta> findAllCurso(String nombre, String curso) {
		ArrayList<Consulta>  lista = new ArrayList<Consulta>();
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
		cn=MySqlConexion.getConexion();
		String sql="sp_cunsulta_notas(?,?)";

		cstm=cn.prepareCall(sql);
		//paso 4 parametros en la sentencia "?????"
		cstm.setString(1, nombre);
		cstm.setString(2, curso);
		
		//paso 5 ejecutar la sentencia y guardar el valor en el objeto "rs"
		rs=cstm.executeQuery();
		//paso 6 bucle para realizar recorrido sobre "rs"
		
		while(rs.next()==true) {
			//paso 7 crear objeto de clase mantenimiento
			Consulta man= new Consulta();
			//paso 8 asignar valor a los atributos del objeto "man" segun la fila actual
			man.setCodAlum(rs.getInt(1));
			man.setNomAlum(rs.getString(2));
			man.setNomCurso(rs.getString(3));
			man.setNota1(rs.getInt(4));
			man.setNota2(rs.getInt(5));
			man.setNota3(rs.getInt(6));
			man.setNota4(rs.getInt(7));
			//paso 9 adicionar objeto "lib" dentro del arreglo "lista"
			lista.add(man);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(cstm!=null)cstm.close();
				if(cn!=null)cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	
	

}
