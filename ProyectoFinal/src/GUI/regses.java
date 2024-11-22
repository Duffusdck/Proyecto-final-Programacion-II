package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class regses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public regses() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Ingreso de datos.");
		lblTitle.setFont(new Font("Lato Heavy", Font.PLAIN, 20));
		lblTitle.setBounds(10, 22, 176, 25);
		contentPane.add(lblTitle);
		
		JLabel lbltxt = new JLabel("¿Deseas iniciar sesión o registrarte?");
		lbltxt.setFont(new Font("Lato", Font.PLAIN, 14));
		lbltxt.setBounds(10, 58, 225, 25);
		contentPane.add(lbltxt);
		
		JLabel lblusr = new JLabel("Usuario:");
		lblusr.setFont(new Font("Lato", Font.PLAIN, 12));
		lblusr.setBounds(20, 104, 50, 15);
		contentPane.add(lblusr);
		
		JLabel lblpss = new JLabel("Contraseña:");
		lblpss.setFont(new Font("Lato", Font.PLAIN, 12));
		lblpss.setBounds(20, 130, 70, 15);
		contentPane.add(lblpss);
		
		textField = new JTextField();
		textField.setBounds(87, 102, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 128, 86, 20);
		contentPane.add(passwordField);
		
		JButton btninses = new JButton("Iniciar Sesión");
		btninses.setFont(new Font("Lato Medium", Font.PLAIN, 12));
		btninses.setBounds(10, 189, 112, 23);
		contentPane.add(btninses);
		
		JLabel lblaviso = new JLabel("*Si no estas registrad@ con los datos ingresados, no podrás iniciar sesión.");
		lblaviso.setFont(new Font("Lato", Font.PLAIN, 10));
		lblaviso.setBounds(10, 223, 334, 14);
		contentPane.add(lblaviso);
		
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewMenu window = new NewMenu();
				window.setVisible(true);
				dispose();
			}
		});
		btnMenu.setFont(new Font("Lato Medium", Font.PLAIN, 10));
		btnMenu.setBounds(326, 22, 63, 23);
		contentPane.add(btnMenu);
	}
}
