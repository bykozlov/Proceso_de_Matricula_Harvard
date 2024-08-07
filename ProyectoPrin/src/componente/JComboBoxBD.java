package componente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import utils.MySqlConexion;

public class JComboBoxBD extends JComboBox {
	
	public JComboBoxBD(String sql, int columna, String texto) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// 1
			cn =  MySqlConexion.getConexion();
			// 3
			pstm = cn.prepareStatement(sql);
			// 5
			rs = pstm.executeQuery();
			// 6
			// Agregar un texto al inicio del combo box, si se deja vacio, no se agrega nada
			if (texto.trim().length() != 0) {
				addItem(texto);
			}

			while (rs.next()) {
				addItem(rs.getString(columna));
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
	}

	public static void actualizarInformacion(String sql, int columna, String texto, JComboBox combo) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// 1
			cn = MySqlConexion.getConexion();
			// 3
			pstm = cn.prepareStatement(sql);
			// 5
			rs = pstm.executeQuery();
			// 6
			combo.removeAllItems();
			if (texto.trim().length() != 0) {
				combo.addItem(texto);
			}

			while (rs.next()) {
				combo.addItem(rs.getString(columna));
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
	}
}
	
