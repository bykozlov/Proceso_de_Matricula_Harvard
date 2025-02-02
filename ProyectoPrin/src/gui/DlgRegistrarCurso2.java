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

import utils.Libreria;

import componente.JComboBoxBD1;
import controlador.MySqlCursoDAO;
import entidad.Curso;
import interfaces.CursoDAO;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class DlgRegistrarCurso2 extends JDialog implements ActionListener, MouseListener, KeyListener {
	
	private MySqlCursoDAO cursoDAO = new MySqlCursoDAO();
	ResourceBundle rb = ResourceBundle.getBundle("SENTENCIAS_SQL");
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtHoras;
	private JTextField txtCreditos;
	private JLabel lblNewLabel_4;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblCurso;
	private JScrollPane scrollPane;
	private JComboBox cboCiclo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistrarCurso2 dialog = new DlgRegistrarCurso2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistrarCurso2() {
		getContentPane().setBackground(new Color(255, 102, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgRegistrarCurso2.class.getResource("/img/Curso.png")));
		setTitle("Registrar Curso");
		setBounds(100, 100, 692, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 14, 64, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Asignatura");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 45, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Horas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 76, 64, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ciclo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(166, 14, 44, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(84, 11, 72, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.addKeyListener(this);
		txtAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsignatura.setBounds(84, 42, 212, 20);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(this);
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHoras.setBounds(84, 73, 72, 20);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		txtCreditos = new JTextField();
		txtCreditos.addKeyListener(this);
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCreditos.setBounds(220, 73, 76, 20);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Cr\u00E9ditos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(166, 76, 44, 14);
		getContentPane().add(lblNewLabel_4);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgRegistrarCurso2.class.getResource("/img/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.setBounds(520, 5, 146, 23);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgRegistrarCurso2.class.getResource("/img/editar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(520, 45, 146, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgRegistrarCurso2.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBounds(520, 92, 146, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 656, 219);
		getContentPane().add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.addMouseListener(this);
		tblCurso.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO DE CURSO", "ASIGNATURA", "CICLO", "CR\u00C9DITOS", "HORAS"
			}
		));
		scrollPane.setViewportView(tblCurso);
		
		cboCiclo = new JComboBoxBD1(rb.getString("sql_ciclo"));
		cboCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCiclo.setBounds(220, 10, 76, 22);
		getContentPane().add(cboCiclo);
		cantidadCursos();
		listado();
	}
	public void actionPerformed(ActionEvent e) {
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
	
	///metodos 
	int getCodCurso() {
		return Integer.parseInt(txtCodigo.getText());
	}
	String getAsignatura() {
		return txtAsignatura.getText();
	}
	int getCreditos() {
		return Integer.parseInt(txtCreditos.getText());
	}
	int getHoras() {
		return Integer.parseInt(txtHoras.getText());
	}
	int getCiclo() {
		return cboCiclo.getSelectedIndex()+1;
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int cod;
		String asignatura, credi, horas;
		asignatura = txtAsignatura.getText();
		credi = txtCreditos.getText();
		horas = txtHoras.getText();
		
		
		if(asignatura.trim().equals("")) {
			mensaje("Campo Asignatura es obligatorio");
			txtAsignatura.requestFocus();
		}
		else if(asignatura.matches("[a-z A-Z\\\\�\\\\�\\\\s\\\\�\\\\�\\\\�\\\\�\\\\�\\\\�\\\\�\\\\�\\\\�\\\\�]{3,50}")==false) {
			mensaje("Campo Asignatura MIN: 3 - MAX:50 car�cteres");
			txtAsignatura.requestFocus();
		}
		
		else if(credi.trim().equals("")){
			mensaje("Campo creditos es obligatorio");
			txtCreditos.requestFocus();
		}
		else if(credi.matches("\\d{1}")==false){
			mensaje("Capo creditos debe debe tener 1 digito");
			txtCreditos.requestFocus();
		 }
		
		else if(horas.trim().equals("")){
			mensaje("Campo horas es obligatorio");
			txtHoras.requestFocus();
		}
		else if(horas.matches("\\d{1}")==false){
			mensaje("Capo horas debe debe tener 1 digito");
			txtHoras.requestFocus();
		 
		} else {
			
		
			Curso crso = new Curso();
			
			crso.setAsignatura(getAsignatura());
			crso.setCredi(getCreditos());
			crso.setHoras(getHoras());
			crso.setCiclo(getCiclo());
			int resultado;
			resultado = cursoDAO.save(crso);
			if (resultado  == 1) {
				mensaje("Curso Registrado");
				listado();
				limpiar();
			}else
				mensaje("Error en el registro");
		}

	}
	
	
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int ciclo;
		String codigo, asignatura, credi, horas;
		
		codigo = txtCodigo.getText();
		asignatura = txtAsignatura.getText();
		credi = txtCreditos.getText();
		horas = txtHoras.getText();
		
		if(asignatura.trim().equals("")) {
			mensaje("Campo Asignatura es obligatorio");
			txtAsignatura.requestFocus();
		}
		else if(asignatura.matches("[a-z A-Z\\�\\�\\s\\�\\�\\�\\�\\�\\�\\�\\�\\�\\�]{3,50}")==false) {
			mensaje("Campo Asignatura MIN: 3 - MAX:50 car�cteres");
			txtAsignatura.requestFocus();
		}
		
		else if(credi.trim().equals("")){
			mensaje("Campo creditos es obligatorio");
			txtCreditos.requestFocus();
		}
		else if(credi.matches("\\d{1}")==false){
			mensaje("Capo creditos debe debe tener 1 digito");
			txtCreditos.requestFocus();
		 }
		
		else if(horas.trim().equals("")){
			mensaje("Campo horas es obligatorio");
			txtHoras.requestFocus();
		}
		else if(horas.matches("\\d{1}")==false){
			mensaje("Capo horas debe debe tener 1 digito");
			txtHoras.requestFocus();
		 
		} else {

			Curso crso = new Curso();
			crso.setCodCurso(getCodCurso());
			crso.setAsignatura(getAsignatura());
			crso.setCredi(getCreditos());
			crso.setHoras(getHoras());
			crso.setCiclo(getCiclo());
			int resultado;
			resultado = cursoDAO.update(crso);
			if (resultado >0) {
				mensaje("Curso Actualizado");
				listado();
				limpiar();
				btnAdicionar.setEnabled(true);
				btnModificar.setEnabled(false);
			}else
				mensaje("Error en el registro");
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int boton;
		boton=JOptionPane.showConfirmDialog(null, "Seguro de eliminar Curso con C�DIGO : "+getCodCurso(),
											"Sistema",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(boton==0) {
			int salida;
			salida=cursoDAO.deleteById(getCodCurso());
			if(salida>0) {
				mensaje("Curso Eliminado");
				listado();
				limpiar();
			}
			else
				mensaje("Error en la eliminaci�n");
		}
		
	}
	void limpiar() {
		txtAsignatura.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		txtCodigo.setText("");
	}
	//metodo pa ver el codigo
	private void cantidadCursos() {
        int id = cursoDAO.getLastICurso();
        id++;
        txtCodigo.setText("" + id);
    }
	//validacion de numeros y letras
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
	
	void mensaje1(String mensaje, String titulo, int tipoMensaje){
		JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
	}
	void mostrarDatos() {
		int posFila;
		String cod;
		posFila = tblCurso.getSelectedRow();
		
		cod = tblCurso.getValueAt(posFila, 0).toString();
		
		Curso bean = cursoDAO.findById(Integer.parseInt(cod));
		
		txtCodigo.setText(cod);
		txtAsignatura.setText(bean.getAsignatura()+"");
		txtCreditos.setText(bean.getCredi() +"");
		txtHoras.setText(bean.getHoras()+"");
		cboCiclo.setSelectedItem(bean.getNom_ciclo()+"");
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	
	void listado() {
		DefaultTableModel model = (DefaultTableModel) tblCurso.getModel();
		model.setRowCount(0);
		ArrayList<Curso> data = cursoDAO.findAll();
		for(Curso curso:data) {
			Object row[] = {curso.getCodCurso(),curso.getAsignatura(),curso.getNom_ciclo(), curso.getCredi()
					, curso.getHoras()};
			model.addRow(row);
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCurso) {
			mouseClickedTblCurso(e);
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
	protected void mouseClickedTblCurso(MouseEvent e) {
		mostrarDatos();
		
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCreditos) {
			keyTypedTxtCreditos(e);
		}
		if (e.getSource() == txtHoras) {
			keyTypedTxtHoras(e);
		}
		if (e.getSource() == txtAsignatura) {
			keyTypedTxtAsignatura(e);
		}
	}
	protected void keyTypedTxtAsignatura(KeyEvent e) {
		Bloquear_Numeros(e);
	}
	protected void keyTypedTxtHoras(KeyEvent e) {
		Bloquear_Letras(e);
	}
	protected void keyTypedTxtCreditos(KeyEvent e) {
		Bloquear_Letras(e);
	}
}
