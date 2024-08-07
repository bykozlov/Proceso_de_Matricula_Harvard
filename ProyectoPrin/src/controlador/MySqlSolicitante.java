package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidad.Solicitante;
import interfaces.SolicitanteDAO;
import utils.MySqlConexion;

public class MySqlSolicitante implements SolicitanteDAO {
	/* SAVE */
	@Override
	public int save(Solicitante so) {
		 int salida = -1;
		 Connection cn = null;
		 PreparedStatement pstm = null;
		 try {
			 cn = MySqlConexion.getConexion();
			 String sql = "insert into tb_Solicitante values(?,?,?,?,?,?,?)";
			 pstm = cn.prepareStatement(sql);

			 pstm.setInt(1, so.getDni());
			 pstm.setString(2, so.getNombre());
			 pstm.setString(3, so.getApellido());
			 pstm.setString(4, so.getEmail());
			 pstm.setInt(5, so.getEdad());
			 pstm.setString(6, so.getSexo());
			 pstm.setInt(7, so.getCelular());

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

	@Override
	public ArrayList<Solicitante> findAll() {
		ArrayList <Solicitante> lista = new ArrayList <Solicitante>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select * from tb_solicitante";
			pstm = cn.prepareStatement(sql);

			rs = pstm.executeQuery();
			while(rs.next() == true) {
				Solicitante lib=new Solicitante();
				
				lib.setDni(rs.getInt(1));
				lib.setNombre(rs.getString(2));
				lib.setApellido(rs.getString(3));
				lib.setEmail(rs.getString(4));
				lib.setEdad(rs.getInt(5));
				lib.setSexo(rs.getString(6));
				lib.setCelular(rs.getInt(7));
				
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
		
		String sql = "Select count(dni) from tb_solicitante where dni=?";
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
		
		String sql = "Select count(celular) from tb_solicitante where celular=?";
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

	@Override
	public boolean Email(String correo) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\++]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
		
		Matcher mather = pattern.matcher(correo);
		return mather.find();
	}
}
