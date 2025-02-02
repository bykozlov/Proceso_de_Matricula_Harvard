package controlador;

import utils.MySqlConexion;
import entidad.RegistrarUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlRegistroDAO extends MySqlConexion{
	
	public boolean registrarUsuario(RegistrarUsuario bean) {
		PreparedStatement pstm=null;
		Connection cn = getConexion();
		
		try {
			String sql ="Insert into registro(codusu,usuario,clave,nom,ape,correo) values(?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, bean.getTipo_usuario());
			pstm.setString(2, bean.getUsuario());
			pstm.setString(3, bean.getClave());
			pstm.setString(4, bean.getNom());
			pstm.setString(5, bean.getApe());
			pstm.setString(6, bean.getCorreo());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public int existeUsuario(String usuario) {

		PreparedStatement pstm=null;
		ResultSet rs = null;
		Connection cn = getConexion();
		
		String sql = "Select count(idRegistro) from registro where usuario=?";
		try {
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, usuario);
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
	
	public boolean Email(String correo) {
		//patron para validar email
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\++]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})");
		
		Matcher mather = pattern.matcher(correo);
		return mather.find();
	}
	
	public boolean login(RegistrarUsuario bean) {

		PreparedStatement pstm=null;
		ResultSet rs = null;
		Connection cn = getConexion();
		
		String sql = "select idRegistro,codusu,usuario,clave,nom,ape from registro where usuario=?";
		try {
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getUsuario());
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				if(bean.getClave().equals(rs.getString(4))) {
					String sqlUpdate = "Update registro set fechaDeIngreso=? where idRegistro=? ";
					pstm=cn.prepareStatement(sqlUpdate);
					pstm.setString(1, bean.getFechaDeIngreso());
					pstm.setInt(2, rs.getInt(1));
					pstm.execute();
					
					bean.setIdRegistro(rs.getInt(1));
					bean.setTipo_usuario(rs.getInt(2));
					bean.setNom(rs.getString(5));
					bean.setApe(rs.getString(6));
					return true;
				}else {
					return false;
				}
			}
			
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
}
