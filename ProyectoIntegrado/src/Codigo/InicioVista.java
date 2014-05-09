package Codigo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class InicioVista extends JFrame {

	private JPanel contentPane;
	JButton btn_crear_off = new JButton("New button");
	JButton btn_crear_on = new JButton("New Button");
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioVista frame = new InicioVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setGraphics () {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public InicioVista() {
		setGraphics ();
		
		//Ventana principal.
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btn_crear_off.setBorderPainted(false);
		
		//Boton crear Cuestionario OFF		
		btn_crear_off.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btn_crear_on.setVisible(true);
				//btn_crear_off.setVisible(false);
			}
			public void mouseExited(MouseEvent e) {
				btn_crear_on.setVisible(false);
				//btn_crear_off.setVisible(true);
			}
		});
		btn_crear_off.setFocusPainted(false);
		btn_crear_off.setContentAreaFilled(false);
		btn_crear_off.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_crearC_off.png")));
		contentPane.add(btn_crear_off);
		btn_crear_off.setBounds(490, 188, 202, 30);
		btn_crear_on.setBorderPainted(false);
		
		//Boton crear Cuestionario ON.
		btn_crear_on.setFocusable(false);
		btn_crear_on.setContentAreaFilled(false);
		btn_crear_on.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_crearC_on.png")));
		contentPane.add(btn_crear_on);
		btn_crear_on.setBounds(490, 188, 202, 30);
		btn_crear_on.setVisible(false);
		
		//Imagen de la libreta.
		JLabel libreta = new JLabel("");
		libreta.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/libreta_fondo.png")));
		libreta.setBounds(0, 11, 784, 550);
		contentPane.add(libreta);
		
		//Imagen de fondo de la ventana principal.
		JLabel fondo_aplicacion = new JLabel("");
		fondo_aplicacion.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/fondo_aplicacion.jpg")));
		fondo_aplicacion.setBounds(0, 0, 794, 572);
		contentPane.add(fondo_aplicacion);
		
		//this.setUndecorated(true);
	}
}
