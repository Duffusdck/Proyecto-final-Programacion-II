package GUI;

//Importaciones necesarias para la clase
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class runApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public boolean registro = false;

	//Constructor para el Frame
	public runApp() {
		setTitle("LADAMI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(runApp.class.getResource("/IMGS/LogoN.png")));
		setBackground(new Color(158, 193, 163));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(158, 193, 163));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Boton para abrir la pagina de ingreso y/o registro
		JButton btning = new JButton("Ingresar o Registrarse");
		btning.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btning.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btning.setBackground(new Color(31, 54, 61));
			}
		});
		btning.setIcon(new ImageIcon(runApp.class.getResource("/IMGS/Login.png")));
		btning.setFont(new Font("Lato Black", Font.PLAIN, 15));
		btning.setForeground(new Color(255, 255, 255));
		btning.setBorder(null);
		btning.setBackground(new Color(31, 51, 61));
		btning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login entrar = new login();
				entrar.setVisible(true);
				dispose();
			}
		});
		btning.setBounds(20, 346, 200, 35);
		contentPane.add(btning);

		//Boton para acceder como invitado
		JButton btninvi = new JButton("Invitado");
		btninvi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninvi.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btninvi.setBackground(new Color(31, 54, 61));
			}

		});
		btninvi.setForeground(new Color(255, 255, 255));
		btninvi.setFont(new Font("Lato Black", Font.PLAIN, 15));
		btninvi.setBackground(new Color(31, 51, 61));
		btninvi.setBorder(null);
		btninvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invitados inv = new Invitados();
				registro = true;
				inv.setVisible(true);
				dispose();
			}
		});
		btninvi.setBounds(301, 346, 200, 35);
		contentPane.add(btninvi);

		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(runApp.class.getResource("/IMGS/LogoN.png")));
		lbllogo.setBounds(10, 11, 150, 150);
		contentPane.add(lbllogo);

		JLabel lblwelcome = new JLabel("<html>¡Bienvenid@ a LADAMI!<br>Tu app favorita de cocina</html>");
		lblwelcome.setForeground(new Color(255, 255, 255));
		lblwelcome.setFont(new Font("Lato Black", Font.PLAIN, 30));
		lblwelcome.setBounds(170, 11, 331, 139);
		contentPane.add(lblwelcome);

		JLabel lblInfo = new JLabel(
				"<html>Esta aplicación ha sido creada por:<br>Daniel Esteban Pedraza Dueñas<br>Laura Daniela Bernal Ariza<br>Milton Hernan Cuitiva Romero<br><br>Estudiantes de 3er semestre de Técnica Profesional en Computación de la Escuela Tecnológica Instituto Técnico Central. </html>");
		lblInfo.setFont(new Font("Lato Heavy", Font.PLAIN, 12));
		lblInfo.setBounds(20, 165, 394, 110);
		contentPane.add(lblInfo);

		JLabel lblopciones = new JLabel("¿De que manera deseas ingresar a la aplicación?");
		lblopciones.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		lblopciones.setBounds(20, 316, 323, 19);
		contentPane.add(lblopciones);

		JLabel lblwarn1 = new JLabel(
				"<html>*Al ingresar o registrarse, obtendrás las funciones completas de la App</html>");
		lblwarn1.setFont(new Font("Lato Light", Font.PLAIN, 12));
		lblwarn1.setBounds(20, 380, 200, 30);
		contentPane.add(lblwarn1);

		JLabel lblalIngresarComo = new JLabel(
				"<html>*Al ingresar como invitado tendrás una versión limitada de la App</html>");
		lblalIngresarComo.setFont(new Font("Lato Light", Font.PLAIN, 12));
		lblalIngresarComo.setBounds(301, 381, 200, 30);
		contentPane.add(lblalIngresarComo);
	}
}
