package Codigo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MisCuestionarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisCuestionarios frame = new MisCuestionarios();
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
	public MisCuestionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
	}
}
