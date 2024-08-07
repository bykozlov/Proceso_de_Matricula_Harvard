package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Carrera;
import entidad.Curso;
import interfaces.CarreraDAO;
import utils.MySqlConexion;

public class MySqlCarreraDAO implements CarreraDAO{

	@Override
	public int save(Carrera crso) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "insert into tbCarreraCur values(null,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, crso.getCodCarrera());
			pstm.setInt(2, crso.getCodCurso());
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public int deleteById(int cod) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "delete from tbCarreraCur where codCarreCur=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public Carrera findById(int cod) {
		Carrera bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select cc.codCarreCur,car.nombre,cur.asig_curso from tbCarreraCur as cc \r\n"
					+ "inner join tb_curso as cur on cc.cod_curso=cur.cod_curso\r\n"
					+ "inner join tb_carrera as car on cc.codCarrera=car.Cod_Carrera\r\n"
					+ "where codCarreCur = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				bean=new Carrera();
				
				bean.setCodCarCurso(rs.getInt(1));
				bean.setNomCarrera(rs.getString(2));
				bean.setNomCurso(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public ArrayList<Carrera> findAll() {
		ArrayList<Carrera> lista = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select cc.codCarreCur,car.nombre,cur.asig_curso from tbCarreraCur as cc\r\n"
					+ "inner join tb_curso as cur on cc.cod_curso=cur.cod_curso\r\n"
					+ "inner join tb_carrera as car on cc.CodCarrera=car.Cod_Carrera";
			
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next() == true) {
				
				Carrera Carrera = new Carrera();
				Carrera.setCodCarCurso(rs.getInt(1));
				Carrera.setNomCarrera(rs.getString(2));
				Carrera.setNomCurso(rs.getString(3));
				lista.add(Carrera);
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
		return lista;
	}

	@Override
	public int getLastICurso() {
		int id = 0;
        Connection cn=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        try {
            cn = MySqlConexion.getConexion();
            String sql = "SELECT * from tbCarreraCur ORDER BY codCarreCur DESC";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if(rs.next()) {
                id = rs.getInt("codCarreCur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstm!=null)pstm.close();
                if(rs!=null)rs.close();
                if(cn!=null)cn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return id;
	}
	

}
