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
	JButton btn_misC_off = new JButton("New button");
	JButton btn_misC_on = new JButton("New Button");
	JButton btn_demo_off = new JButton("");
	JButton btn_demo_on = new JButton("");
	JButton btn_salir_off = new JButton("");
	JButton btn_salir_on = new JButton("");
	MisCuestionarios misC = new MisCuestionarios();
		

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
			}
			public void mouseExited(MouseEvent e) {
				btn_crear_on.setVisible(false);
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
		btn_misC_off.setBorderPainted(false);
		
		//Boton mis Cuestionarios OFF.
		btn_misC_off.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btn_misC_on.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				btn_misC_on.setVisible(false);

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				misC.setVisible(true);
				dispose();
			}
		});
		btn_misC_off.setFocusPainted(false);
		btn_misC_off.setContentAreaFilled(false);
		btn_misC_off.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_misC_off.png")));
		contentPane.add(btn_misC_off);
		btn_misC_off.setBounds(490, 248, 202, 30);
		btn_misC_on.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				misC.setVisible(true);
				dispose();
			}
		});
		btn_misC_on.setBorderPainted(false);
		
		//Boton mis Cuestionarios ON.
		btn_misC_on.setFocusable(false);
		btn_misC_on.setContentAreaFilled(false);
		btn_misC_on.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_misC_on.png")));
		contentPane.add(btn_misC_on);
		btn_misC_on.setBounds(490, 248, 202, 30);
		btn_misC_on.setVisible(false);		
		btn_demo_off.setBorderPainted(false);
		
		
		//Boton Demo OFF.
		btn_demo_off.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btn_demo_on.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				btn_demo_on.setVisible(false);

			}
		});
		btn_demo_off.setFocusPainted(false);
		btn_demo_off.setContentAreaFilled(false);
		btn_demo_off.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_demo_off.png")));
		contentPane.add(btn_demo_off);
		btn_demo_off.setBounds(485, 310, 202, 30);
		btn_demo_on.setBorderPainted(false);
		
		//Boton Demo ON.
		btn_demo_on.setFocusable(false);
		btn_demo_on.setContentAreaFilled(false);
		btn_demo_on.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_demo_on.png")));
		contentPane.add(btn_demo_on);
		btn_demo_on.setBounds(485, 310, 202, 30);
		btn_demo_on.setVisible(false);
		btn_salir_off.setBorderPainted(false);
		
		//Boton Salir OFF.
		btn_salir_off.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btn_salir_on.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				btn_salir_on.setVisible(false);

			}
		});
		btn_salir_off.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		}); 
		btn_salir_off.setFocusPainted(false);
		btn_salir_off.setContentAreaFilled(false);
		btn_salir_off.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_salir_off.png")));
		contentPane.add(btn_salir_off);
		btn_salir_off.setBounds(485, 370, 202, 30);
		btn_salir_on.setBorderPainted(false);
		
		
		//Boton Salir ON.
		btn_salir_on.setFocusable(false);
		btn_salir_on.setContentAreaFilled(false);
		btn_salir_on.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_salir_on.png")));
		contentPane.add(btn_salir_on);
		btn_salir_on.setBounds(485, 370, 202, 30);
		btn_salir_on.setVisible(false);		

		
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
