package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.MySqlRegistroDAO;
import entidad.Cifrador;
import entidad.RegistrarUsuario;

import java.awt.event.MouseAdapter;

public class FrmLogin extends JFrame implements MouseListener, FocusListener {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JMenu mnNewMenu_1;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JPanel pnlBtnIngresar;
	private JLabel lblIngresar;
	private JLabel lblX;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel pnlRegistrar;
	private JLabel lblRegistrar;
	private JLabel lblTienesCuenta;
	private JLabel lblMensaje;
	public JLabel lblPRol;
	
	public static frmRegistrar frmReg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setUndecorated(true);
		setLocationRelativeTo(null);
		setTitle("Login");
		setBounds(100, 100, 640, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(194, 171, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.addFocusListener(this);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(10, 11, 176, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/users.png")));
		lblNewLabel_1.setBounds(218, 0, 32, 40);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(194, 222, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.addFocusListener(this);
		txtContrasenia.setBorder(null);
		txtContrasenia.setEchoChar((char)0);
		txtContrasenia.setBounds(10, 11, 177, 18);
		panel_1.add(txtContrasenia);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/contrasenas (1).png")));
		lblNewLabel_2.setBounds(218, 13, 32, 16);
		panel_1.add(lblNewLabel_2);
		
		pnlBtnIngresar = new JPanel();
		pnlBtnIngresar.addMouseListener(this);
		pnlBtnIngresar.setBackground(Color.LIGHT_GRAY);
		pnlBtnIngresar.setForeground(Color.BLACK);
		pnlBtnIngresar.setBounds(194, 295, 250, 40);
		contentPane.add(pnlBtnIngresar);
		pnlBtnIngresar.setLayout(null);
		
		lblIngresar = new JLabel("Ingresar");
		lblIngresar.setForeground(Color.BLACK);
		lblIngresar.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblIngresar.setBounds(98, 11, 52, 18);
		pnlBtnIngresar.add(lblIngresar);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.addMouseListener(this);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblX.setBounds(606, 11, 24, 17);
		contentPane.add(lblX);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/conocimiento.png")));
		lblNewLabel.setBounds(264, 11, 136, 155);
		contentPane.add(lblNewLabel);
		
		pnlRegistrar = new JPanel();
		pnlRegistrar.addMouseListener(new MouseAdapter() {
			/**
			 *
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(frmReg == null) {
					 frmReg = new frmRegistrar();
					 frmReg.setVisible(true);
				 }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlRegistrar.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlRegistrar.setBackground(Color.LIGHT_GRAY);
			}
		});
		pnlRegistrar.setLayout(null);
		pnlRegistrar.setForeground(Color.BLACK);
		pnlRegistrar.setBackground(Color.LIGHT_GRAY);
		pnlRegistrar.setBounds(194, 365, 250, 40);
		contentPane.add(pnlRegistrar);
		
		lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setForeground(Color.BLACK);
		lblRegistrar.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblRegistrar.setBounds(93, 11, 65, 18);
		pnlRegistrar.add(lblRegistrar);
		
		lblTienesCuenta = new JLabel("\u00BFTienes cuenta?");
		lblTienesCuenta.setForeground(Color.WHITE);
		lblTienesCuenta.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblTienesCuenta.setBounds(263, 340, 122, 14);
		contentPane.add(lblTienesCuenta);
		
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblMensaje.setBounds(204, 273, 240, 14);
		contentPane.add(lblMensaje);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == pnlBtnIngresar) {
			mouseClickedPnlBtnIngresar(arg0);
		}
		if (arg0.getSource() == lblX) {
			mouseClickedLblX(arg0);
			
		}

	}
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource()==lblX){
			mouseEnteredLblX(arg0);
		}
		if(arg0.getSource()==pnlBtnIngresar){
			mouseEnteredPnlBtnIngresar(arg0);
		}
	}

	public void  mouseExited(MouseEvent arg0) {
		if(arg0.getSource()==lblX){
			 mouseExitedLblX(arg0);
		}
		if(arg0.getSource()==pnlBtnIngresar){
			mouseExitePnlBtnIngresar(arg0);
		}
	}
	protected void mouseEnteredLblX(MouseEvent arg0) {
		//cambiar el color cuando el maus esta encima
		lblX.setForeground(Color.RED);
		
	}

	protected void mouseExitedLblX(MouseEvent arg0) {
		lblX.setForeground(Color.WHITE);
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedLblX(MouseEvent arg0) {
		// agregamos un mensaje en el X txt
		if(JOptionPane.showConfirmDialog(null, "Estas seguro de cerrar login?","Confirmacion", JOptionPane.YES_NO_OPTION)==0){
			//cerramos el login
			FrmLogin.this.dispose();
		}
		
	}
	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == txtContrasenia) {
			focusGainedTxtContrasenia(arg0);
		}
		if (arg0.getSource() == txtUsuario) {
			focusGainedTxtUsuario(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {
		if(txtUsuario.getText().equals("")){
			txtUsuario.setText("Usuario");
			}
		else if(txtContrasenia.getText().equals("")){
			txtContrasenia.setText("Contrase�a");
			txtContrasenia.setEchoChar((char)0);
		}
	}
	protected void focusGainedTxtUsuario(FocusEvent arg0) {
		if(txtUsuario.getText().equals("Usuario")){
			txtUsuario.setText("");
		}
		else{
			txtUsuario.selectAll();
		}
	}
	protected void focusGainedTxtContrasenia(FocusEvent arg0) {
		if(txtContrasenia.getText().equals("Contrase�a")){
		txtContrasenia.setEchoChar('*');
		txtContrasenia.setText("");
		}
		else{
			txtContrasenia.selectAll();
			
		}
	}
	protected void mouseClickedPnlBtnIngresar(MouseEvent arg0) {
		if(txtUsuario.getText().equals("")|| txtUsuario.getText().equals("Usuario")||
				txtContrasenia.getText().equals("")||txtContrasenia.getText().equals("Contrase�a")){
			lblMensaje.setText("Ingresar todos los requirimientos");
		}
		else{
			 
				
				MySqlRegistroDAO modsql = new MySqlRegistroDAO();
				RegistrarUsuario mod= new RegistrarUsuario();
				Date date = new Date();
				DateFormat fechaHora = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
				String pass = new String(txtContrasenia.getPassword());
				
				if(!txtUsuario.getText().equals("") && !pass.equals("")) {
					String nuevoPass = Cifrador.sha1(pass);
					
					mod.setUsuario(txtUsuario.getText());
					mod.setClave(nuevoPass);
					mod.setFechaDeIngreso(fechaHora.format(date));
					
					if(modsql.login(mod)) {
						
						FrmPrincipal frm = new FrmPrincipal();
						frm.lblPRol.setText("Bienvenido(a): "+mod.getNom()+" "+mod.getApe());
						frm.setVisible(true);
						this.dispose();
					}else {
						lblMensaje.setText("Usuario y contrase�a incorrectos");
					}
				}else {
					JOptionPane.showMessageDialog(null, "DEBE INGRESAR SUS DATOS");
				}
			
		}
		
	}
	protected void mouseEnteredPnlBtnIngresar(MouseEvent arg0) {
		pnlBtnIngresar.setBackground(Color.gray);
	}
	protected void mouseExitePnlBtnIngresar(MouseEvent arg0) {
		pnlBtnIngresar.setBackground(Color.LIGHT_GRAY);
	}
}