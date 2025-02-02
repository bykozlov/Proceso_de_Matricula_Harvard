package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import entidad.Alumno;
import entidad.MatriculaAlumno;
import interfaces.MatriculaAlumnoDAO;
import utils.MySqlConexion;

public class MySqlMatriculaAlumnoDAO implements MatriculaAlumnoDAO {

	@Override
	public int guardar(MatriculaAlumno ma) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "insert into tb_RegMatricula values(null,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, ma.getCodAlumno());
			pstm.setInt(2, ma.getCodCiclo());
			pstm.setInt(3, ma.getCodCarrera());
			pstm.setInt(4, ma.getCodEstado());
			pstm.setDate(5, ma.getFecha());
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
	public int actualizar(MatriculaAlumno ma) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "update tb_RegMatricula set codCiclo=?,cod_carrera=?,idEstado=?, fecha=? where codMatricula=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, ma.getCodCiclo());
			pstm.setInt(2, ma.getCodCarrera());
			pstm.setInt(3, ma.getCodEstado());
			pstm.setDate(4, ma.getFecha());
			pstm.setInt(5, ma.getCodMatriculs());
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
	public int eliminar(int cod) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "delete from tb_RegMatricula where codMatricula=?";
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
	public List<MatriculaAlumno> listAll() {
		List<MatriculaAlumno> lista = new ArrayList<MatriculaAlumno>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select rm.codMatricula,al.idAlumno,al.nom_alm, ci.nomCiclo, ca.nombre,es.nom_Alm,rm.fecha from tb_regmatricula rm\r\n"
					+ "join tb_alumno al on al.idAlumno = rm.idAlumno\r\n"
					+ "join tb_ciclo ci on ci.codCiclo = rm.codCiclo\r\n"
					+ "join tb_carrera ca on ca.cod_carrera = rm.cod_carrera\r\n"
					+ "join tbestadoalm es on es.idEstado = rm.idEstado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MatriculaAlumno ma = new MatriculaAlumno();
				ma.setCodigo(rs.getInt(1));
				ma.setCodAlumno(rs.getInt(2));
				ma.setNomAlum(rs.getString(3));
				ma.setNomCiclo(rs.getString(4));
				ma.setNomCarrera(rs.getString(5));
				ma.setNomEstado(rs.getString(6));
				ma.setFecha(rs.getDate(7));
				lista.add(ma);
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
	public int getLastIMatricula() {
		int id = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "SELECT * from tb_RegMatricula ORDER BY codMatricula DESC";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				id = rs.getInt("codMatricula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public MatriculaAlumno findById(int cod) {
		MatriculaAlumno ma = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql = "select rm.codMatricula,al.idAlumno,al.nom_alm,al.ape_alm,ci.nomCiclo,ca.nombre,es.nom_Alm,rm.fecha from tb_regmatricula rm\r\n"
					+ "join tb_alumno al on al.idAlumno = rm.idAlumno\r\n"
					+ "join tb_ciclo ci on ci.codCiclo = rm.codCiclo\r\n"
					+ "join tb_carrera ca on ca.cod_carrera = rm.cod_carrera\r\n"
					+ "join tbestadoalm es on es.idEstado = rm.idEstado where rm.codMatricula=?";
			pstm = cn.prepareStatement(sql);

			pstm.setInt(1, cod);

			rs = pstm.executeQuery();
			if (rs.next()) {
				ma = new MatriculaAlumno();

				ma.setCodigo(rs.getInt(1));
				ma.setCodAlumno(rs.getInt(2));
				ma.setNomAlum(rs.getString(3));
				ma.setApes(rs.getString(4));
				ma.setNomCiclo(rs.getString(5));
				ma.setNomCarrera(rs.getString(6));
				ma.setNomEstado(rs.getString(7));
				ma.setFecha(rs.getDate(8));

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
		return  ma;
	}
}
