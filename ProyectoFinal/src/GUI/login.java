package GUI;

//Importaciones necesarias para la funcionalidad de la aplicación
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistencia.Conexion;
import java.awt.Toolkit;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Componentes de la interfaz
	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField txtPasw;

	// Instancia para manejar la conexión a la base de datos
	Conexion conectar = Conexion.getInstance();

	//Constructor que crea la ventana del login.
	public login() {
		// Configuración de la ventana principal
		setTitle("LADAMI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/IMGS/LogoN.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 350);
		
		// Panel principal
		contentPane = new JPanel();
		contentPane.setBackground(new Color(158, 193, 163));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta de título
		JLabel lbltxt = new JLabel("INICIAR SESIÓN");
		lbltxt.setBounds(48, 49, 225, 25);
		lbltxt.setFont(new Font("Lato Medium", Font.PLAIN, 20));
		contentPane.add(lbltxt);

		// Etiqueta de usuario
		JLabel lblusr = new JLabel("Usuario");
		lblusr.setBounds(48, 96, 86, 25);
		lblusr.setFont(new Font("Lato Medium", Font.PLAIN, 17));
		contentPane.add(lblusr);

		//Boton para iniciar sesión
		JButton btninses = new JButton("Iniciar Sesión");
		btninses.setFocusable(false);
		btninses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conexion = conectar.conectar();) {
					// Preparar la consulta SQL para buscar el usuario y su contraseña
					String query = "SELECT * FROM registro WHERE Usuario = ? AND Password = ?";
					try (PreparedStatement statement = conexion.prepareStatement(query)) {
						// Establecer los parámetros en la consulta
						statement.setString(1, txtUsu.getText());
						statement.setString(2, String.valueOf(txtPasw.getPassword()));

						// Ejecutar la consulta
						try (ResultSet resultSet = statement.executeQuery()) {
							if (resultSet.next()) {
								Menu full = new Menu();
								full.setVisible(true);
								dispose();
								// Si el usuario existe y la contraseña coincide
								JOptionPane.showMessageDialog(null, "¡Bienvenido, " + txtUsu.getText() + "!", "Sesión Iniciada",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								// Si no se encuentra el usuario o la contraseña es incorrecta
								JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				} catch (SQLException es) {
					// Manejo de excepciones
					System.out.println("Error al conectar con la base de datos: " + es.getMessage());
				}
			}

		});
		
		//Efectos al pasar mouse sobre el boton
		btninses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninses.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btninses.setBackground(new Color(31, 54, 61));
			}
		});
		//estilo del boton
		btninses.setForeground(new Color(255, 255, 255));
		btninses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btninses.setBorder(null);
		btninses.setBackground(new Color(31, 51, 61));
		btninses.setBounds(48, 266, 136, 32);
		btninses.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		contentPane.add(btninses);

		JLabel lblaviso = new JLabel("*Si no estas registrad@ con los datos ingresados, no podrás iniciar sesión.");
		lblaviso.setBounds(32, 326, 334, 14);
		lblaviso.setFont(new Font("Lato", Font.PLAIN, 10));
		contentPane.add(lblaviso);

		JButton btnMenu = new JButton("<--");
		btnMenu.setFocusable(false);
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMenu.setBackground(new Color(31, 54, 61));
				btnMenu.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMenu.setBackground(new Color(158, 193, 163));
				btnMenu.setForeground(new Color(0, 0, 0));
			}
		});
		btnMenu.setBackground(new Color(158, 193, 163));
		btnMenu.setBorder(null);
		btnMenu.setBounds(0, 0, 45, 25);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runApp inv = new runApp();
				inv.setVisible(true);
				dispose();
			}
		});
		btnMenu.setFont(new Font("Lato Black", Font.PLAIN, 18));
		contentPane.add(btnMenu);

		JSeparator separator = new JSeparator();
		separator.setBounds(51, 155, 278, 8);
		separator.setAlignmentY(Component.TOP_ALIGNMENT);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		contentPane.add(separator);

		//campo de texto para el usuario
		txtUsu = new JTextField();
		txtUsu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtUsu.getText().equals("Ingrese nombre de usuario")) {
					txtUsu.setText("");
					txtUsu.setForeground(Color.black);
				}
				if (String.valueOf(txtPasw.getPassword()).isEmpty()) {
					txtPasw.setText("123456789");
					txtPasw.setForeground(Color.gray);
				}
			}
		});
		txtUsu.setOpaque(false);
		txtUsu.setBackground(new Color(247, 239, 220));
		txtUsu.setBounds(52, 126, 278, 32);
		txtUsu.setText("Ingrese nombre de usuario");
		txtUsu.setForeground(new Color(112, 169, 161));
		txtUsu.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		txtUsu.setColumns(10);
		txtUsu.setBorder(null);
		contentPane.add(txtUsu);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Lato Medium", Font.PLAIN, 17));
		lblContrasea.setBounds(48, 173, 130, 25);
		contentPane.add(lblContrasea);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setAlignmentY(0.0f);
		separator_1.setBounds(51, 232, 278, 8);
		contentPane.add(separator_1);

		//Campo de texto para la contraseña
		txtPasw = new JPasswordField();
		txtPasw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Si el usuario intenta escribir un espacio, cancelamos la acción
				if (e.getKeyChar() == ' ') {
					e.consume(); // Evita que el espacio sea ingresado
				}
			}
		});

		txtPasw.setForeground(new Color(112, 169, 161));
		txtPasw.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (String.valueOf(txtPasw.getPassword()).equals("123456789")) {
					txtPasw.setText("");
					txtPasw.setForeground(Color.black);
				}
				if (txtUsu.getText().isEmpty()) {
					txtUsu.setText("Ingrese nombre de usuario");
					txtUsu.setForeground(Color.gray);
				}

			}
		});
		//configuraciones del campo de contraseña
		txtPasw.setOpaque(false);
		txtPasw.setBackground(new Color(247, 239, 220));
		txtPasw.setText("123456789");
		txtPasw.setBorder(null);
		txtPasw.setEchoChar('■');
		txtPasw.setToolTipText("");
		txtPasw.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtPasw.setBounds(52, 208, 278, 29);
		contentPane.add(txtPasw);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/IMGS/Lateral.png")));
		lblNewLabel.setBounds(376, 0, 229, 350);
		contentPane.add(lblNewLabel);

		//Boton de registro
		JButton btnReg = new JButton("Registrarse");
		btnReg.setFocusable(false);
		btnReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReg.setBackground(new Color(64, 121, 140));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReg.setBackground(new Color(31, 51, 61));
			}
		});
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Conexion y subida de datos a la base de datos
					Connection conexion = conectar.conectar();
					PreparedStatement insertar = conexion.prepareStatement("Insert into registro values(?,?)");
					insertar.setString(1, txtUsu.getText());
					insertar.setString(2, String.valueOf(txtPasw.getPassword()));

					insertar.executeUpdate();
					JOptionPane.showMessageDialog(null, "Datos registrados");

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, error);

				}
			}
		});
		btnReg.setForeground(new Color(255, 255, 255));
		btnReg.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		btnReg.setBorder(null);
		btnReg.setBackground(new Color(31, 51, 61));
		btnReg.setBounds(194, 266, 136, 32);
		contentPane.add(btnReg);
	}

}