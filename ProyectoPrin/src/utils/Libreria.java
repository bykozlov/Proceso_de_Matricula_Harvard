package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Libreria {

	public static int findByEstado(String nombreABuscar, String nombreTabla, String nombreColumna) {
		int codigo = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select * from " + nombreTabla + " where " + nombreColumna + "='" + nombreABuscar + "'";
			pstm = cn.prepareStatement(sql);

			rs = pstm.executeQuery();
			if (rs.next()) {
				codigo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return codigo;
	}

	public static int findByAlumno(String nombreABuscar, String nombreTabla, String nombreColumna) {
		int codigo = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select * from " + nombreTabla + " where " + nombreColumna + "='" + nombreABuscar + "'";
			pstm = cn.prepareStatement(sql);

			rs = pstm.executeQuery();
			if (rs.next()) {
				codigo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return codigo;
	}

	public static int findByCiclo(String nombreABuscar, String nombreTabla, String nombreColumna) {
		int codigo = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// 1
			cn = MySqlConexion.getConexion();
			// 2 //select *from tb_libro where tit_lib="JAVA"
			String sql = "select *from " + nombreTabla + " where " + nombreColumna + "='" + nombreABuscar + "'";
			// 3.
			pstm = cn.prepareStatement(sql);
			// 4. ? ? ? ? ?
			// 5
			rs = pstm.executeQuery();
			// 6. validar si existe fila
			if (rs.next()) {
				codigo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return codigo;
	}
}
