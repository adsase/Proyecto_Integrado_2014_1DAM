package Codigo;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MisCuestionarios extends JFrame {

	private JPanel contentPane;
	JButton btn_volver_off = new JButton("");
	JButton btn_volver_on = new JButton("");

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
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 774, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 554, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		//Boton volver OFF		
		btn_volver_off.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				btn_volver_on.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				btn_volver_on.setVisible(false);
			}
		});
		btn_volver_off.setFocusPainted(false);
		btn_volver_off.setContentAreaFilled(false);
		btn_volver_off.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_crearC_off.png")));
		contentPane.add(btn_volver_off);
		btn_volver_off.setBounds(490, 188, 202, 30);
		btn_volver_on.setBorderPainted(false);
		
		//Boton volver ON.
		btn_volver_on.setFocusable(false);
		btn_volver_on.setContentAreaFilled(false);
		btn_volver_on.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/btn_crearC_on.png")));
		contentPane.add(btn_volver_on);
		btn_volver_on.setBounds(490, 188, 202, 30);
		btn_volver_on.setVisible(false);
		btn_volver_off.setBorderPainted(false);
		
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
