package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import componente.JComboBoxBD;
import controlador.MySqlConsultasDAO;
import entidad.Consulta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DlgConsultarAlumnoCurso extends JDialog implements ActionListener {
	ResourceBundle p = ResourceBundle.getBundle("SENTENCIAS_SQL");
	private MySqlConsultasDAO ConsultasDAO = new MySqlConsultasDAO();
	
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JScrollPane scrollPane;
	private JButton btnMostrarAlumno;
	private JComboBox cboEs;
	private JTable tbRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultarAlumnoCurso dialog = new DlgConsultarAlumnoCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultarAlumnoCurso() {
		getContentPane().setBackground(new Color(255, 102, 102));
		setTitle("CONSULTAR ALUMNO POR ESTADOD DE MATRICULA");
		setBounds(100, 100, 572, 542);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de alumno:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 32, 120, 14);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(147, 29, 100, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 536, 414);
		getContentPane().add(scrollPane);
		
		tbRegistro = new JTable();
		tbRegistro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null, null},
			},
			new String[] {
				"Cod. Matricula", "Cod. Estado", "Estado", "Cod. Alumno", "Nombre", "Ciclo", "Fecha Matricula"
			}
		));
		scrollPane.setViewportView(tbRegistro);
		
		btnMostrarAlumno = new JButton("Mostrar Alumno");
		btnMostrarAlumno.setIcon(new ImageIcon(DlgConsultarAlumnoCurso.class.getResource("/img/mostrar.png")));
		btnMostrarAlumno.addActionListener(this);
		btnMostrarAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrarAlumno.setBounds(405, 28, 141, 23);
		getContentPane().add(btnMostrarAlumno);
		
		cboEs = new JComboBoxBD(p.getString("sql_estado"), 2,"TODOS");
		cboEs.setBounds(273, 29, 100, 20);
		getContentPane().add(cboEs);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrarAlumno) {
			actionPerformedBtnMostrarAlumno(e);
		}
	}
	protected void actionPerformedBtnMostrarAlumno(ActionEvent e) {
		metoEstad();
	}
	
	
	void metoEstad() {
		
		ArrayList<Consulta> lista = ConsultasDAO.findAllEstado(cboEs.getSelectedItem().toString(),
				txtNombre.getText());
		
		DefaultTableModel model = (DefaultTableModel) tbRegistro.getModel();
		
		model.setRowCount(0);
		
		for (Consulta man : lista) {
			
			Object[] row = { man.getCodMatricula(), man.getCodEstado(), man.getNomEstado(), man.getCodAlum(),
					man.getNomAlum(), man.getCodCiclo(), man.getFechaDeIngreso() };
			
			model.addRow(row);
		}
	}
	void mensaje1(String mensaje, String titulo, int tipoMensaje){
		JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
	}
}
