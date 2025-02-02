package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componente.JComboBoxBD1;
import controlador.MySqlRegistroDAO;
import entidad.Cifrador;
import entidad.RegistrarUsuario;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

public class frmRegistrar extends JFrame implements ActionListener {
	ResourceBundle rb = ResourceBundle.getBundle("SENTENCIAS_SQL");
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_6;
	private JButton btnRegistrar;
	private JPasswordField txtClave;
	private JPasswordField txtConClave;
	private JComboBox cboTipos;
	private JComboBox cboTipos1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistrar frame = new frmRegistrar();
					frame.setLocationRelativeTo(null);
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
	public frmRegistrar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FrmLogin.frmReg = null;
			}
		});
		setTitle("Registrar");
		setBounds(100, 100, 440, 474);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(229, 119, 94, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Clave");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/contrasenas (1).png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(82, 155, 76, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar clave ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/contrasenas (1).png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(82, 192, 145, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/Nombre.png")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(82, 234, 76, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/Nombre.png")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(82, 270, 86, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/Correo.png")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(82, 311, 76, 24);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(229, 234, 94, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(229, 276, 94, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(229, 314, 94, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/Usuario.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(82, 113, 94, 31);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_6 = new JLabel("Registrate");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setToolTipText("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(151, 11, 94, 32);
		contentPane.add(lblNewLabel_6);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/Registrar1.png")));
		btnRegistrar.setBounds(131, 375, 129, 33);
		contentPane.add(btnRegistrar);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(229, 150, 94, 20);
		contentPane.add(txtClave);
		
		txtConClave = new JPasswordField();
		txtConClave.setBounds(229, 192, 94, 20);
		contentPane.add(txtConClave);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Tipo de Usuario");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setIcon(new ImageIcon(frmRegistrar.class.getResource("/img/people.png")));
		lblNewLabel_7.setBounds(82, 82, 129, 20);
		contentPane.add(lblNewLabel_7);
		
		cboTipos1 = new JComboBoxBD1(rb.getString("sql_tipousu"));
		cboTipos1.setBounds(229, 83, 94, 21);
		contentPane.add(cboTipos1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		MySqlRegistroDAO modsql = new MySqlRegistroDAO();
		RegistrarUsuario mod = new RegistrarUsuario();

		String clave = new String(txtClave.getPassword());
		String conClave = new String(txtConClave.getPassword());
		int cb;
		//
		cb=cboTipos1.getSelectedIndex()+1;


		// valdiacion de campos
		if (txtUsuario.getText().equals("") || txtClave.equals("") || txtConClave.equals("") || txtNombre.getText().equals("")
				|| txtApellido.getText().equals("") || txtCorreo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Hay campos vacios, debe lenar todos los campos");
		} else {

			if (clave.equals(conClave)) {
				if (modsql.existeUsuario(txtUsuario.getText()) == 0) {
					if (modsql.Email(txtCorreo.getText())) {
						String nuevaCla = Cifrador.sha1(clave);
						mod.setTipo_usuario(cb);
						mod.setUsuario(txtUsuario.getText());
						mod.setClave(nuevaCla);
						mod.setNom(txtNombre.getText());
						mod.setApe(txtApellido.getText());
						mod.setCorreo(txtCorreo.getText());
						mod.getTipo_usuario();

						if (modsql.registrarUsuario(mod)) {
							JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");
							FrmLogin.frmReg = null;
						
							dispose();
							limpiar();
						} else {
							JOptionPane.showConfirmDialog(null, "ERROR AL GUARDAR");
						}
					} else {
						JOptionPane.showConfirmDialog(null, "EL correo electronico no es valido");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "El usuario ya existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "LAS CONTRASEŅAS NO COINCIDEN");
			}
		}
	}
	
	private void limpiar() {
		txtUsuario.setText("");
		txtClave.setText("");
		txtConClave.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtCorreo.setText("");
		
	}
}