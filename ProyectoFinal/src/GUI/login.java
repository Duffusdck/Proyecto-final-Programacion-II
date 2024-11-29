package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField txtPasw;
	
	Conexion conectar = Conexion.getInstance();

	/**
	 * Create the frame.
	 */
	public login() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 236));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltxt = new JLabel("INICIAR SESIÓN");
		lbltxt.setBounds(48, 49, 225, 25);
		lbltxt.setFont(new Font("Lato Medium", Font.PLAIN, 20));
		contentPane.add(lbltxt);

		JLabel lblusr = new JLabel("Usuario");
		lblusr.setBounds(48, 96, 86, 25);
		lblusr.setFont(new Font("Lato Medium", Font.PLAIN, 17));
		contentPane.add(lblusr);

		JButton btninses = new JButton("Iniciar Sesión");
		btninses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conexion = conectar.conectar();) {
					// Preparar la consulta SQL para buscar el usuario y su contraseña
					String query = "SELECT * FROM registro WHERE Usuario = ? AND Pasword = ?";
					try (PreparedStatement statement = conexion.prepareStatement(query)) {
						// Establecer los parámetros en la consulta
						statement.setString(1, txtUsu.getText());
						statement.setString(2, String.valueOf(txtPasw.getPassword()));

						// Ejecutar la consulta
						try (ResultSet resultSet = statement.executeQuery()) {
							if (resultSet.next()) {
								// Si el usuario existe y la contraseña coincide
								JOptionPane.showMessageDialog(null, "¡Bienvenido, " + txtUsu.getText() + "!", "Singin",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								// Si no se encuentra el usuario o la contraseña es incorrecta
								JOptionPane.showMessageDialog(null,"Nombre de usuario o contraseña incorrectos.","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				} catch (SQLException es) {
					// Manejo de excepciones
					System.out.println("Error al conectar con la base de datos: " + es.getMessage());
				}
			}

		});
		btninses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninses.setBackground(new Color(241, 202, 65));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btninses.setBackground(new Color(248, 228, 156));
			}
		});
		btninses.setForeground(new Color(0, 0, 0));
		btninses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btninses.setBorder(null);
		btninses.setBackground(new Color(248, 228, 156));
		btninses.setBounds(48, 266, 136, 32);
		btninses.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		contentPane.add(btninses);

		JLabel lblaviso = new JLabel("*Si no estas registrad@ con los datos ingresados, no podrás iniciar sesión.");
		lblaviso.setBounds(32, 326, 334, 14);
		lblaviso.setFont(new Font("Lato", Font.PLAIN, 10));
		contentPane.add(lblaviso);

		JButton btnMenu = new JButton("<--");
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMenu.setBackground(new Color(0, 255, 121));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMenu.setBackground(new Color(255, 251, 236));
			}
		});
		btnMenu.setBackground(new Color(255, 251, 236));
		btnMenu.setBorder(null);
		btnMenu.setBounds(0, 0, 45, 25);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewMenu window = new NewMenu();
				window.setVisible(true);
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
		txtUsu.setForeground(Color.LIGHT_GRAY);
		txtUsu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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

		txtPasw = new JPasswordField();
		txtPasw.setForeground(new Color(128, 128, 128));
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
		
		JButton btnReg = new JButton("Registrarse");
		btnReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReg.setBackground(new Color(241, 202, 65));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReg.setBackground(new Color(248, 228, 156));
			}
		});
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (String.valueOf(txtPasw.getPassword()).trim().isEmpty() || String.valueOf(txtPasw.getPassword()).equals("123456789")) {
						JOptionPane.showMessageDialog(null, "El campo no puede estar vacío o contener solo espacios.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
					Connection conexion = conectar.conectar();
					PreparedStatement insertar = conexion.prepareStatement("Insert into registro values(?,?)");
					insertar.setString(1, txtUsu.getText());
					insertar.setString(2, String.valueOf(txtPasw.getPassword()));

					insertar.executeUpdate();
					JOptionPane.showMessageDialog(null, "Datos registrados");
					}

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		btnReg.setForeground(Color.BLACK);
		btnReg.setFont(new Font("Lato Medium", Font.PLAIN, 15));
		btnReg.setBorder(null);
		btnReg.setBackground(new Color(248, 228, 156));
		btnReg.setBounds(230, 266, 136, 32);
		contentPane.add(btnReg);
	}
}