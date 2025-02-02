package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.RegistrarUsuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmRegistrarAlumno;
	private JMenuItem mntmRegistrarCurso;
	private JMenuItem mntmAlumnoCurso;
	private JMenuItem mntmConsultaNotas;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmRegistrarSolicitante;
	private JLabel lblNewLabel;
	public JLabel lblPRol;
	private JMenuItem mntmCursoCarrera;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/868px-Harvard_Crimson_logo.svg.png")));
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Archivo.png")));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Salir.png")));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmRegistrarAlumno = new JMenuItem("Registrar alumno");
		mntmRegistrarAlumno.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Alumno.png")));
		mntmRegistrarAlumno.addActionListener(this);
		mnMantenimiento.add(mntmRegistrarAlumno);
		
		mntmRegistrarCurso = new JMenuItem("Registrar curso");
		mntmRegistrarCurso.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Curso.png")));
		mntmRegistrarCurso.addActionListener(this);
		mnMantenimiento.add(mntmRegistrarCurso);
		
		mntmRegistrarSolicitante = new JMenuItem("Registrar solicitante");
		mntmRegistrarSolicitante.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Solicitante.png")));
		mntmRegistrarSolicitante.addActionListener(this);
		mnMantenimiento.add(mntmRegistrarSolicitante);
		
		mnNewMenu_4 = new JMenu("Registro");
		mnNewMenu_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/sitio-web.png")));
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_6 = new JMenuItem("Matr\u00EDcula");
		mntmNewMenuItem_6.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/prueba.png")));
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		mntmCursoCarrera = new JMenuItem("Registar Curso a Carrera");
		mntmCursoCarrera.addActionListener(this);
		mntmCursoCarrera.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/prueba.png")));
		mnNewMenu_4.add(mntmCursoCarrera);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/consulta.png")));
		menuBar.add(mnConsulta);
		
		mntmAlumnoCurso = new JMenuItem("Alumno por Estado");
		mntmAlumnoCurso.addActionListener(this);
		mnConsulta.add(mntmAlumnoCurso);
		
		mntmConsultaNotas = new JMenuItem("Consulta de Notas");
		mntmConsultaNotas.addActionListener(this);
		mnConsulta.add(mntmConsultaNotas);
		
		mnNewMenu_3 = new JMenu("Reporte");
		mnNewMenu_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reporte.png")));
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_5 = new JMenuItem("Reporte general");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/HARVARD.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(0, 23, 584, 308);
		contentPane.add(lblNewLabel);
		
		lblPRol = new JLabel("");
		lblPRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblPRol.setBounds(0, 0, 584, 24);
		contentPane.add(lblPRol);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCursoCarrera) {
			actionPerformedMntmCursoCarreraJMenuItem(e);
		}
		
		
		if (e.getSource() == mntmAlumnoCurso) {
			actionPerformedMntmAlumnoCurso(e);
		}
		if (e.getSource() == mntmNewMenuItem_6) {
			actionPerformedMntmNewMenuItem_6(e);
		}
		if (e.getSource() == mntmRegistrarSolicitante) {
			actionPerformedMntmRegistrarSolicitante(e);
		}
		if (e.getSource() == mntmRegistrarCurso) {
			actionPerformedMntmRegistrarCurso(e);
		}
		if (e.getSource() == mntmRegistrarAlumno) {
			actionPerformedMntmRegistrarAlumno(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
			
		}if (e.getSource() == mntmConsultaNotas) {
			actionPerformedMntmConsultaNotas(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmRegistrarAlumno(ActionEvent e) {
		DlgRegistrarAlumno ra = new DlgRegistrarAlumno();
		ra.setResizable(false);
		ra.setLocationRelativeTo(null);
		ra.setVisible(true);
	}
	protected void actionPerformedMntmRegistrarCurso(ActionEvent e) {
		DlgRegistrarCurso2 rc = new DlgRegistrarCurso2();
		rc.setResizable(false);
		rc.setLocationRelativeTo(null);
		rc.setVisible(true);
	}
	protected void actionPerformedMntmRegistrarSolicitante(ActionEvent e) {
		DlgRegistrarSolicitante rs = new DlgRegistrarSolicitante();
		rs.setResizable(false);
		rs.setLocationRelativeTo(null);
		rs.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_6(ActionEvent e) {
		DlgMatricularAlumno rs = new DlgMatricularAlumno();
		rs.setResizable(false);
		rs.setLocationRelativeTo(null);
		rs.setVisible(true);
	}
	protected void actionPerformedMntmAlumnoCurso(ActionEvent e) {
		DlgConsultarAlumnoCurso rs = new DlgConsultarAlumnoCurso();
		rs.setResizable(false);
		rs.setLocationRelativeTo(null);
		rs.setVisible(true);
	}
	protected void actionPerformedMntmConsultaNotas(ActionEvent e) {
		DlgConsultaNotas rs = new DlgConsultaNotas();
		rs.setResizable(false);
		rs.setLocationRelativeTo(null);
		rs.setVisible(true);
	}
	protected void actionPerformedMntmCursoCarreraJMenuItem(ActionEvent e) {
		DlgCarreraCurso rs = new DlgCarreraCurso();
		rs.setResizable(false);
		rs.setLocationRelativeTo(null);
		rs.setVisible(true);
	}
}
