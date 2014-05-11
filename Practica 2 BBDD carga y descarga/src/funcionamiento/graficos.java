package funcionamiento;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;


public class graficos extends JFrame {
	
	private URL sound = this.getClass().getResource("../sound/RE1.wav");
	private AudioClip audio = Applet.newAudioClip(sound);
	
	private JFrame FramePrincipal = new JFrame("Main");
	private JFrame LoadImageWindow = new JFrame("Crear Cuestion");
	private JFrame ReadProyectWindow = new JFrame ("Proyecto 1");

	/*
	 * variables de la ventana principal
	 */
	private JPanel contentPane;
	
	
	/*
	 *  variables de la ventana de seleccion de imagenes
	 */
	private JTextField Nom;
	private JPanel contentPane2;
	private JTextField Q1_insert;
	private JTextField Q2_insert;
	
		
	/*
	 * variables de la ventana de leer proyectos 
	 */
	private JPanel contentPane3;
	
	
	/*
	 * variables para el manejo de la Conexion
	 */
	private Connection con;
	private PreparedStatement ps;
	
	
	/*
	 * variables para la consulta de cuestiones del proyecto
	 */
	private int Cuestion = 5;
	private String nombre = null, cuestion_1 = null, cuestion_2 = null;
	private int cod_cuest = 0, cod_prod= 0;
	private byte [] image = null;
	
	/*
	 *  Variables de la ventana para añadir cuestiones al proyecto
	 */
	private JLabel Label_Background = new JLabel("Background here");
	private String ruta = null; 
	private JTextField Q1;
	private JTextField Q2;
	private JTextField id_field;
	
	
	/**
	 * Método principal.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graficos frame = new graficos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Método constructor
	 */
	public graficos() {
	 this.audio.loop();
	
	 this.SystemStyle();
	 this.firstWindow();
	}
	
	
	public void SystemStyle () {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga el driver MySQL de JDBC y abre la conexion
	 */
	public void LoadDriver () {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con= DriverManager.getConnection("jdbc:mysql://localhost/java_to_mysql","root","tonphp");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * ventana principal
	 */
	public void firstWindow(){
		FramePrincipal.setResizable(false);
		FramePrincipal.setMaximumSize(new Dimension(800, 600));
		FramePrincipal.setForeground(Color.LIGHT_GRAY);
		FramePrincipal.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		FramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FramePrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.FramePrincipal.setBounds(100, 100, 680, 349);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.FramePrincipal.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		JButton btnCrearCuestin = new JButton("Crear cuesti\u00F3n");
		btnCrearCuestin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				InsertImageWindow();
			}
		});
		
		
		btnCrearCuestin.setBounds(33, 131, 234, 37);
		this.contentPane.add(btnCrearCuestin);
		
		JButton btnVerProyecto = new JButton("Ver proyecto");
		btnVerProyecto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				readProyectWindow();
			}
		});
		
		btnVerProyecto.setBounds(394, 131, 227, 37);
		this.contentPane.add(btnVerProyecto);
		
		this.FramePrincipal.setVisible(true);
	}
	
	
	
	/**
	 * ventana para insertar cuestiones en la BBDD
	 * cod_cuest, nombre, cuestion_1 cuestion_2 imagen, cod_prod
	 */
	public void InsertImageWindow(){
		
		this.LoadImageWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.LoadImageWindow.setBounds(100, 100, 680, 450);
		this.contentPane2 = new JPanel();
		this.contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.LoadImageWindow.setContentPane(this.contentPane2);
		this.contentPane2.setLayout(null);
		
		Label_Background.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Background.setBounds(167, 180, 175, 37);
		this.contentPane2.add(Label_Background);
		
		JButton Button_set = new JButton("Establecer la imagen");
		Button_set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jf = new JFileChooser();
				jf.setApproveButtonText("Cargar Imagen");
				jf.showOpenDialog(LoadImageWindow);
				
				ruta = jf.getSelectedFile().getPath();
				
				Label_Background.setText(ruta);
			}
		});
		Button_set.setBounds(372, 180, 200, 37);
		this.contentPane2.add(Button_set);
		
		
		this.Q1_insert = new JTextField();
		this.Q1_insert.setEditable(true);
		this.Q1_insert.setBounds(57, 297, 532, 26);
		this.contentPane2.add(this.Q1_insert);
		this.Q1_insert.setColumns(10);
		
		this.Q2_insert = new JTextField();
		this.Q2_insert.setEditable(true);
		this.Q2_insert.setColumns(10);
		this.Q2_insert.setBounds(57, 351, 532, 26);
		this.contentPane2.add(this.Q2_insert);
		
		JLabel lblCuestion = new JLabel("Cuestion 1");
		lblCuestion.setBounds(57, 272, 69, 14);
		this.contentPane2.add(lblCuestion);
		
		JLabel lblCuestion_1 = new JLabel("Cuestion 2");
		lblCuestion_1.setBounds(57, 334, 69, 14);
		this.contentPane2.add(lblCuestion_1);
		
		this.Nom = new JTextField();
		this.Nom.setEditable(true);
		this.Nom.setColumns(10);
		this.Nom.setBounds(57, 61, 532, 26);
		this.contentPane2.add(this.Nom);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(57, 36, 69, 14);
		this.contentPane2.add(lblNombre);
		
		JButton btnNewButton = new JButton("Enviar todo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InsertCuestion(Integer.parseInt(id_field.getText()),ruta, Nom.getText(), Q1_insert.getText(), Q2_insert.getText() );
				LoadImageWindow.dispose();
			}
		});
		btnNewButton.setBounds(515, 11, 124, 39);
		this.contentPane2.add(btnNewButton);
		
		id_field = new JTextField();
		id_field.setBounds(453, 17, 52, 33);
		contentPane2.add(id_field);
		id_field.setColumns(10);
		
		
		this.LoadImageWindow.setVisible(true);
	}


	/**
	 * ventana para leer las cuestiones de un proyecto determinado
	 */
	public void readProyectWindow() {
		
		ReadProyectWindow.setResizable(false);
		
		
		this.ReadProyectWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ReadProyectWindow.setBounds(100, 100, 800, 600);
		this.contentPane3 = new JPanel();
		this.contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.ReadProyectWindow.setContentPane(this.contentPane3);
		this.contentPane3.setLayout(null);
		
		
		JLabel Label_Image = new JLabel("Image");
		Label_Image.setBounds(87, 11, 600, 400);
		contentPane3.add(Label_Image);
		
		Label_Image.setHorizontalAlignment(SwingConstants.CENTER);
		
		//lee todos los datos de la BBDD le pasa el Label a pintar como parametro y repinta el Label
		int cod_cuest = 
		Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el numero de cuestion a cargar","carga de cuestion",1));
		
		this.readProyect(Label_Image,cod_cuest);
		Label_Image.repaint();
		
		
		Q1 = new JTextField();
		Q1.setEditable(false);
		Q1.setBounds(87, 444, 600, 34);
		contentPane3.add(Q1);
		Q1.setColumns(10);
		
		Q2 = new JTextField();
		Q2.setEditable(false);
		Q2.setColumns(10);
		Q2.setBounds(87, 499, 600, 34);
		contentPane3.add(Q2);
		
		
		JLabel Label_Cuestion = new JLabel("Cuesti\u00F3n 1");
		Label_Cuestion.setBounds(87, 426, 122, 17);
		contentPane3.add(Label_Cuestion);
		
		JLabel Label_Cuestion_2 = new JLabel("Cuesti\u00F3n 2");
		Label_Cuestion_2.setBounds(87, 481, 122, 17);
		contentPane3.add(Label_Cuestion_2);
		
		JRadioButton RadioQ1_V = new JRadioButton("Verdadero");
		RadioQ1_V.setBounds(693, 423, 109, 23);
		contentPane3.add(RadioQ1_V);
		
		JRadioButton RadioQ1_F = new JRadioButton("Falso");
		RadioQ1_F.setBounds(693, 450, 109, 23);
		contentPane3.add(RadioQ1_F);
		
		JRadioButton RadioQ2_V = new JRadioButton("Verdadero");
		RadioQ2_V.setBounds(693, 488, 109, 23);
		contentPane3.add(RadioQ2_V);
		
		JRadioButton RadioQ2_F = new JRadioButton("Falso");
		RadioQ2_F.setBounds(693, 514, 109, 23);
		contentPane3.add(RadioQ2_F);
		
		JButton btnSiguiente = new JButton(" Siguiente");
		btnSiguiente.setBounds(693, 544, 89, 23);
		contentPane3.add(btnSiguiente);
		
		// IMAGEN 
		
		this.ReadProyectWindow.setTitle(this.nombre);
		this.Q1.setText(this.cuestion_1);
		this.Q2.setText(this.cuestion_2);
		
		this.ReadProyectWindow.setVisible(true);
	}
	
	
	
	/** ####################							  ######################
	 *  ####################  ORDENAR EN CLASE DIFERENTE  ######################
	 *	####################							  ######################
	 */ 
	
	

/**
* Método para crear almacenar en el proyecto una "Cuestión". Para ello se necesita insertar :
* @param ruta : la ruta de la imagen.
* @param nombre : nombre de la cuestión.
* @param Q1 : pregunta 1.
* @param Q2 : pregunta 2.
*/
 public void InsertCuestion (int cod, String ruta, String nombre, String Q1, String Q2) {
		
		// carga el driver y abre la conexion
		this.LoadDriver(); 

		//Script a ejecutar
		String sql_search = 
				("INSERT INTO cuestionario(cod_cuest, nombre, cuestion_1, cuestion_2, imagen, cod_prod) VALUES (?,?,?,?,?,?) "); 

		try {
			
			//variable para almacenar el resultado de la consulta
			//crea el preparedStatement (y lo compila)
			//ejecuta la consulta y almacena el resultado en el "ResultSet"
			
			
			this.ps=this.con.prepareStatement(sql_search);  
			
			this.ps.setInt(1, cod); //codigo de imagen
			
			this.ps.setString(2, nombre);
			this.ps.setString(3, Q1);
			this.ps.setString(4, Q2);
			
			File image = new File (ruta);
				
			try {
			
				FileInputStream inputImage = new FileInputStream(image);
			this.ps.setBinaryStream(5, inputImage, image.length());
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			
			
			this.ps.setInt(6, 1); //numero de asociacion al proyecto
			
			this.ps.executeUpdate();
			
			JOptionPane.showMessageDialog (
					this.LoadImageWindow, "Cuestion agregada correctamente a la BBDD", "Consulta correcta", 1);
			
			
		 	} catch (SQLException e) { e.printStackTrace(); 
		 		JOptionPane.showMessageDialog (
					this.LoadImageWindow, "Cuestion agregada erroneamente a la BBDD", "Consulta incorrecta", 0);
		 	} 
			
			finally {
			  try { this.con.close(); this.LoadImageWindow.dispose(); } 
			  catch (SQLException e) { e.printStackTrace();
			  		}
			  
		}
		
		
	}

 
/**
* Método para leer un proyecto
*/ 
 public void readProyect(JLabel image, int cod_cuest) {

	 this.LoadDriver();
	 
	 this.nombre = null;
	 this.cuestion_1 = null; 
	 this.cuestion_2 = null;
	 this.cod_cuest = 0; 
	 this.cod_prod= 0;  

	 // Script SQL
	 String sql_read ="SELECT * FROM CUESTIONARIO WHERE cod_cuest = ?";

	 try {

		 this.ps = this.con.prepareStatement(sql_read);
		 this.ps.setInt(1, cod_cuest);

		 ResultSet rs = this.ps.executeQuery();

		 //si existe una tupla guarda sus datos en todas y cada una de las variables locales
		 while (rs.next()) {

			 //recoje en variables todos los parametros
			 this.nombre = rs.getString("nombre");
			 this.cuestion_1 = rs.getString("cuestion_1");
			 this.cuestion_2 = rs.getString("cuestion_2");
			 this.cod_cuest = rs.getInt("cod_cuest");
			 this.cod_prod = rs.getInt("cod_prod");
			 
			 
			//capta la imagen en un tipo de datos "Blob"
			Blob blob_image = rs.getBlob("imagen");
			// mediante el metod getBytes (del dato Blob) se almacena la imagen en un array de Bytes
			this.image = blob_image.getBytes(1, (int)blob_image.length());
			
			// Crea un Objeto Icono, con el Array de bytes recojido de la BBD
			// Crea un Objeto Image con el Icono y lo re-escala
			ImageIcon img = new ImageIcon(this.image);
			Image tmp = img.getImage().getScaledInstance(600, 400, 0);
			
			// Re-crea el icono pasandole como parametro la imagen re-escalada
			img = new ImageIcon(tmp);
			// establece el icono en el Label
			image.setIcon(img);

		 }
	 } catch (SQLException e) {
		 System.out.println(" fallo en el SQL");
		 e.printStackTrace();
	 } finally  {

		 try { this.con.close();} 
		 catch (SQLException e) { e.printStackTrace(); }

	 }


 }
}

