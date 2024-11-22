package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Kernel.Fecha;

public class NewMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Fecha date = new Fecha();
	int xMouse, yMouse;

	/**
	 * Create the frame.
	 */
	public NewMenu() {

		setResizable(false);
		setLocationByPlatform(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblfecha = new JLabel();
		lblfecha.setBackground(new Color(255, 255, 255));
		lblfecha.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		lblfecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		lblfecha.setFont(new Font("Lato Thin", Font.PLAIN, 14));
		lblfecha.setText(date.fecha);
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(28, 0, 772, 25);
		panel.add(lblfecha);

		JTabbedPane tabstest = new JTabbedPane(JTabbedPane.RIGHT);
		tabstest.setBackground(new Color(255, 255, 255));
		tabstest.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabstest.setBounds(149, 30, 676, 570);
		panel.add(tabstest);

		JPanel tabhome = new JPanel();
		tabhome.setBackground(new Color(255, 255, 255));
		tabstest.addTab("", null, tabhome, null);
		tabhome.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(10, 96, 309, 356);
		tabhome.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("BIENVENID@");
		lblNewLabel_1.setFont(new Font("Lato Thin", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(10, 11, 463, 74);
		tabhome.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/homeback.jpg")));
		lblNewLabel.setBounds(0, 0, 655, 565);
		tabhome.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 160, 150, 440);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnppal = new JButton("Home");
		btnppal.setFocusable(false);
		btnppal.setForeground(new Color(255, 255, 255));
		btnppal.setFont(new Font("Lato Heavy", Font.PLAIN, 14));
		btnppal.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/home.png")));
		btnppal.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnppal.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnppal.setBackground(new Color(0, 128, 192));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tabstest.setSelectedIndex(0);
			}
		});
		btnppal.setBackground(new Color(0, 128, 192));
		btnppal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnppal.setBounds(0, 0, 150, 69);
		panel_1.add(btnppal);
		btnppal.setBorderPainted(false);
		btnppal.setBorder(null);

		JButton btninv = new JButton("Recetas");
		btninv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btninv.setFocusable(false);
		btninv.setBackground(new Color(0, 128, 192));
		btninv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninv.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btninv.setBackground(new Color(0, 128, 192));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tabstest.setSelectedIndex(1);
			}
		});
		btninv.setBorderPainted(false);
		btninv.setBorder(null);
		btninv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btninv.setForeground(new Color(255, 255, 255));
		btninv.setFont(new Font("Lato Heavy", Font.PLAIN, 14));
		btninv.setBounds(0, 69, 150, 69);
		panel_1.add(btninv);

		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/Logo.png")));
		lbllogo.setBounds(0, 30, 150, 131);
		panel.add(lbllogo);

		JButton btnexit = new JButton("X");
		btnexit.setFocusable(false);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(new Color(255, 0, 0));
				btnexit.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(250, 250, 250));
				btnexit.setForeground(new Color(0, 0, 0));
			}
		});
		btnexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexit.setBackground(new Color(255, 255, 255));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setFont(new Font("Lato Heavy", Font.PLAIN, 14));
		btnexit.setBorderPainted(false);
		btnexit.setBorder(null);
		btnexit.setBounds(0, 0, 27, 23);
		panel.add(btnexit);

	}
}
