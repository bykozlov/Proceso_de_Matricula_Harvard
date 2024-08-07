package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import componente.JComboBoxBD;
import controlador.MySqlConsultasDAO;

import entidad.Consulta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;


public class DlgConsultaNotas extends JFrame implements ActionListener {
	private MySqlConsultasDAO consulta = new MySqlConsultasDAO();
	ResourceBundle p = ResourceBundle.getBundle("SENTENCIAS_SQL");
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodAlumn;
	private JComboBox cboAsignatura;
	private JButton btnNotas;
	private JScrollPane scrollPane;
	private JTable tbConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsultaNotas frame = new DlgConsultaNotas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DlgConsultaNotas() {
		setTitle("CONSULTA DE NOTAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cod. Alumno");
		lblNewLabel.setBounds(23, 26, 74, 14);
		contentPane.add(lblNewLabel);
		
		txtCodAlumn = new JTextField();
		txtCodAlumn.setBounds(107, 23, 96, 20);
		contentPane.add(txtCodAlumn);
		txtCodAlumn.setColumns(10);
		
		cboAsignatura = new JComboBoxBD(p.getString("sql_curso"), 2,"TODOS");
		cboAsignatura.setBounds(225, 23, 127, 20);
		contentPane.add(cboAsignatura);
		
		btnNotas = new JButton("Mostrar Notas");
		btnNotas.setIcon(new ImageIcon(DlgConsultaNotas.class.getResource("/img/mostrar.png")));
		btnNotas.addActionListener(this);
		btnNotas.setBounds(384, 22, 140, 23);
		contentPane.add(btnNotas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 525, 373);
		contentPane.add(scrollPane);
		
		tbConsulta = new JTable();
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Cod. Alumno", "Nombre", "Curso", "Nota 1", "Nota 2", "Nota 3", "Nota 4"
			}
		));
		scrollPane.setViewportView(tbConsulta);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNotas) {
			actionPerformedBtnNotas(e);
		}
	}
	protected void actionPerformedBtnNotas(ActionEvent e) {
		listado();
	}
	void listado() {
		ArrayList<Consulta> lista = consulta.findAllCurso(cboAsignatura.getSelectedItem().toString(),
				txtCodAlumn.getText());
		
		DefaultTableModel model = (DefaultTableModel)tbConsulta.getModel();
		
		model.setRowCount(0);
		
		for (Consulta man : lista) {
			
			Object[] row = {man.getCodAlum(),man.getNomAlum(),man.getNomCurso(),man.getNota1(),man.getNota2(),man.getNota3(),man.getNota4()};
			
			model.addRow(row);
		}
	}

	void mensaje1(String mensaje, String titulo, int tipoMensaje){
		JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
	}
}
