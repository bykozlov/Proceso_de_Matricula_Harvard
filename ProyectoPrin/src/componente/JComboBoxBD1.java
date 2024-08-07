package componente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;


import utils.MySqlConexion;

public class JComboBoxBD1 extends JComboBox {
	
	public JComboBoxBD1(String sql) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			
			pstm = cn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				addItem(rs.getString(2));
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
	}
}