package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RecetasInvitado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RecetasInvitado() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnback = new JButton("Menu");
		btnback.setFont(new Font("Lato", Font.PLAIN, 12));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu window = new MainMenu();
				window.frame.setVisible(true);
				dispose();

			}
		});
		btnback.setBounds(497, 25, 71, 23);
		contentPane.add(btnback);
		
		JLabel lblReIn = new JLabel("RECETAS PARA INVITADOS");
		lblReIn.setHorizontalTextPosition(SwingConstants.LEADING);
		lblReIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReIn.setFont(new Font("Lato Black", Font.PLAIN, 20));
		lblReIn.setBounds(10, 11, 264, 45);
		contentPane.add(lblReIn);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setFont(new Font("Lato", Font.PLAIN, 12));
		tabbedPane.setBackground(new Color(204, 255, 255));
		tabbedPane.setBounds(10, 106, 558, 328);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Entrada", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tab1");
		lblNewLabel_1.setBounds(48, 97, 46, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Plato Fuerte", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tab2");
		lblNewLabel_2.setBounds(156, 196, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Postre", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tab3");
		lblNewLabel_3.setBounds(195, 169, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("<html>Bienvenido a la sección de invitados<br>Por favor, elige una opción:</html>");
		lblNewLabel.setFont(new Font("Lato", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 56, 222, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("*Las recetas para Invitados están limitadas, registrate para ver mas.");
		lblNewLabel_4.setFont(new Font("Lato", Font.PLAIN, 8));
		lblNewLabel_4.setBounds(10, 434, 236, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		
	}
}
