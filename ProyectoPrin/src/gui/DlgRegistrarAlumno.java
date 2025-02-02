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

import controlador.MySQLAlumnoDAO;

import entidad.Alumno;
import interfaces.AlumnoDAO;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.SystemColor;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.ImageIcon;

public class DlgRegistrarAlumno extends JDialog implements ActionListener, MouseListener, KeyListener {
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JLabel lblNewLabel_4;
	private JTextField txtEdad;
	private JLabel lblNewLabel_6;
	private JTextField txtCelular;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblAlumno;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JTextField txtSexo;

	private MySQLAlumnoDAO AlumnoDAO = new MySQLAlumnoDAO();
	private JDateChooser dcFecha;
	private JButton btnLimpiar;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistrarAlumno dialog = new DlgRegistrarAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistrarAlumno() {
		getContentPane().setBackground(new Color(255, 102, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgRegistrarAlumno.class.getResource("/img/Alumno.png")));
		setTitle("Registrar Alumno");
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 14, 64, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 45, 64, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 76, 64, 14);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 106, 64, 14);
		getContentPane().add(lblNewLabel_3);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(84, 11, 114, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDni.setBounds(84, 42, 72, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombres.setBounds(84, 73, 196, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellidos.setBounds(84, 103, 196, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(166, 45, 32, 14);
		getContentPane().add(lblNewLabel_4);

		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEdad.setBounds(208, 42, 72, 20);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);

		lblNewLabel_6 = new JLabel("Celular");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(300, 103, 48, 14);
		getContentPane().add(lblNewLabel_6);

		txtCelular = new JTextField();
		txtCelular.addKeyListener(this);
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCelular.setBounds(358, 100, 88, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgRegistrarAlumno.class.getResource("/img/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.setBounds(628, 10, 146, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgRegistrarAlumno.class.getResource("/img/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(628, 55, 146, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgRegistrarAlumno.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(628, 97, 146, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 764, 219);
		getContentPane().add(scrollPane);

		tblAlumno = new JTable();
		tblAlumno.addMouseListener(this);
		tblAlumno.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00D3DIGO DE ALUMNO", "NOMBRES",
				"APELLIDOS", "DNI", "EDAD", "CELULAR", "SEXO", "FECHA" }));
		tblAlumno.getColumnModel().getColumn(0).setPreferredWidth(112);
		scrollPane.setViewportView(tblAlumno);

		lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(300, 14, 48, 14);
		getContentPane().add(lblNewLabel_5);

		lblNewLabel_7 = new JLabel("Fecha");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(300, 59, 48, 14);
		getContentPane().add(lblNewLabel_7);

		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSexo.setBounds(358, 12, 32, 20);
		getContentPane().add(txtSexo);
		txtSexo.setColumns(10);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(358, 53, 136, 20);
		getContentPane().add(dcFecha);
		//
		dcFecha.setDateFormatString("yyyy-MM-dd");
		
		btnLimpiar = new JButton("Limpiar Campos");
		btnLimpiar.setIcon(new ImageIcon(DlgRegistrarAlumno.class.getResource("/img/limpiar.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBounds(466, 97, 152, 23);
		getContentPane().add(btnLimpiar);
		
		lblNewLabel_8 = new JLabel("F o M");
		lblNewLabel_8.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_8.setBounds(358, 15, 46, 14);
		getContentPane().add(lblNewLabel_8);
		listado();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		MySQLAlumnoDAO modsql = new MySQLAlumnoDAO();

		/* VARIABLES */
		String nombre, apellido, edad, dni, celular, sexo;

		/* LEER CAJAS */
		nombre = txtNombres.getText();
		apellido = txtApellidos.getText();
		dni = txtDni.getText();
		edad = txtEdad.getText();
		celular = txtCelular.getText();
		sexo = txtSexo.getText();
		String fecha = ((JTextField)dcFecha.getDateEditor().getUiComponent()).getText();
		/* VALIDAR */
		if (nombre.trim().equals("")) {
			mensaje("Campo nombre es obligatorio");
			txtNombres.requestFocus();
		} else if (nombre.matches(".{5,50}") == false) {
			mensaje("Campo nombre MIN: 5 - MAX:50 car�cteres");
			txtNombres.requestFocus();
		}

		else if (apellido.trim().equals("")) {
			mensaje("Campo apellido es obligatorio");
			txtApellidos.requestFocus();
		} else if (apellido.matches(".{5,50}") == false) {
			mensaje("Campo apellido MIN: 5 - MAX:50 car�cteres");
			txtApellidos.requestFocus();
		}

		else if (dni.trim().equals("")) {
			mensaje("Campo dni es obligatorio");
			txtDni.requestFocus();
		} else if (dni.matches("\\d{8}") == false) {
			mensaje("Campo dni Debe tener 8 digitos");
			txtDni.requestFocus();
		}

		else if (edad.trim().equals("")) {
			mensaje("Campo edad es obligatorio");
			txtEdad.requestFocus();
		} else if (edad.matches("\\d{2}.{5,50}") == false) {
			mensaje("El Alumno debe ser  Mayor de Edad");
			txtEdad.requestFocus();
		}
		 else if (edad.matches("\\d{2}") == false) {
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
		else if(fecha.trim().equals("")) {
			mensaje("Debes agregar un fecha");
			dcFecha.requestFocus();
		}

		if (modsql.existedni(txtDni.getText()) == 0) {
			if (modsql.existetele(txtCelular.getText()) == 0) {
				Alumno bean = new Alumno();

				bean.setNombre(nombre);
				bean.setApellido(apellido);
				bean.setDni(Integer.parseInt(dni));
				bean.setEdad(Integer.parseInt(edad));
				bean.setCelular(Integer.parseInt(celular));
				bean.setSexo(sexo);
				bean.setFecha(java.sql.Date.valueOf(fecha));
				int resultado;
				resultado = AlumnoDAO.save(bean);

				if (resultado == 1) {
					mensaje("Alumno Registrado");
					listado();
					borrarCampos();
				} else
					mensaje("Error en el Registro");

			} else {
				mensaje("El telefoto ya existe, ponga otro");
			}
		} else {
			mensaje("Dni ya existe, coloque otro");
		}

	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		String nombre, apellido, dni, edad, celular, codigo, sexo;

		codigo = txtCodigo.getText();
		nombre = txtNombres.getText();
		apellido = txtApellidos.getText();
		dni = txtDni.getText();
		edad = txtEdad.getText();
		celular = txtCelular.getText();
		sexo = txtSexo.getText();
		String fecha = ((JTextField)dcFecha.getDateEditor().getUiComponent()).getText();

		// validar
		if (nombre.trim().equals("")) {
			mensaje("Campo nombre es obligatorio");
			txtNombres.requestFocus();
		} else if (nombre.matches(".{5,50}") == false) {
			mensaje("Campo nombre MIN: 5 - MAX:50 car�cteres");
			txtNombres.requestFocus();
		} else if (apellido.trim().equals("")) {
			mensaje("Campo apellido es obligatorio");
			txtApellidos.requestFocus();
		} else if (apellido.matches(".{5,50}") == false) {
			mensaje("Campo apellido MIN: 5 - MAX:50 car�cteres");
			txtApellidos.requestFocus();
		} else if (dni.trim().equals("")) {
			mensaje("Campo dni es obligatorio");
			txtDni.requestFocus();
		} else if (dni.matches("\\d{8}") == false) {
			mensaje("Campo dni Debe tener 8 digitos");
			txtDni.requestFocus();
		} else if (edad.trim().equals("")) {
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
		}
		else if(fecha.trim().equals("")) {
			mensaje("Debes agregar un fecha");
			dcFecha.requestFocus();
		}
		// crear objeto de la clase alumno
		Alumno bean = new Alumno();
		// asignar valor a los atributos del objeto "bean" usando las variables
		bean.setCodAlumno(Integer.parseInt(codigo));
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setEdad(Integer.parseInt(edad));
		bean.setDni(Integer.parseInt(dni));
		bean.setCelular(Integer.parseInt(celular));
		bean.setSexo(sexo);
		bean.setFecha(java.sql.Date.valueOf(fecha));

		// invocar al m�todo save y enviar como par�metro el objeto "bean"
		int resultado;
		resultado = AlumnoDAO.update(bean);
		// validar variable resultado
		if (resultado == 1) {
			mensaje("Alumno actualizado");
			listado();
			borrarCampos();
			btnAdicionar.setEnabled(true);
			btnModificar.setEnabled(false);
		} else
			mensaje("Error al actualizar alumno");
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int cod, boton;
		boton = JOptionPane.showConfirmDialog(null, "Seguro de eliminar al alumno?", "Sistema",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (boton == 0) {
			cod = Integer.parseInt(txtCodigo.getText());
			int salida;
			salida = AlumnoDAO.deleteById(cod);

			if (salida == 1) {
				mensaje("Alumno eliminado");
				listado();
				borrarCampos();
			} else
				mensaje("Error al eliminar alumno");
		}
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}

	void listado() {
		DefaultTableModel model = (DefaultTableModel) tblAlumno.getModel();
		model.setRowCount(0);
		ArrayList<Alumno> data = AlumnoDAO.findAll();

		for (Alumno lib : data) {
			Object row[] = { lib.getCodAlumno(), lib.getNombre(), lib.getApellido(), lib.getDni(), lib.getCelular(),
					lib.getEdad(), lib.getSexo(), lib.getFecha() };
			model.addRow(row);
		}
	}

	void mostrarDatos() {
		int posFila;
		String cod, nombre, apellido, edad, dni, celular, fecha, sexo;
		posFila = tblAlumno.getSelectedRow();

		cod = tblAlumno.getValueAt(posFila, 0).toString();

		Alumno bean = AlumnoDAO.findById(Integer.parseInt(cod));

		txtCodigo.setText(cod);
		txtNombres.setText(bean.getNombre());
		txtApellidos.setText(bean.getApellido());
		txtDni.setText(bean.getDni() + "");
		txtEdad.setText(bean.getEdad() + "");
		txtCelular.setText(String.valueOf(bean.getCelular()));
		dcFecha.setDate(bean.getFecha());
	}

	void borrarCampos() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		txtSexo.setText("");
		dcFecha.setDate(null);
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
		// variable
		int posFila;
		String cod, nom, ape, dni, celular, edad, sexo, fecha;
		// obtener posicion de la fila
		posFila = tblAlumno.getSelectedRow();
		// obtener valores de la fola actual
		cod = tblAlumno.getValueAt(posFila, 0).toString();
		nom = tblAlumno.getValueAt(posFila, 1).toString();
		ape = tblAlumno.getValueAt(posFila, 2).toString();
		dni = tblAlumno.getValueAt(posFila, 3).toString();
		edad = tblAlumno.getValueAt(posFila, 4).toString();
		celular = tblAlumno.getValueAt(posFila, 5).toString();
		sexo = tblAlumno.getValueAt(posFila, 6).toString();
		fecha = tblAlumno.getValueAt(posFila, 7).toString();
		// mostrar en la caja de valor
		txtCodigo.setText(cod);
		txtNombres.setText(nom);
		txtApellidos.setText(ape);
		txtDni.setText(dni);
		txtEdad.setText(edad);
		txtCelular.setText(celular);
		txtSexo.setText(sexo);
		dcFecha.setDate(java.sql.Date.valueOf(fecha));
		
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
	}
	void mensaje1(String mensaje, String titulo, int tipoMensaje){
		JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
	}
	boolean Bloquear_Letras(KeyEvent arg0) {
		char letra = arg0.getKeyChar(); // Obtiene el caracter ingresado
		if (Character.isLetter(letra)) {// Si el caracter tiene n�meros
			getToolkit().beep(); // Emite un sonido
			arg0.consume(); // No se realiza esos datos
			mensaje1("Ingrese solo n�meros", "Sistema", 1); // Mensaje
			return true;
		}else{
			return false;
		}
	}
	
	void Bloquear_Numeros(KeyEvent arg0) {
		char num = arg0.getKeyChar(); // Obtiene el caracter ingresado
		if (Character.isDigit(num)) {// Si el caracter tiene numeros
			getToolkit().beep(); // Emite un sonido
			arg0.consume(); // No se realiza esos datos
			mensaje1("Ingrese solo letras", "Sistema", 1); // Mensaje
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCelular) {
			keyTypedTxtCelular(e);
		}
		if (e.getSource() == txtDni) {
			keyTypedTxtDni(e);
		}
		if (e.getSource() == txtApellidos) {
			keyTypedTxtApellidos(e);
		}
		if (e.getSource() == txtNombres) {
			keyTypedTxtNombres(e);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent e) {
		Bloquear_Numeros(e);
	}
	protected void keyTypedTxtApellidos(KeyEvent e) {
		Bloquear_Numeros(e);
	}
	protected void keyTypedTxtDni(KeyEvent e) {
		Bloquear_Letras(e);
	}
	protected void keyTypedTxtCelular(KeyEvent e) {
		Bloquear_Letras(e);
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		borrarCampos();
	}
}
