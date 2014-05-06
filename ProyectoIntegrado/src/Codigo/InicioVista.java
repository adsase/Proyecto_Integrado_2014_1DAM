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
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class InicioVista extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public InicioVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearTest = new JButton("Crear Test");
		btnCrearTest.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCrearTest.setBounds(306, 309, 171, 43);
		contentPane.add(btnCrearTest);
		
		JButton btnMisTest = new JButton("Mis Test");
		btnMisTest.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnMisTest.setBounds(306, 377, 171, 43);
		contentPane.add(btnMisTest);
		
		JButton btnDemoTest = new JButton("Demo Test");
		btnDemoTest.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDemoTest.setBounds(306, 444, 171, 43);
		contentPane.add(btnDemoTest);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InicioVista.class.getResource("/Imagenes/fondo_aplicacion.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 562);
		contentPane.add(lblNewLabel);
	}
}
