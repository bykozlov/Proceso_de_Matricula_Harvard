package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Alumno;
import interfaces.AlumnoDAO;
import utils.MySqlConexion;

public class MySQLAlumnoDAO implements AlumnoDAO {

	/* SAVE */
	@Override
	public int save(Alumno bean) {
		 int salida = -1;
		 Connection cn = null;
		 PreparedStatement pstm = null;
		 try {
			 cn = MySqlConexion.getConexion();
			 String sql = "insert into tb_Alumno values(null, ?,?,?,?,?,?,?)";
			 pstm = cn.prepareStatement(sql);

			 pstm.setString(1, bean.getNombre());
			 pstm.setString(2, bean.getApellido()); 
			 pstm.setInt(3, bean.getDni());
			 pstm.setInt(5, bean.getEdad());
			 pstm.setInt(4, bean.getCelular());
			 pstm.setString(6,bean.getSexo());
			 pstm.setDate(7, bean.getFecha());

			 salida = pstm.executeUpdate();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 finally {
			 try {
				 if(pstm != null) pstm.close();
				 if(cn != null) cn.close();
			 } catch (SQLException e2) {
				 e2.printStackTrace();
			 }
		 }
		 return salida;
	}

	/* UPDATE */
	@Override
	public int update(Alumno bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "update tb_Alumno set nom_alm=?, ape_alm=?, dni_alm=?, celar_alm=?, edad=?,sexo=?,FechaRegistro=? where idAlumno=?";
			pstm = cn.prepareStatement(sql);
			
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getApellido());
			pstm.setInt(3, bean.getDni());
			pstm.setInt(4, bean.getCelular());
			pstm.setInt(5, bean.getEdad());
			pstm.setString(6, bean.getSexo());
			pstm.setDate(7, bean.getFecha());
			
			pstm.setInt(8, bean.getCodAlumno());
			
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null)cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}	

	/* DELETEByID */
	@Override
	public int deleteById(int cod) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "delete from tb_Alumno where idAlumno=?";
			pstm = cn.prepareStatement(sql);
			
			pstm.setInt(1, cod);
			
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	/* FINDByID */
	@Override
	public Alumno findById(int cod) {
		Alumno bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "SELECT A.CodAlum, A.NomAlum, A.ApeAlum, A.DniAlum,A.EdadAlum,A.CelularAlum, E.codEstado FROM `tb_Alumno` as A "
						+ "JOIN `tb_Estado` as E ON A.CodEstado = E.codEstado WHERE A.CodAlum =?";
			pstm = cn.prepareStatement(sql);

			pstm.setInt(1, cod);

			rs = pstm.executeQuery();
			if(rs.next()) {
				bean = new Alumno();
				
				bean.setCodAlumno(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setDni(rs.getInt(4));
				bean.setEdad(rs.getInt(5));	
				bean.setCelular(rs.getInt(6));

			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	/* FINDALL */
	@Override
	public ArrayList <Alumno> findAll() {
		ArrayList <Alumno> lista = new ArrayList <Alumno> ();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select * from tb_Alumno";
			pstm = cn.prepareStatement(sql);

			rs = pstm.executeQuery();
			while(rs.next() == true) {
				Alumno lib=new Alumno();
				
				lib.setCodAlumno(rs.getInt(1));
				lib.setNombre(rs.getString(2));
				lib.setApellido(rs.getString(3));
				lib.setDni(rs.getInt(4));
				lib.setEdad(rs.getInt(5));
				lib.setCelular(rs.getInt(6));
				lib.setSexo(rs.getString(7));
				lib.setFecha(rs.getDate(8));
				
				lista.add(lib);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int existedni(String dni) {
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Connection cn = null;
		
		String sql = "Select count(dni_alm) from tb_Alumno where dni_alm=?";
		try {
			cn = MySqlConexion.getConexion();
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, dni);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int existetele(String tele) {
		PreparedStatement pstm=null;
		ResultSet rs = null;
		Connection cn = null;
		
		String sql = "Select count(celar_alm) from tb_Alumno where celar_alm=?";
		try {
			cn = MySqlConexion.getConexion();
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, tele);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	


}
