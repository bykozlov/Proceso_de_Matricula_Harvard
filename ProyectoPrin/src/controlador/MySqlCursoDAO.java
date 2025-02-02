package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Consulta;
import entidad.Curso;
import interfaces.CursoDAO;
import utils.MySqlConexion;

public class MySqlCursoDAO implements CursoDAO {

	@Override
	public int save(Curso crso) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "insert into tb_curso values(null,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, crso.getAsignatura());
			pstm.setInt(2, crso.getCredi());
			pstm.setInt(3, crso.getHoras());
			pstm.setInt(4, crso.getCiclo());
			
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
	public int update(Curso crso) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "update tb_curso set asig_curso= ?,credi_curso= ?,horas_curso= ?,codCiclo= ? where cod_curso= ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, crso.getAsignatura());
			pstm.setInt(2, crso.getCredi());
			pstm.setInt(3, crso.getHoras());
			pstm.setInt(4, crso.getCiclo());
			pstm.setInt(5, crso.getCodCurso());
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
			String sql = "delete from tb_curso where cod_curso=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			salida = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (cn != null)cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public ArrayList<Curso> findAll() {
		ArrayList<Curso> lista = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select c.cod_curso,i.nomCiclo,c.asig_curso,c.credi_curso,c.horas_curso from tb_curso as c \r\n"
					+ "    join tb_Ciclo as i on c.codCiclo=i.codCiclo";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next() == true) {
				
				Curso curso = new Curso();
				curso.setCodCurso(rs.getInt(1));
				curso.setNom_ciclo(rs.getString(2));
				curso.setAsignatura(rs.getString(3));
				curso.setCredi(rs.getInt(4));
				curso.setHoras(rs.getInt(5));
				lista.add(curso);
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
	
	public int getLastICurso() {
		 int id = 0;
	        Connection cn=null;
	        PreparedStatement pstm=null;
	        ResultSet rs = null;
	        try {
	            cn = MySqlConexion.getConexion();
	            String sql = "SELECT * from tb_Curso ORDER BY cod_curso DESC";
	            pstm = cn.prepareStatement(sql);
	            rs = pstm.executeQuery();
	            if(rs.next()) {
	                id = rs.getInt("cod_curso");
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

	@Override
	public Curso findById(int cod) {
		Curso bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select c.cod_curso,i.nomCiclo,c.asig_curso,c.credi_curso,c.horas_curso from tb_curso as c\r\n"
					+ "    join tb_Ciclo as i on c.codCiclo=i.codCiclo where cod_curso= ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				bean=new Curso();
				
				bean.setCodCurso(rs.getInt(1));
				bean.setNom_ciclo(rs.getString(2));
				bean.setAsignatura(rs.getString(3));
				bean.setCredi(rs.getInt(4));
				bean.setHoras(rs.getInt(5));
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


	

}
