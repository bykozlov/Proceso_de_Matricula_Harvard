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

import controlador.MySqlSolicitante;
import entidad.Solicitante;
import interfaces.SolicitanteDAO;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DlgRegistrarSolicitante extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JLabel lblNewLabel_4;
	private JTextField txtEdad;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3;
	private JTextField txtEmail;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JTable tblSolicitante;
	private JScrollPane scrollPane;
	private JTextField txtCelular;
	private JLabel lblNewLabel_6;
	private JTextField txtSexo;
	private MySqlSolicitante SolicitanteDAO = new MySqlSolicitante();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistrarSolicitante dialog = new DlgRegistrarSolicitante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistrarSolicitante() {
		getContentPane().setBackground(new Color(255, 102, 102));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DlgRegistrarSolicitante.class.getResource("/img/Solicitante.png")));
		setTitle("Registrar Solicitante");
		setBounds(100, 100, 784, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 14, 64, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 45, 64, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 76, 64, 14);
		getContentPane().add(lblNewLabel_2);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDni.setBounds(84, 11, 64, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombres.setBounds(84, 42, 180, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellidos.setBounds(84, 73, 180, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(158, 14, 32, 14);
		getContentPane().add(lblNewLabel_4);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEdad.setBounds(200, 11, 64, 20);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);

		lblNewLabel_5 = new JLabel("Celular");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(274, 14, 64, 14);
		getContentPane().add(lblNewLabel_5);

		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 107, 64, 14);
		getContentPane().add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(84, 104, 180, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgRegistrarSolicitante.class.getResource("/img/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.setBounds(612, 10, 146, 23);
		getContentPane().add(btnAdicionar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgRegistrarSolicitante.class.getResource("/img/eliminar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(612, 41, 146, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 748, 219);
		getContentPane().add(scrollPane);

		tblSolicitante = new JTable();
		tblSolicitante.setModel(new DefaultTableModel(new Object[][] { { "", null, null, null, null, null, null }, },
				new String[] { "DNI", "NOMBRES", "APELLIDOS", "EMAIL", "SEXO", "EDAD", "CELULAR" }));
		scrollPane.setViewportView(tblSolicitante);

		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBounds(330, 11, 72, 20);
		getContentPane().add(txtCelular);

		lblNewLabel_6 = new JLabel("Sexo");
		lblNewLabel_6.setBounds(274, 46, 46, 14);
		getContentPane().add(lblNewLabel_6);

		txtSexo = new JTextField();
		txtSexo.setBounds(330, 43, 72, 20);
		getContentPane().add(txtSexo);
		txtSexo.setColumns(10);
		listado();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		MySqlSolicitante modsql = new MySqlSolicitante();

		String nombre, apellido, edad, dni, celular, sexo, email;

		/* LEER CAJAS */
		nombre = txtNombres.getText();
		apellido = txtApellidos.getText();
		dni = txtDni.getText();
		edad = txtEdad.getText();
		celular = txtCelular.getText();
		email = txtEmail.getText();
		sexo = txtSexo.getText();

		if (nombre.trim().equals("")) {
			mensaje("Campo nombre es obligatorio");
			txtNombres.requestFocus();
		} else if (nombre.matches(".{5,50}") == false) {
			mensaje("Campo nombre MIN: 5 - MAX:50 carácteres");
			txtNombres.requestFocus();
		} else if (apellido.trim().equals("")) {
			mensaje("Campo apellido es obligatorio");
			txtApellidos.requestFocus();
		} else if (apellido.matches(".{5,50}") == false) {
			mensaje("Campo apellido MIN: 5 - MAX:50 carácteres");
			txtApellidos.requestFocus();
		} else if (dni.trim().equals("")) {
			mensaje("Campo dni es obligatorio");
			txtDni.requestFocus();
		} else if (dni.matches("\\d{8}") == false) {
			mensaje("Campo dni Debe tener 8 digitos");
			txtDni.requestFocus();
		} else if (email.trim().equals("")) {
			mensaje("Campo Email es obligatorio");
			txtEmail.requestFocus();
		}

		else if (edad.trim().equals("")) {
			mensaje("Campo edad es obligatorio");
			txtEdad.requestFocus();
		} else if (edad.matches("\\d{2}") == false) {
			mensaje("El Alumno debe ser  Mayor de Edad");
			txtEdad.requestFocus();
		}

		// falta codigo de que no se repita
		else if (celular.trim().equals("")) {
			mensaje("Campo celular es obligatorio");
			txtCelular.requestFocus();
		} else if (celular.matches("\\d{9}") == false) {
			mensaje("Celular debe tener 9 digitos");
			txtCelular.requestFocus();
		} else if (celular.matches("[9]\\d{8}") == false) {
			mensaje("Debes comenzar con 9");
			txtCelular.requestFocus();
		} else if (sexo.trim().equals("")) {
			mensaje("Campo Sexo es obligatorio");
			txtSexo.requestFocus();
		} else if (sexo.matches("[MF]") == false) {
			mensaje("Agregar si eres M:Masculino o F:Femenino");
			txtSexo.requestFocus();
		}

		if (modsql.existedni(txtDni.getText()) == 0) {
			if (modsql.existetele(txtCelular.getText()) == 0) {
				if (modsql.Email(txtEmail.getText())) {
					Solicitante so = new Solicitante();

					so.setDni(Integer.parseInt(dni));
					so.setNombre(nombre);
					so.setApellido(apellido);
					so.setEmail(email);
					so.setEdad(Integer.parseInt(edad));
					so.setCelular(Integer.parseInt(celular));
					so.setSexo(sexo);
					int resultado;
					resultado = SolicitanteDAO.save(so);

					if (resultado == 1) {
						mensaje("Solicitante Registrado");
						listado();
						borrarCampos();
					} else
						mensaje("Error en el Registro");
				} else {
					mensaje("EL correo electronico no es valido");
				}
			} else {
				mensaje("El telefoto ya existe, ponga otro");
			}
		} else {
			mensaje("Dni ya existe, coloque otro");
		}

	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}

	void borrarCampos() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtEmail.setText("");
		txtCelular.setText("");
		txtSexo.setText("");
	}

	void listado() {
		DefaultTableModel model = (DefaultTableModel) tblSolicitante.getModel();
		model.setRowCount(0);
		ArrayList<Solicitante> dat = SolicitanteDAO.findAll();

		for (Solicitante lib : dat) {
			Object row[] = { lib.getDni(), lib.getNombre(), lib.getApellido(), lib.getEmail(), lib.getSexo(),
					lib.getEdad(), lib.getCelular() };
			model.addRow(row);
		}
	}

}
