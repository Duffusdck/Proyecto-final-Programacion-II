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
import javax.swing.JCheckBox;
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
		setBounds(100, 100, 851, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 841, 600);
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

		JButton btnpostre = new JButton(
				"<html><center><b>Postre: </b><br>Pie de limon con galleta de chocolate</center></html>");
		btnpostre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnpostre.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnpostre.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnPostre.png")));
			}
		});
		btnpostre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnpostre.setFont(new Font("Lato Light", Font.PLAIN, 20));
		btnpostre.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnPostre.png")));
		btnpostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(4);
			}
		});
		
		JLabel lblmsg = new JLabel("<html><b>¡Bienvenid@!</b><br>En esta app podrás ver y añadir tus recetas favoritas!<br>En la parte de abajo, encontrarás 3 recetas de muestra. <br>Para ver y/o añadir recetas nuevas debes registrarte</html>");
		lblmsg.setFont(new Font("Lato", Font.PLAIN, 14));
		lblmsg.setBounds(10, 75, 349, 74);
		tabhome.add(lblmsg);
		btnpostre.setBorder(null);
		btnpostre.setBackground(new Color(255, 255, 255));
		btnpostre.setBounds(10, 439, 310, 115);
		tabhome.add(btnpostre);

		JButton btnfuerte = new JButton(
				"<html><center><b>Plato Fuerte: </b><br>Lasagna con carne molida al horno</center></html>");
		btnfuerte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnfuerte.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnFuerte.png")));
		btnfuerte.setFont(new Font("Lato Light", Font.PLAIN, 20));
		btnfuerte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnfuerte.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnfuerte.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnFuerte.png")));
			}
		});

		btnfuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(3);
			}
		});
		btnfuerte.setBackground(new Color(255, 255, 255));
		btnfuerte.setBorder(null);
		btnfuerte.setBounds(10, 299, 310, 115);
		tabhome.add(btnfuerte);

		JButton btnentrada = new JButton("<html><center><b>Entrada: </b><br>Fusilli en salsa blanca</center></html>");
		btnentrada.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnEntrada.png")));
		btnentrada.setFont(new Font("Lato Light", Font.PLAIN, 20));
		btnentrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnentrada.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnentrada.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnEntrada.png")));
			}
		});
		btnentrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnentrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(2);
			}
		});
		btnentrada.setBackground(new Color(255, 255, 255));
		btnentrada.setBorder(null);
		btnentrada.setBounds(10, 153, 310, 115);
		tabhome.add(btnentrada);

		JLabel lblNewLabel_1 = new JLabel("BIENVENID@");
		lblNewLabel_1.setFont(new Font("Lato Light", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(10, 11, 309, 74);
		tabhome.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/homeback.jpg")));
		lblNewLabel.setBounds(0, 0, 655, 565);
		tabhome.add(lblNewLabel);

		JPanel tabrec = new JPanel();
		tabrec.setBackground(new Color(255, 255, 255));
		tabstest.addTab("", null, tabrec, null);
		tabrec.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(290, 241, 46, 14);
		tabrec.add(label);

		JPanel panel_entradas = new JPanel();
		panel_entradas.setBackground(new Color(255, 255, 191));
		tabstest.addTab("", null, panel_entradas, null);
		panel_entradas.setLayout(null);
		
		JLabel lblRecipeName = new JLabel("Fusilli en salsa blanca");
		lblRecipeName.setForeground(new Color(64, 0, 64));
		lblRecipeName.setFont(new Font("Lato Semibold", Font.PLAIN, 25));
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName.setBounds(11, 11, 309, 30);
		panel_entradas.add(lblRecipeName);

		JLabel lblimg = new JLabel("New label");
		lblimg.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnEntrada.png")));
		lblimg.setBounds(10, 11, 310, 115);
		panel_entradas.add(lblimg);

		JLabel lblutensilios = new JLabel("Utensilios:");
		lblutensilios.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensilios.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensilios.setBounds(328, 11, 317, 24);
		panel_entradas.add(lblutensilios);

		JLabel lbllicuadora = new JLabel("     Licuadora");
		lbllicuadora.setFont(new Font("Lato", Font.ITALIC, 15));
		lbllicuadora.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/blender.png")));
		lbllicuadora.setBounds(428, 50, 117, 36);
		panel_entradas.add(lbllicuadora);

		JLabel lblSarten = new JLabel("Sartén");
		lblSarten.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/sarten.png")));
		lblSarten.setFont(new Font("Lato", Font.ITALIC, 15));
		lblSarten.setBounds(428, 90, 117, 36);
		panel_entradas.add(lblSarten);

		JCheckBox chckbxmant = new JCheckBox("60gr de Mantequilla");
		chckbxmant.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxmant.setBackground(new Color(255, 255, 191));
		chckbxmant.setBounds(10, 168, 162, 23);
		panel_entradas.add(chckbxmant);

		JLabel lblNewLabel_6 = new JLabel("Ingredientes:");
		lblNewLabel_6.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 137, 161, 24);
		panel_entradas.add(lblNewLabel_6);

		JCheckBox chckbxharina = new JCheckBox("60gr de Harina trigo ");
		chckbxharina.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxharina.setBackground(new Color(255, 255, 191));
		chckbxharina.setBounds(10, 194, 162, 23);
		panel_entradas.add(chckbxharina);

		JCheckBox chckbxLecheEvapo = new JCheckBox("Crema de Leche");
		chckbxLecheEvapo.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxLecheEvapo.setBackground(new Color(255, 255, 191));
		chckbxLecheEvapo.setBounds(10, 220, 162, 23);
		panel_entradas.add(chckbxLecheEvapo);

		JCheckBox chckbxagua = new JCheckBox("1 1/4 Tazas de agua");
		chckbxagua.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxagua.setBackground(new Color(255, 255, 191));
		chckbxagua.setBounds(174, 168, 162, 23);
		panel_entradas.add(chckbxagua);

		JCheckBox chckbxSal = new JCheckBox("1/2 Cucharada de sal");
		chckbxSal.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxSal.setBackground(new Color(255, 255, 191));
		chckbxSal.setBounds(174, 194, 162, 23);
		panel_entradas.add(chckbxSal);

		JCheckBox chckbxNuez = new JCheckBox("Nuez moscada molida");
		chckbxNuez.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxNuez.setBackground(new Color(255, 255, 191));
		chckbxNuez.setBounds(174, 220, 162, 23);
		panel_entradas.add(chckbxNuez);

		JCheckBox chckbxMant = new JCheckBox("1 Cucharada de Mantequilla");
		chckbxMant.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxMant.setBackground(new Color(255, 255, 191));
		chckbxMant.setBounds(345, 168, 162, 23);
		panel_entradas.add(chckbxMant);

		JCheckBox chckbxJamon = new JCheckBox("Jamon cortado en cubos");
		chckbxJamon.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxJamon.setBackground(new Color(255, 255, 191));
		chckbxJamon.setBounds(345, 194, 162, 23);
		panel_entradas.add(chckbxJamon);

		JCheckBox chckbxFusilli = new JCheckBox("200gr Pasta Fusilli");
		chckbxFusilli.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbxFusilli.setBackground(new Color(255, 255, 191));
		chckbxFusilli.setBounds(345, 220, 162, 23);
		panel_entradas.add(chckbxFusilli);
		
		JLabel lblTitulo = new JLabel("¡A COCINAR!");
		lblTitulo.setFont(new Font("Lato Black", Font.PLAIN, 35));
		lblTitulo.setBounds(10, 250, 224, 43);
		panel_entradas.add(lblTitulo);
		
		JLabel lblNewLabel_8 = new JLabel("<html>Para hacer la salsa <b>Bechamel</b> derrite la mantequilla en una olla, agrega la harina y revuelve constantemente durante tres minutos, agrega constantemente la crema de leche y un poco de agua para evitar grumos.</html>");
		lblNewLabel_8.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(67, 297, 401, 88);
		panel_entradas.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("1.");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel_9.setBounds(20, 313, 37, 55);
		panel_entradas.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("2.");
		lblNewLabel_10.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel_10.setBounds(596, 396, 37, 55);
		panel_entradas.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("<html>Añade la sal y la nuez moscada, revolviendo constantemente para evitar que se pegue; cocina hasta que espese ligeramente.</html>");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(185, 395, 401, 74);
		panel_entradas.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("3.");
		lblNewLabel_12.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel_12.setBounds(20, 494, 37, 55);
		panel_entradas.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("<html>Calienta la mantequilla y dora ligeramente el jamón. Añade la pasta previamente cocida y escurrida, la salsa bechamel y mezcla suavemente. Cocina por 2 minutos a fuego medio y <b>¡Disfruta!</b></html>");
		lblNewLabel_13.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(67, 480, 401, 74);
		panel_entradas.add(lblNewLabel_13);

		JPanel panel_fuerte = new JPanel();
		panel_fuerte.setBackground(new Color(255, 255, 191));
		tabstest.addTab("", null, panel_fuerte, null);
		panel_fuerte.setLayout(null);
		
		JLabel lblfuertename = new JLabel("Fusilli en salsa blanca");
		lblfuertename.setForeground(new Color(64, 0, 64));
		lblfuertename.setFont(new Font("Lato Semibold", Font.PLAIN, 25));
		lblfuertename.setHorizontalAlignment(SwingConstants.CENTER);
		lblfuertename.setBounds(11, 11, 309, 30);
		panel_entradas.add(lblfuertename);

		JLabel lblimgfuerte = new JLabel("New label");
		lblimgfuerte.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/btnEntrada.png")));
		lblimgfuerte.setBounds(10, 11, 310, 115);
		panel_entradas.add(lblimgfuerte);

		JLabel lblutensil = new JLabel("Utensilios:");
		lblutensil.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensil.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensil.setBounds(328, 11, 317, 24);
		panel_entradas.add(lblutensilios);

		JLabel lblutl1 = new JLabel("     Licuadora");
		lblutl1.setFont(new Font("Lato", Font.ITALIC, 15));
		lblutl1.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/blender.png")));
		lblutl1.setBounds(428, 50, 117, 36);
		panel_entradas.add(lbllicuadora);

		JLabel lblutl2 = new JLabel("Sartén");
		lblutl2.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/sarten.png")));
		lblutl2.setFont(new Font("Lato", Font.ITALIC, 15));
		lblutl2.setBounds(428, 90, 117, 36);
		panel_entradas.add(lblutl2);

		JCheckBox chckbx1 = new JCheckBox("60gr de Mantequilla");
		chckbx1.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1.setBackground(new Color(255, 255, 191));
		chckbx1.setBounds(10, 168, 162, 23);
		panel_entradas.add(chckbx1);

		JLabel lblttl = new JLabel("Ingredientes:");
		lblttl.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblttl.setBounds(10, 137, 161, 24);
		panel_entradas.add(lblNewLabel_6);

		JCheckBox chckbx2 = new JCheckBox("60gr de Harina trigo ");
		chckbx2.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2.setBackground(new Color(255, 255, 191));
		chckbx2.setBounds(10, 194, 162, 23);
		panel_entradas.add(chckbx2);

		JCheckBox chckbx3 = new JCheckBox("Crema de Leche");
		chckbx3.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx3.setBackground(new Color(255, 255, 191));
		chckbx3.setBounds(10, 220, 162, 23);
		panel_entradas.add(chckbx3);

		JCheckBox chckbx4 = new JCheckBox("1 1/4 Tazas de agua");
		chckbx4.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx4.setBackground(new Color(255, 255, 191));
		chckbx4.setBounds(174, 168, 162, 23);
		panel_entradas.add(chckbx4);

		JCheckBox chckbx5 = new JCheckBox("1/2 Cucharada de sal");
		chckbx5.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx5.setBackground(new Color(255, 255, 191));
		chckbx5.setBounds(174, 194, 162, 23);
		panel_entradas.add(chckbx5);

		JCheckBox chckbx6 = new JCheckBox("Nuez moscada molida");
		chckbx6.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx6.setBackground(new Color(255, 255, 191));
		chckbx6.setBounds(174, 220, 162, 23);
		panel_entradas.add(chckbx6);

		JCheckBox chckbx7 = new JCheckBox("1 Cucharada de Mantequilla");
		chckbx7.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx7.setBackground(new Color(255, 255, 191));
		chckbx7.setBounds(345, 168, 162, 23);
		panel_entradas.add(chckbx7);

		JCheckBox chckbx8 = new JCheckBox("Jamon cortado en cubos");
		chckbx8.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx8.setBackground(new Color(255, 255, 191));
		chckbx8.setBounds(345, 194, 162, 23);
		panel_entradas.add(chckbx8);

		JCheckBox chckbx9 = new JCheckBox("200gr Pasta Fusilli");
		chckbx9.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx9.setBackground(new Color(255, 255, 191));
		chckbx9.setBounds(345, 220, 162, 23);
		panel_entradas.add(chckbx9);
		
		JLabel lblacocinar = new JLabel("¡A COCINAR!");
		lblacocinar.setFont(new Font("Lato Black", Font.PLAIN, 35));
		lblacocinar.setBounds(10, 250, 224, 43);
		panel_entradas.add(lblacocinar);
		
		JLabel lblinst1 = new JLabel("<html>Para hacer la salsa <b>Bechamel</b> derrite la mantequilla en una olla, agrega la harina y revuelve constantemente durante tres minutos, agrega constantemente la crema de leche y un poco de agua para evitar grumos.</html>");
		lblinst1.setFont(new Font("Lato", Font.PLAIN, 15));
		lblinst1.setBounds(67, 297, 401, 88);
		panel_entradas.add(lblinst1);
		
		JLabel lbln1 = new JLabel("1.");
		lbln1.setHorizontalAlignment(SwingConstants.CENTER);
		lbln1.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lbln1.setBounds(20, 313, 37, 55);
		panel_entradas.add(lbln1);
		
		JLabel lbln2 = new JLabel("2.");
		lbln2.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lbln2.setBounds(596, 396, 37, 55);
		panel_entradas.add(lbln2);
		
		JLabel lblinst2 = new JLabel("<html>Añade la sal y la nuez moscada, revolviendo constantemente para evitar que se pegue; cocina hasta que espese ligeramente.</html>");
		lblinst2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblinst2.setFont(new Font("Lato", Font.PLAIN, 15));
		lblinst2.setBounds(185, 395, 401, 74);
		panel_entradas.add(lblinst2);
		
		JLabel lbln3 = new JLabel("3.");
		lbln3.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lbln3.setBounds(20, 494, 37, 55);
		panel_entradas.add(lbln3);
		
		JLabel lblinst3 = new JLabel("<html>Calienta la mantequilla y dora ligeramente el jamón. Añade la pasta previamente cocida y escurrida, la salsa bechamel y mezcla suavemente. Cocina por 2 minutos a fuego medio y <b>¡Disfruta!</b></html>");
		lblinst3.setFont(new Font("Lato", Font.PLAIN, 15));
		lblinst3.setBounds(67, 480, 401, 74);
		panel_entradas.add(lblinst3);

		
		JPanel panel_postres = new JPanel();
		tabstest.addTab("", null, panel_postres, null);

		JPanel panelbotones = new JPanel();
		panelbotones.setBounds(0, 191, 150, 409);
		panel.add(panelbotones);
		panelbotones.setLayout(null);

		JButton btnppal = new JButton("Home");
		btnppal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnppal.setFocusable(false);
		btnppal.setForeground(new Color(255, 255, 255));
		btnppal.setFont(new Font("Lato Black", Font.PLAIN, 20));
		btnppal.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/Home.png")));
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
		panelbotones.add(btnppal);
		btnppal.setBorderPainted(false);
		btnppal.setBorder(null);

		JButton btninv = new JButton("Recetas");
		btninv.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/Recipes.png")));
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
		btninv.setFont(new Font("Lato Black", Font.PLAIN, 20));
		btninv.setBounds(0, 69, 150, 69);
		panelbotones.add(btninv);

		JButton btnlogin = new JButton("Ingresar");
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setFont(new Font("Lato Black", Font.PLAIN, 20));
		btnlogin.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/Login.png")));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login reg = new login();
				reg.setVisible(true);
				dispose();
			}
		});
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogin.setBackground(new Color(0, 128, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnlogin.setBackground(new Color(0, 128, 192));
			}
		});
		btnlogin.setBackground(new Color(0, 128, 192));
		btnlogin.setBorder(null);
		btnlogin.setBounds(0, 138, 150, 69);
		panelbotones.add(btnlogin);

		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(NewMenu.class.getResource("/IMGS/LogoN.png")));
		lbllogo.setBounds(0, 30, 150, 150);
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
				btnexit.setBackground(new Color(255, 255, 255));
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
