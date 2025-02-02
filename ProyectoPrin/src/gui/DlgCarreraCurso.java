package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import componente.JComboBoxBD1;
import componente.JComboBoxBD2;
import controlador.MySqlCarreraDAO;
import entidad.Carrera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DlgCarreraCurso extends JFrame implements ActionListener {
	private MySqlCarreraDAO CarreraDao = new MySqlCarreraDAO();
	ResourceBundle p = ResourceBundle.getBundle("SENTENCIAS_SQL");
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboCarrera;
	private JComboBox cboCurso;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCod;
	private JTable tbCarrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCarreraCurso frame = new DlgCarreraCurso();
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
	public DlgCarreraCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 469);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Carrera:");
		lblNewLabel.setBounds(13, 57, 72, 22);
		contentPane.add(lblNewLabel);

		cboCarrera = new JComboBoxBD1(p.getString("sql_carrera"));
		cboCarrera.setBounds(96, 57, 193, 22);
		contentPane.add(cboCarrera);

		cboCurso = new JComboBoxBD1(p.getString("sql_curso"));
		cboCurso.setBounds(258, 10, 141, 22);
		contentPane.add(cboCurso);

		btnNewButton = new JButton("A\u00F1adir Curso a la Carrera");
		btnNewButton.setIcon(new ImageIcon(DlgCarreraCurso.class.getResource("/img/anadir.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(435, 10, 214, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Eliminar Curso de Carrera");
		btnNewButton_1.setIcon(new ImageIcon(DlgCarreraCurso.class.getResource("/img/eliminar.png")));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(435, 57, 214, 22);
		contentPane.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 639, 329);
		contentPane.add(scrollPane);

		tbCarrera = new JTable();
		tbCarrera.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod. Registro", "Carrera", "Curso"
			}
		));
		scrollPane.setViewportView(tbCarrera);

		lblNewLabel_1 = new JLabel("Curso:");
		lblNewLabel_1.setBounds(216, 14, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Cod. Registro:");
		lblNewLabel_2.setBounds(10, 14, 75, 14);
		contentPane.add(lblNewLabel_2);

		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(100, 11, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		cantidadCursos();
		listado();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	int getCarrera() {
		return cboCarrera.getSelectedIndex()+1;
	}
	int getCurso() {
		return cboCurso.getSelectedIndex()+1;
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		

		///
		Carrera car = new Carrera();
		car.setCodCarrera(getCarrera());
		car.setCodCurso(getCurso());
		int resultado;
		resultado = CarreraDao.save(car);
		if (resultado == 1) {
			mensaje("Curso Registrado");
			listado();
		}
		else
			mensaje("Error en el registro");

	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		int cod, boton;
		boton = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?", "Sistema", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (boton == 0) {
			cod = Integer.parseInt(txtCod.getText());
			int salida;
			salida = CarreraDao.deleteById(cod);
			if (salida == 1)
				mensaje("Curso Eliminado");
			else
				mensaje("Error en la Eliminacion");
		}
	}

	// metodo para ver el numero que sigue en el txtCod
	private void cantidadCursos() {
		int id = CarreraDao.getLastICurso();
		id++;
		txtCod.setText("" + id);
	}

	void listado() {
		// PASO 1: obtener modelo de la tabla tblLibros
		DefaultTableModel model = (DefaultTableModel) tbCarrera.getModel();
		// PASO 2: limpiar filas del objeto "model"
		model.setRowCount(0);
		// PASO 3: invocar al m�todo findAll
		ArrayList<Carrera> data = CarreraDao.findAll();
		// PASO 4: bucle para realizar recorrido sobre "data"
		for (Carrera car : data) {
			// PASO 5: crear un arreglo de la clase Object con los valores del objeto "lib"
			Object row[] = { car.getCodCarCurso(), car.getNomCarrera(), car.getNomCurso()};
			// PASO 6: adicionar arreglo "row" dentro del objeto "model"
			model.addRow(row);
		}
	}
	

}
