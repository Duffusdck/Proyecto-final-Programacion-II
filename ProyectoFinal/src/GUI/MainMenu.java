package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class MainMenu {

	public JFrame frame;
	private ButtonGroup botones = new ButtonGroup();

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 650, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("<html>¡Bienvenido a tu libro<br>de recetas virtual!</html>");
		lblTitle.setForeground(new Color(0, 51, 255));
		lblTitle.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setBounds(10, 125, 205, 50);
		frame.getContentPane().add(lblTitle);

		JLabel lblmsg = new JLabel("<html>¿Como deseas continuar?<br>Por favor, elige una opción:</html>");
		lblmsg.setFont(new Font("Lato", Font.PLAIN, 14));
		lblmsg.setBounds(10, 176, 205, 39);
		frame.getContentPane().add(lblmsg);

		JRadioButton rdbtnReg = new JRadioButton("Registrarse o iniciar sesión");
		rdbtnReg.setFont(new Font("Lato", Font.PLAIN, 12));
		rdbtnReg.setBounds(6, 222, 171, 23);
		frame.getContentPane().add(rdbtnReg);

		JRadioButton rdbtnInv = new JRadioButton("Ingresa como Invitado");
		rdbtnInv.setFont(new Font("Lato", Font.PLAIN, 12));
		rdbtnInv.setBounds(10, 248, 151, 23);
		frame.getContentPane().add(rdbtnInv);

		JRadioButton rdbtnExit = new JRadioButton("Salir del programa");
		rdbtnExit.setFont(new Font("Lato", Font.PLAIN, 12));
		rdbtnExit.setBounds(10, 274, 140, 23);
		frame.getContentPane().add(rdbtnExit);

		botones.add(rdbtnReg);
		botones.add(rdbtnInv);
		botones.add(rdbtnExit);

		RecetasInvitado inv = new RecetasInvitado();
		regses reg = new regses();
		// users users = new users();

		JButton btncont = new JButton("Continuar");
		btncont.setFont(new Font("Lato", Font.PLAIN, 10));
		btncont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnReg.isSelected()) {
					reg.setVisible(true);
					frame.dispose();
				}
				if (rdbtnInv.isSelected()) {
					inv.setVisible(true);
					frame.dispose();
				}
				if (rdbtnExit.isSelected()) {
					//int exit = JOptionPane.showConfirmDialog(null, "¿Deseas salir?", "Salir", JOptionPane.YES_NO_OPTION,
						//	JOptionPane.QUESTION_MESSAGE);
					//if (exit == JOptionPane.YES_OPTION) {
						System.exit(0);
					//}
				}
			}
		});
		btncont.setBounds(10, 304, 89, 23);
		frame.getContentPane().add(btncont);

		JButton btnNewButton = new JButton("Sobre la app");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Aplicacion de cocina \nHecha por:\nDaniel Pedraza\nLaura Bernal \nMilton Cuitiva",
						"Sobre la APP", JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnNewButton.setFont(new Font("Lato Medium", Font.PLAIN, 12));
		btnNewButton.setBounds(107, 304, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exam tab = new Exam();
			tab.setVisible(true);
			frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(228, 305, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 650, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Iniciar Sesión");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Lato", Font.PLAIN, 10));
		btnNewButton_2.setBounds(533, 11, 107, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Registrarse");
		btnNewButton_3.setFont(new Font("Lato", Font.PLAIN, 10));
		btnNewButton_3.setBounds(533, 32, 107, 23);
		panel.add(btnNewButton_3);
	}
}
