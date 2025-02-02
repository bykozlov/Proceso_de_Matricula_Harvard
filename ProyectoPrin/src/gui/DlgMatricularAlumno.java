package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import componente.JComboBoxBD1;
import controlador.MySqlMatriculaAlumnoDAO;
import entidad.MatriculaAlumno;

import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.awt.event.MouseEvent;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DlgMatricularAlumno extends JDialog implements MouseListener, ActionListener {
	private MySqlMatriculaAlumnoDAO dao = new MySqlMatriculaAlumnoDAO();
	ResourceBundle p = ResourceBundle.getBundle("SENTENCIAS_SQL");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCodMatricula;
	private JTextField txtNom;
	private JComboBox cboCiclo;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JTable tblAlumno;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JComboBox cboCarrera;
	private JTextField txtCodAlumno;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMatricularAlumno dialog = new DlgMatricularAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMatricularAlumno() {
		getContentPane().setBackground(new Color(255, 102, 102));
		setTitle("Matricular Alumno");
		setBounds(100, 100, 900, 397);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lblNewLabel = new JLabel("N\u00FAmero de matr\u00EDcula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 14, 116, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("C\u00F3digo de alumno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 45, 116, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Ciclo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 76, 116, 14);
		getContentPane().add(lblNewLabel_2);

		txtCodMatricula = new JTextField();
		txtCodMatricula.setEditable(false);
		txtCodMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodMatricula.setBounds(136, 11, 100, 20);
		getContentPane().add(txtCodMatricula);
		txtCodMatricula.setColumns(10);

		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNom.setBounds(406, 87, 210, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);

		cboCiclo = new JComboBoxBD1(p.getString("sql_ciclo"));
		cboCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCiclo.setBounds(136, 72, 100, 22);
		getContentPane().add(cboCiclo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgMatricularAlumno.class.getResource("/img/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.setBounds(728, 41, 146, 23);
		getContentPane().add(btnAdicionar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgMatricularAlumno.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(728, 86, 146, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 864, 219);
		getContentPane().add(scrollPane);

		tblAlumno = new JTable();
		tblAlumno.addMouseListener(this);
		tblAlumno.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "NUM.MATR\u00CDCULA", "COD.ALUMNO", "Nombre", "CICLO", "CARRERA", "ESTADO", "FECHA" }));
		scrollPane.setViewportView(tblAlumno);

		lblNewLabel_3 = new JLabel("Carrera");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 107, 116, 14);
		getContentPane().add(lblNewLabel_3);

		cboCarrera = new JComboBoxBD1(p.getString("sql_carrera"));
		cboCarrera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCarrera.setBounds(136, 104, 100, 22);
		getContentPane().add(cboCarrera);

		txtCodAlumno = new JTextField();
		txtCodAlumno.setBounds(136, 43, 100, 20);
		getContentPane().add(txtCodAlumno);
		txtCodAlumno.setColumns(10);

		lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(246, 15, 40, 14);
		getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(246, 46, 40, 14);
		getContentPane().add(lblNewLabel_5);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(296, 43, 100, 20);
		getContentPane().add(dcFecha);
		dcFecha.setDateFormatString("yyyy-MM-dd");

		cboEstado = new JComboBoxBD1(p.getString("sql_estado"));
		cboEstado.setBounds(296, 11, 100, 22);
		getContentPane().add(cboEstado);
		listado();
		cantidadMatricula();

	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	
	//metodos
	int getCiclo() {
		return cboCiclo.getSelectedIndex()+1;
	}
	int getCarrera() {
		return cboCarrera.getSelectedIndex()+1;
	}
	int getEstado() {
		return cboEstado.getSelectedIndex()+1;
	}
	int getCodMatricula() {
		return Integer.parseInt(txtCodMatricula.getText());
	}
	int getCodAlumno() {
		return Integer.parseInt(txtCodAlumno.getText());
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {

		String fecha = ((JTextField) dcFecha.getDateEditor().getUiComponent()).getText();

		if (fecha.trim().equals("")) {
			mensaje("Debes agregar un fecha");
			dcFecha.requestFocus();
		} else {
		
			
			MatriculaAlumno ma = new MatriculaAlumno();

			ma.setCodAlumno(getCodAlumno());
			ma.setCodCiclo(getCiclo());
			ma.setCodCarrera(getCarrera());
			ma.setCodEstado(getEstado());
			ma.setFecha(java.sql.Date.valueOf(fecha));
			int salida;
			salida = dao.guardar(ma);
			if (salida == 1) {
				mensaje("Alumno registrado");
				listado();
				limpiar();

			} else
				mensaje("Registro denegado");
		}
	}

	private void cantidadMatricula() {
		int id = dao.getLastIMatricula();
		id++;
		txtCodMatricula.setText("" + id);
	}
	

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int cod, boton;
		boton = JOptionPane.showConfirmDialog(null, "Seguro de eliminar al alumno?", "Sistema",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (boton == 0) {
			cod = Integer.parseInt(txtCodMatricula.getText());
			int salida;
			salida = dao.eliminar(cod);

			if (salida == 1) {
				mensaje("Alumno eliminado");
				listado();
			} else
				mensaje("Error al eliminar alumno");
		}
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void listado() {
		DefaultTableModel model = (DefaultTableModel) tblAlumno.getModel();
		model.setRowCount(0);
		List<MatriculaAlumno> data = dao.listAll();
		for (MatriculaAlumno ma : data) {
			Object row[] = { ma.getCodigo(), ma.getCodAlumno(), ma.getNomAlum(), ma.getNomCiclo(), ma.getNomCarrera(),
					ma.getNomEstado(), ma.getFecha() };
			model.addRow(row);
		}
	}
	//
	void mostrarDatos() {
		int posFila;
		String cod;
		posFila = tblAlumno.getSelectedRow();

		cod = tblAlumno.getValueAt(posFila, 0).toString();

		MatriculaAlumno ma = dao.findById(Integer.parseInt(cod));

		txtCodMatricula.setText(cod);
		txtCodAlumno.setText(ma.getCodAlumno() + "");
		txtNom.setText(ma.getNomAlum() + " " + ma.getApes());
		cboCiclo.setSelectedItem(ma.getNomCiclo());
		cboCarrera.setSelectedItem(ma.getNomCarrera());
		cboEstado.setSelectedItem(ma.getNomEstado());
		dcFecha.setDate(ma.getFecha());
	}

	void limpiar() {
		cantidadMatricula();
		txtCodMatricula.setText("");
		txtCodAlumno.setText("");
		dcFecha.setDateFormatString("");
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAlumno) {
			mouseClickedTblAlumno(e);
		}
	}

	

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTblAlumno(MouseEvent e) {
		int fila;
		fila = tblAlumno.getSelectedRow();
		mostrarDatos();

	}
}
