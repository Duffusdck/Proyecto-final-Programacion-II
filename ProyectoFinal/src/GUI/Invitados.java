package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Kernel.Fecha;
import persistencia.Conexion;
import java.awt.Toolkit;

public class Invitados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Instancia de conexion a la base de datos, objeto para la fecha y las
	// variables para el movimiento de la ventana
	Fecha date = new Fecha();
	int xMouse, yMouse;
	Conexion conectar = Conexion.getInstance();

	public Invitados() {
		//creacion de la ventana
		setTitle("LADAMI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Invitados.class.getResource("/IMGS/LogoN.png")));

		setResizable(false);
		setLocationByPlatform(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 169, 161));
		panel.setBounds(0, 0, 792, 600);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblfecha = new JLabel();
		lblfecha.setForeground(new Color(0, 0, 0));
		lblfecha.setBackground(new Color(174, 154, 228));
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
		lblfecha.setFont(new Font("Lato Thin", Font.PLAIN, 15));
		lblfecha.setText(date.fecha);
		lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblfecha.setBounds(28, 0, 772, 25);
		panel.add(lblfecha);

		JTabbedPane tabstest = new JTabbedPane(JTabbedPane.RIGHT);
		tabstest.setBackground(new Color(255, 255, 255));
		tabstest.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabstest.setBounds(149, 30, 676, 580);
		panel.add(tabstest);

		JPanel tabhome = new JPanel();
		tabhome.setBackground(new Color(158, 193, 163));
		tabstest.addTab("", null, tabhome, null);
		tabhome.setLayout(null);
		tabhome.setBounds(100, 100, 851, 800);

		JButton btnpostre = new JButton(
				"<html><center><b>Postre: </b><br>Pie de limon con galleta de chocolate</center></html>");
		btnpostre.setForeground(new Color(255, 255, 255));
		btnpostre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnpostre.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnpostre.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnPostre.png")));
			}
		});
		btnpostre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnpostre.setFont(new Font("Lato Light", Font.PLAIN, 22));
		btnpostre.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnPostre.png")));
		btnpostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(3);
			}
		});

		JLabel lblmsg = new JLabel(
				"<html><b>¡Bienvenid@!</b><br>En esta app podrás ver y añadir tus recetas favoritas!<br>En la parte de abajo, encontrarás 3 recetas de muestra. <br>Para ver y/o añadir recetas nuevas debes registrarte</html>");
		lblmsg.setFont(new Font("Lato", Font.PLAIN, 14));
		lblmsg.setBounds(10, 75, 349, 74);
		tabhome.add(lblmsg);
		btnpostre.setBorder(null);
		btnpostre.setBackground(new Color(112, 169, 161));
		btnpostre.setBounds(10, 439, 310, 115);
		tabhome.add(btnpostre);

		JButton btnfuerte = new JButton(
				"<html><center><b>Plato Fuerte: </b><br>Pechuga rellena con jamón y queso</center></html>");
		btnfuerte.setForeground(new Color(255, 255, 255));
		btnfuerte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnfuerte.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnFuerte.jpg")));
		btnfuerte.setFont(new Font("Lato Light", Font.PLAIN, 22));
		btnfuerte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnfuerte.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnfuerte.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnFuerte.jpg")));
			}
		});

		btnfuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(2);
			}
		});
		btnfuerte.setBackground(new Color(112, 169, 161));
		btnfuerte.setBorder(null);
		btnfuerte.setBounds(10, 299, 310, 115);
		tabhome.add(btnfuerte);

		JButton btnentrada = new JButton("<html><center><b>Entrada: </b><br>Fusilli en salsa blanca</center></html>");
		btnentrada.setForeground(new Color(255, 255, 255));
		btnentrada.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnEntrada.png")));
		btnentrada.setFont(new Font("Lato Light", Font.PLAIN, 22));
		btnentrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnentrada.setIcon(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnentrada.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnEntrada.png")));
			}
		});
		btnentrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnentrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(1);
			}
		});
		btnentrada.setBackground(new Color(112, 169, 161));
		btnentrada.setBorder(null);
		btnentrada.setBounds(10, 153, 310, 115);
		tabhome.add(btnentrada);

		JLabel lblNewLabel_1 = new JLabel("BIENVENID@");
		lblNewLabel_1.setFont(new Font("Lato Light", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(10, 11, 309, 74);
		tabhome.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/homeback.png")));
		lblNewLabel.setBounds(0, 0, 655, 565);
		tabhome.add(lblNewLabel);

		JPanel panel_entradas = new JPanel();
		panel_entradas.setBackground(new Color(158, 193, 163));
		tabstest.addTab("", null, panel_entradas, null);
		panel_entradas.setLayout(null);

		JLabel lblRecipeName = new JLabel("Fusilli en salsa blanca");
		lblRecipeName.setForeground(new Color(31, 54, 61));
		lblRecipeName.setFont(new Font("Lato Semibold", Font.PLAIN, 25));
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName.setBounds(328, 11, 309, 30);
		panel_entradas.add(lblRecipeName);

		JLabel lblimg = new JLabel("New label");
		lblimg.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnEntrada.png")));
		lblimg.setBounds(10, 11, 310, 115);
		panel_entradas.add(lblimg);

		JLabel lblutensilios = new JLabel("Utensilios:");
		lblutensilios.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensilios.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensilios.setBounds(328, 60, 317, 24);
		panel_entradas.add(lblutensilios);

		JLabel lbllicuadora = new JLabel("     Licuadora");
		lbllicuadora.setFont(new Font("Lato", Font.ITALIC, 15));
		lbllicuadora.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/blender.png")));
		lbllicuadora.setBounds(328, 90, 117, 36);
		panel_entradas.add(lbllicuadora);

		JLabel lblSarten = new JLabel("Sartén");
		lblSarten.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/sarten.png")));
		lblSarten.setFont(new Font("Lato", Font.ITALIC, 15));
		lblSarten.setBounds(514, 90, 117, 36);
		panel_entradas.add(lblSarten);

		JLabel lblNewLabel_6 = new JLabel("Ingredientes:");
		lblNewLabel_6.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 137, 161, 24);
		panel_entradas.add(lblNewLabel_6);

		JLabel lblTitulo = new JLabel("¡A COCINAR!");
		lblTitulo.setFont(new Font("Lato Black", Font.PLAIN, 35));
		lblTitulo.setBounds(10, 250, 224, 43);
		panel_entradas.add(lblTitulo);

		JLabel lblNewLabel_8 = new JLabel(
				"<html>Para hacer la salsa <b>Bechamel</b> derrite la mantequilla en una olla, agrega la harina y revuelve constantemente durante tres minutos, agrega constantemente la crema de leche y un poco de agua para evitar grumos.</html>");
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

		JLabel lblNewLabel_11 = new JLabel(
				"<html>Añade la sal y la nuez moscada, revolviendo constantemente para evitar que se pegue; cocina hasta que espese ligeramente.</html>");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(185, 395, 401, 74);
		panel_entradas.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("3.");
		lblNewLabel_12.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel_12.setBounds(20, 494, 37, 55);
		panel_entradas.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel(
				"<html>Calienta la mantequilla y dora ligeramente el jamón. Añade la pasta previamente cocida y escurrida, la salsa bechamel y mezcla suavemente. Cocina por 2 minutos a fuego medio y <b>¡Disfruta!</b></html>");
		lblNewLabel_13.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(67, 480, 401, 74);
		panel_entradas.add(lblNewLabel_13);

		JLabel lblutensil = new JLabel("Utensilios:");
		lblutensil.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensil.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensil.setBounds(328, 11, 317, 24);
		panel_entradas.add(lblutensilios);

		JLabel lblutl1 = new JLabel("     Licuadora");
		lblutl1.setFont(new Font("Lato", Font.ITALIC, 15));
		lblutl1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/blender.png")));
		lblutl1.setBounds(428, 50, 117, 36);
		panel_entradas.add(lbllicuadora);

		JCheckBox chckbx1 = new JCheckBox("60gr de Mantequilla");
		chckbx1.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1.setBackground(new Color(158, 193, 163));
		chckbx1.setBounds(10, 168, 162, 23);
		panel_entradas.add(chckbx1);

		JLabel lblttl = new JLabel("Ingredientes:");
		lblttl.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblttl.setBounds(10, 137, 161, 24);
		panel_entradas.add(lblNewLabel_6);

		JCheckBox chckbx2 = new JCheckBox("60gr de Harina trigo ");
		chckbx2.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2.setBackground(new Color(158, 193, 163));
		chckbx2.setBounds(10, 194, 162, 23);
		panel_entradas.add(chckbx2);

		JCheckBox chckbx3 = new JCheckBox("Crema de Leche");
		chckbx3.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx3.setBackground(new Color(158, 193, 163));
		chckbx3.setBounds(10, 220, 162, 23);
		panel_entradas.add(chckbx3);

		JCheckBox chckbx4 = new JCheckBox("1 1/4 Tazas de agua");
		chckbx4.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx4.setBackground(new Color(158, 193, 163));
		chckbx4.setBounds(174, 168, 162, 23);
		panel_entradas.add(chckbx4);

		JCheckBox chckbx5 = new JCheckBox("1/2 Cucharada de sal");
		chckbx5.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx5.setBackground(new Color(158, 193, 163));
		chckbx5.setBounds(174, 200, 162, 23);
		panel_entradas.add(chckbx5);

		JCheckBox chckbx6 = new JCheckBox("Nuez moscada molida");
		chckbx6.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx6.setBackground(new Color(158, 193, 163));
		chckbx6.setBounds(174, 220, 162, 23);
		panel_entradas.add(chckbx6);

		JCheckBox chckbx7 = new JCheckBox("1 Cucharada de Mantequilla");
		chckbx7.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx7.setBackground(new Color(158, 193, 163));
		chckbx7.setBounds(338, 168, 162, 23);
		panel_entradas.add(chckbx7);

		JCheckBox chckbx8 = new JCheckBox("Jamon cortado en cubos");
		chckbx8.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx8.setBackground(new Color(158, 193, 163));
		chckbx8.setBounds(338, 194, 162, 23);
		panel_entradas.add(chckbx8);

		JCheckBox chckbx9 = new JCheckBox("200gr Pasta Fusilli");
		chckbx9.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx9.setBackground(new Color(158, 193, 163));
		chckbx9.setBounds(338, 220, 162, 23);
		panel_entradas.add(chckbx9);

		JPanel panel_fuerte = new JPanel();
		panel_fuerte.setBackground(new Color(158, 193, 163));
		tabstest.addTab("", null, panel_fuerte, null);
		panel_fuerte.setLayout(null);
		panel_fuerte.setBounds(100, 100, 851, 800);

		JLabel lblRecipeName1 = new JLabel("<html>Pechuga Rellena con Jamón y Queso</html>");
		lblRecipeName1.setForeground(new Color(64, 0, 64));
		lblRecipeName1.setFont(new Font("Lato Semibold", Font.PLAIN, 25));
		lblRecipeName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName1.setBounds(326, 9, 319, 62);
		panel_fuerte.add(lblRecipeName1);

		JLabel lblimg1 = new JLabel("");
		lblimg1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnFuerte.jpg")));
		lblimg1.setBounds(10, 11, 310, 115);
		panel_fuerte.add(lblimg1);

		JLabel lblNewLabel1_6 = new JLabel("Ingredientes:");
		lblNewLabel1_6.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblNewLabel1_6.setBounds(10, 133, 161, 24);
		panel_fuerte.add(lblNewLabel1_6);

		JLabel lblTitulo1 = new JLabel("¡A COCINAR!");
		lblTitulo1.setFont(new Font("Lato Black", Font.PLAIN, 30));
		lblTitulo1.setBounds(10, 229, 224, 43);
		panel_fuerte.add(lblTitulo1);

		JLabel lblNewLabel1_8 = new JLabel(
				"<html>Rellena las milanesas de pollo con el jamón y el queso tipo manchego. Enrolla para cerrar la milanesa.</html>");
		lblNewLabel1_8.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel1_8.setBounds(68, 268, 445, 55);
		panel_fuerte.add(lblNewLabel1_8);

		JLabel lblNewLabel1_9 = new JLabel("1.");
		lblNewLabel1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1_9.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel1_9.setBounds(21, 268, 37, 55);
		panel_fuerte.add(lblNewLabel1_9);

		JLabel lblNewLabel1_10 = new JLabel("2.");
		lblNewLabel1_10.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel1_10.setBounds(596, 332, 37, 55);
		panel_fuerte.add(lblNewLabel1_10);

		JLabel lblNewLabel1_11 = new JLabel(
				"<html>Abre el sazonador con Finas Hierbas; coloca un rollo de pechuga, cierra y presiona ligeramente para que se impregnen las especias.</html>");
		lblNewLabel1_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel1_11.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel1_11.setBounds(228, 322, 370, 74);
		panel_fuerte.add(lblNewLabel1_11);

		JLabel lblNewLabel1_12 = new JLabel("3.");
		lblNewLabel1_12.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel1_12.setBounds(22, 419, 37, 55);
		panel_fuerte.add(lblNewLabel1_12);

		JLabel lblNewLabel1_13 = new JLabel(
				"<html>Colócala en una sartén sin aceite, precalentada a fuego bajo durante 1 minuto, tapa y cocina a fuego bajo de 7 a 8 minutos por cada lado o hasta que esté bien cocida. Retira la hoja y repite el procedimiento con el resto de las pechugas. Ofrece al momento.</html>");
		lblNewLabel1_13.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel1_13.setBounds(69, 407, 464, 74);
		panel_fuerte.add(lblNewLabel1_13);

		JLabel lblutensil1 = new JLabel("Utensilios:");
		lblutensil1.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensil1.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensil1.setBounds(328, 11, 317, 24);

		JLabel lblutl1_1 = new JLabel("     Licuadora");
		lblutl1_1.setFont(new Font("Lato", Font.ITALIC, 15));
		lblutl1_1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/blender.png")));
		lblutl1_1.setBounds(428, 50, 117, 36);

		JCheckBox chckbx1_1 = new JCheckBox("4 Milanesas de pollo ");
		chckbx1_1.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1_1.setBackground(new Color(158, 193, 163));
		chckbx1_1.setBounds(12, 161, 127, 23);
		panel_fuerte.add(chckbx1_1);

		JLabel lblttl1 = new JLabel("Ingredientes:");
		lblttl1.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblttl1.setBounds(10, 137, 162, 24);
		panel_fuerte.add(lblNewLabel1_6);

		JCheckBox chckbx1_2 = new JCheckBox("4 Rebanadas de jamón de pavo");
		chckbx1_2.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1_2.setBackground(new Color(158, 193, 163));
		chckbx1_2.setBounds(12, 186, 173, 23);
		panel_fuerte.add(chckbx1_2);

		JCheckBox chckbx1_3 = new JCheckBox("1 Sobre Hojas Sazonador con Finas Hierbas");
		chckbx1_3.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1_3.setBackground(new Color(158, 193, 163));
		chckbx1_3.setBounds(205, 187, 233, 23);
		panel_fuerte.add(chckbx1_3);

		JCheckBox chckbx1_4 = new JCheckBox("4 Rebanadas de queso tipo manchego rallado ");
		chckbx1_4.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx1_4.setBackground(new Color(158, 193, 163));
		chckbx1_4.setBounds(205, 161, 245, 23);
		panel_fuerte.add(chckbx1_4);

		JLabel lblutensilios_1 = new JLabel("Utensilios:");
		lblutensilios_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensilios_1.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensilios_1.setBounds(491, 65, 136, 24);
		panel_fuerte.add(lblutensilios_1);

		JLabel lblTablaDeCortar = new JLabel("Tabla de corte");
		lblTablaDeCortar.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/tabla.png")));
		lblTablaDeCortar.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblTablaDeCortar.setBounds(487, 90, 143, 36);
		panel_fuerte.add(lblTablaDeCortar);

		JLabel lblSarten_1 = new JLabel("Sartén");
		lblSarten_1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/sarten.png")));
		lblSarten_1.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblSarten_1.setBounds(491, 160, 117, 36);
		panel_fuerte.add(lblSarten_1);

		JLabel lbllicuadora_1_1 = new JLabel("     Espatula");
		lbllicuadora_1_1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/Espatula.png")));
		lbllicuadora_1_1.setFont(new Font("Dialog", Font.ITALIC, 15));
		lbllicuadora_1_1.setBounds(497, 128, 106, 35);
		panel_fuerte.add(lbllicuadora_1_1);

		JLabel lblNewLabel1_11_1 = new JLabel(
				"<html>Retira la hoja, sirve en un plato con verduras y <b>¡disfruta!</b></html>");
		lblNewLabel1_11_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel1_11_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel1_11_1.setBounds(262, 514, 365, 20);
		panel_fuerte.add(lblNewLabel1_11_1);

		JPanel panel_postres = new JPanel();
		panel_postres.setBackground(new Color(158, 193, 163));
		tabstest.addTab("", null, panel_postres, null);
		panel_postres.setLayout(null);

		JLabel lblRecipeName2 = new JLabel("<html>Pie de limón con galleta de chocolate</html>");
		lblRecipeName2.setForeground(new Color(64, 0, 64));
		lblRecipeName2.setFont(new Font("Lato Semibold", Font.PLAIN, 25));
		lblRecipeName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName2.setBounds(330, 11, 268, 55);
		panel_postres.add(lblRecipeName2);

		JLabel lblimg2 = new JLabel("New label");
		lblimg2.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/btnPostre.png")));
		lblimg2.setBounds(10, 11, 310, 115);
		panel_postres.add(lblimg2);

		JLabel lblNewLabel2_6 = new JLabel("Ingredientes:");
		lblNewLabel2_6.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblNewLabel2_6.setBounds(10, 137, 161, 24);
		panel_postres.add(lblNewLabel2_6);

		JLabel lblTitulo2 = new JLabel("¡A COCINAR!");
		lblTitulo2.setFont(new Font("Lato Black", Font.PLAIN, 35));
		lblTitulo2.setBounds(10, 250, 224, 43);
		panel_postres.add(lblTitulo2);

		JLabel lblNewLabel2_8 = new JLabel(
				"<html>Para la base, mezcla las galletas con la mantequilla hasta formar una pasta, cubre un molde para pay y refrigera por 15 minutos.</html>");
		lblNewLabel2_8.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel2_8.setBounds(67, 311, 401, 74);
		panel_postres.add(lblNewLabel2_8);

		JLabel lblNewLabel2_9 = new JLabel("1.");
		lblNewLabel2_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2_9.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel2_9.setBounds(20, 313, 37, 55);
		panel_postres.add(lblNewLabel2_9);

		JLabel lblNewLabel2_10 = new JLabel("2.");
		lblNewLabel2_10.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel2_10.setBounds(596, 396, 37, 55);
		panel_postres.add(lblNewLabel2_10);

		JLabel lblNewLabel2_11 = new JLabel(
				"<html>Para el relleno, licúa la Leche Evaporada con la Leche Condensada y agrega poco a poco el jugo de limón.</html>");
		lblNewLabel2_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel2_11.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel2_11.setBounds(231, 396, 355, 55);
		panel_postres.add(lblNewLabel2_11);

		JLabel lblNewLabel2_12 = new JLabel("3.");
		lblNewLabel2_12.setFont(new Font("Lato Black", Font.PLAIN, 45));
		lblNewLabel2_12.setBounds(20, 494, 37, 55);
		panel_postres.add(lblNewLabel2_12);

		JLabel lblNewLabel2_13 = new JLabel(
				"<html>Vierte sobre la base de galleta y refrigera hasta que cuaje por completo. Decora con rodajas y ralladura de limón; ofrece.</b></html>");
		lblNewLabel2_13.setFont(new Font("Lato", Font.PLAIN, 15));
		lblNewLabel2_13.setBounds(67, 480, 401, 74);
		panel_postres.add(lblNewLabel2_13);

		JLabel lblutensil2 = new JLabel("Utensilios:");
		lblutensil2.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblutensil2.setHorizontalAlignment(SwingConstants.CENTER);
		lblutensil2.setBounds(328, 11, 317, 24);

		JLabel lblutl2_1 = new JLabel("     Licuadora");
		lblutl2_1.setFont(new Font("Lato", Font.ITALIC, 15));
		lblutl2_1.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/blender.png")));
		lblutl2_1.setBounds(428, 50, 117, 36);

		JCheckBox chckbx2_1 = new JCheckBox("34 Galletas de chocolate con relleno molidas");
		chckbx2_1.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_1.setBackground(new Color(158, 193, 163));
		chckbx2_1.setBounds(10, 168, 241, 23);
		panel_postres.add(chckbx2_1);

		JLabel lblttl2 = new JLabel("Ingredientes:");
		lblttl2.setFont(new Font("Lato Black", Font.PLAIN, 15));
		lblttl2.setBounds(10, 137, 161, 24);
		panel_postres.add(lblNewLabel2_6);

		JCheckBox chckbx2_2 = new JCheckBox("45gr de Mantequilla");
		chckbx2_2.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_2.setBackground(new Color(158, 193, 163));
		chckbx2_2.setBounds(10, 194, 123, 23);
		panel_postres.add(chckbx2_2);

		JCheckBox chckbx2_3 = new JCheckBox("1 Lata de Leche Evaporada");
		chckbx2_3.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_3.setBackground(new Color(158, 193, 163));
		chckbx2_3.setBounds(10, 220, 153, 23);
		panel_postres.add(chckbx2_3);

		JCheckBox chckbx2_4 = new JCheckBox("1 Lata de Leche Condensada");
		chckbx2_4.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_4.setBackground(new Color(158, 193, 163));
		chckbx2_4.setBounds(294, 168, 209, 23);
		panel_postres.add(chckbx2_4);

		JCheckBox chckbx2_5 = new JCheckBox("1/4 Taza de Jugo de limón colado");
		chckbx2_5.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_5.setBackground(new Color(158, 193, 163));
		chckbx2_5.setBounds(294, 194, 209, 23);
		panel_postres.add(chckbx2_5);

		JCheckBox chckbx2_6 = new JCheckBox("Nuez moscada molida");
		chckbx2_6.setFont(new Font("Lato", Font.PLAIN, 11));
		chckbx2_6.setBackground(new Color(158, 193, 163));
		chckbx2_6.setBounds(294, 220, 209, 23);
		panel_postres.add(chckbx2_6);

		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(new Color(112, 169, 161));
		panelbotones.setBounds(0, 191, 150, 409);
		panel.add(panelbotones);
		panelbotones.setLayout(null);
		
		//Pestaña de busqueda de recetas
				JPanel panelFilters = new JPanel();
				panelFilters.setBackground(new Color(158, 193, 163));
				tabstest.addTab("", null, panelFilters, null);
				panelFilters.setLayout(null);

				JLabel lbltitulobuscar = new JLabel("<html>¿Deseas buscar alguna receta?</html>");
				lbltitulobuscar.setFont(new Font("Lato Heavy", Font.PLAIN, 25));
				lbltitulobuscar.setBounds(10, 11, 180, 62);
				panelFilters.add(lbltitulobuscar);

				//Area de texto para buscar por nombre
				JTextArea taNombre = new JTextArea();
				taNombre.setBackground(new Color(112, 169, 161));
				taNombre.setWrapStyleWord(true);
				taNombre.setLineWrap(true);
				taNombre.setEditable(true);
				taNombre.setBounds(287, 38, 250, 22);
				panelFilters.add(taNombre);

				//Area de texto donde saldrá el tiempo guardado en la base de datos
				JTextArea taTiempo = new JTextArea();
				taTiempo.setBackground(new Color(112, 169, 161));
				taTiempo.setWrapStyleWord(true);
				taTiempo.setLineWrap(true);
				taTiempo.setEditable(false);
				taTiempo.setBounds(10, 196, 250, 22);
				panelFilters.add(taTiempo);

				//Area de texto donde saldrá el tipo de receta guardado en la base de datos
				JTextArea taTipoR = new JTextArea();
				taTipoR.setBackground(new Color(112, 169, 161));
				taTipoR.setWrapStyleWord(true);
				taTipoR.setLineWrap(true);
				taTipoR.setEditable(false);
				taTipoR.setBounds(10, 252, 250, 22);
				panelFilters.add(taTipoR);

				JScrollPane spIngrediente = new JScrollPane();
				spIngrediente.setBounds(10, 301, 250, 64);
				panelFilters.add(spIngrediente);

				//Area de texto donde saldrán los ingredientes guardados en la base de datos
				JTextArea taIngrediente = new JTextArea();
				taIngrediente.setBackground(new Color(112, 169, 161));
				spIngrediente.setViewportView(taIngrediente);

				JScrollPane spUtensilio = new JScrollPane();
				spUtensilio.setBounds(334, 190, 296, 80);
				panelFilters.add(spUtensilio);

				//Area de texto donde saldrán los utensilios guardados en la base de datos
				JTextArea taUtensilio = new JTextArea();
				taUtensilio.setBackground(new Color(112, 169, 161));
				spUtensilio.setViewportView(taUtensilio);

				JScrollPane spInstructions = new JScrollPane();
				spInstructions.setBounds(334, 300, 293, 118);
				panelFilters.add(spInstructions);

				//Area de texto donde saldrán las instrucciones guardadas en la base de datos
				JTextArea taInstructions = new JTextArea();
				taInstructions.setBackground(new Color(112, 169, 161));
				spInstructions.setViewportView(taInstructions);

				JLabel lblNombre_1 = new JLabel("Nombre de la receta:");
				lblNombre_1.setForeground(Color.BLACK);
				lblNombre_1.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblNombre_1.setBounds(337, 23, 158, 14);
				panelFilters.add(lblNombre_1);
				
				JComboBox<String> cbTipo_1 = new JComboBox<String>();
				cbTipo_1.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Entrada", "Plato principal", "Postre"}));
				cbTipo_1.setForeground(Color.WHITE);
				cbTipo_1.setFont(new Font("Dialog", Font.PLAIN, 12));
				cbTipo_1.setBackground(new Color(112, 169, 161));
				cbTipo_1.setBounds(316, 100, 179, 22);
				panelFilters.add(cbTipo_1);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 92, 250, 40);
				panelFilters.add(scrollPane);
				
				JTextArea taNombreB = new JTextArea();
				scrollPane.setViewportView(taNombreB);
				taNombreB.setWrapStyleWord(true);
				taNombreB.setLineWrap(true);
				taNombreB.setEditable(false);
				taNombreB.setBackground(new Color(112, 169, 161));



				//Boton que busca la receta según el nombre escrito en el area de texto
				JButton btnBuscarRecetas = new JButton("Buscar Recetas");
				btnBuscarRecetas.setForeground(new Color(255, 255, 255));
				btnBuscarRecetas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Conexion a la base de datos
						try (Connection conexion = conectar.conectar();) {
							//Busqueda de los elementos en la base de datos
							
							
							 String query = "SELECT nombre FROM recetas WHERE tipo = ? AND visibilidad = 1";
			                    try (PreparedStatement statement = conexion.prepareStatement(query)) {
			                        statement.setString(1, (String) cbTipo_1.getSelectedItem()); // Establecer los parámetros en la consulta segun el tipo
			                        try (ResultSet resultSet = statement.executeQuery()) {
			                        	
			                        	String nombresRecetas = "";
			                        	while (resultSet.next()) {
			                        	    String nombre = resultSet.getString("nombre");
			                        	    nombresRecetas = nombresRecetas.concat(nombre).concat("\n");
			                        	}
			                        	taNombreB.setText(nombresRecetas);
			                             
		     	                        }
		     	                    }
						
			                    
			                    query = "SELECT duracion ,ingredientes , tipo, utensilios , instrucciones FROM recetas WHERE nombre = ? AND visibilidad = 1";
								try (PreparedStatement statement = conexion.prepareStatement(query)) {
									statement.setString(1, taNombre.getText()); // Establecer los parámetros en la consulta
									try (ResultSet resultSet = statement.executeQuery()) {
										if  (resultSet.next()) {
											String duracion = String.valueOf(resultSet.getInt("duracion"));
											String ingrediente = resultSet.getString("ingredientes");
											String tipo = resultSet.getString("tipo");
											String utensilio = resultSet.getString("utensilios");
											String instrucciones = resultSet.getString("instrucciones");

											// Establecer la misma información en cada JTextArea
											taTiempo.setText(duracion);
											taIngrediente.setText(ingrediente);
											taTipoR.setText(tipo);
											taUtensilio.setText(utensilio);
											taInstructions.setText(instrucciones);
											taNombreB.setText("");
											cbTipo_1.setSelectedItem("");
										} else if (cbTipo_1.getSelectedItem() == "" && taNombre.getText().isEmpty()) { // Debes llamar a next() antes de acceder a los datos
											// Si no hay resultados, mostramos un mensaje
											JOptionPane.showMessageDialog(null,
													"No se encontraron recetas para el nombre proporcionado.", "Resultado",
													JOptionPane.INFORMATION_MESSAGE);
										}
									}

								}
						} catch (SQLException es) {
							System.out.println("Error al conectar con la base de datos: " + es.getMessage());
						}
					}
				});
				btnBuscarRecetas.setBackground(new Color(31, 51, 61));
				btnBuscarRecetas.setBorder(null);
				btnBuscarRecetas.setFont(new Font("Lato Medium", Font.PLAIN, 15));
				btnBuscarRecetas.setBounds(516, 92, 114, 30);
				panelFilters.add(btnBuscarRecetas);

				JLabel lblDownside = new JLabel("");
				lblDownside.setIcon(new ImageIcon(Menu.class.getResource("/IMGS/downside.png")));
				lblDownside.setBounds(0, 350, 645, 225);
				panelFilters.add(lblDownside);

				JLabel lblaviso = new JLabel("Aqui saldrá tu receta:");
				lblaviso.setForeground(Color.BLACK);
				lblaviso.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblaviso.setBounds(229, 142, 149, 19);
				panelFilters.add(lblaviso);

				JLabel lblTiempo = new JLabel("Tiempo:");
				lblTiempo.setForeground(Color.BLACK);
				lblTiempo.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblTiempo.setBounds(10, 176, 56, 19);
				panelFilters.add(lblTiempo);

				JLabel lblTipo = new JLabel("Tipo de receta:");
				lblTipo.setForeground(Color.BLACK);
				lblTipo.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblTipo.setBounds(10, 234, 103, 19);
				panelFilters.add(lblTipo);

				JLabel lblIng = new JLabel("Ingredientes:");
				lblIng.setForeground(Color.BLACK);
				lblIng.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblIng.setBounds(10, 283, 91, 19);
				panelFilters.add(lblIng);

				JLabel lblUtensilio = new JLabel("Utensilios:");
				lblUtensilio.setForeground(Color.BLACK);
				lblUtensilio.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblUtensilio.setBounds(334, 171, 73, 19);
				panelFilters.add(lblUtensilio);

				JLabel lblInstruc = new JLabel("Instrucciones:");
				lblInstruc.setForeground(Color.BLACK);
				lblInstruc.setFont(new Font("Lato Heavy", Font.PLAIN, 15));
				lblInstruc.setBounds(334, 281, 97, 19);
				panelFilters.add(lblInstruc);
				
				
				
				JLabel lblFiltroTipo = new JLabel("Tipo de receta:");
				lblFiltroTipo.setForeground(Color.BLACK);
				lblFiltroTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
				lblFiltroTipo.setBounds(334, 76, 158, 14);
				panelFilters.add(lblFiltroTipo);
				
				
		JButton btnppal = new JButton("Home");
		btnppal.setFocusable(false);
		btnppal.setForeground(new Color(255, 255, 255));
		btnppal.setFont(new Font("Lato Black", Font.PLAIN, 20));
		btnppal.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/Home.png")));
		btnppal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnppal.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnppal.setBackground(new Color(31, 54, 61));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btnppal.setBackground(new Color(165, 134, 227));
				tabstest.setSelectedIndex(0);
			}
		});
		btnppal.setBackground(new Color(31, 54, 61));
		btnppal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnppal.setBounds(0, 0, 150, 69);
		panelbotones.add(btnppal);
		btnppal.setBorderPainted(false);
		btnppal.setBorder(null);

		JButton btninv = new JButton("<html>Añadir Receta</html>");
		btninv.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/Recipes.png")));
		btninv.setFocusable(false);
		btninv.setBackground(new Color(31, 54, 61));
		btninv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btninv.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btninv.setBackground(new Color(31, 54, 61));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Debes estar registrad@ para ver esta pagina.");
			}
		});
		btninv.setBorderPainted(false);
		btninv.setBorder(null);
		btninv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btninv.setForeground(new Color(255, 255, 255));
		btninv.setFont(new Font("Lato Black", Font.PLAIN, 15));
		btninv.setBounds(0, 69, 150, 69);
		panelbotones.add(btninv);

		JButton btnbuscar = new JButton("Buscar Receta");
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnbuscar.setBackground(new Color(64, 121, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnbuscar.setBackground(new Color(31, 54, 61));
			}
		});
		btnbuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabstest.setSelectedIndex(4);
				JOptionPane.showMessageDialog(null, "no podras ver todas las recetas disponibles si no estas registrado");
			}
		});
		btnbuscar.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/lupa.png")));
		btnbuscar.setForeground(new Color(255, 255, 255));
		btnbuscar.setFont(new Font("Lato Black", Font.PLAIN, 15));
		btnbuscar.setBackground(new Color(31, 54, 61));
		btnbuscar.setBorder(null);
		btnbuscar.setBounds(0, 138, 150, 69);
		panelbotones.add(btnbuscar);
		
		JButton btnIngReg = new JButton("Ingresar o Registrarse");
		btnIngReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIngReg.setBackground(new Color(64, 121, 140));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIngReg.setBackground(new Color(31, 51, 61));
			}
		});
		btnIngReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login login = new login();
				login.setVisible(true);
				dispose();
			}
		});
		btnIngReg.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/Login.png")));
		btnIngReg.setForeground(new Color(255, 255, 255));
		btnIngReg.setFont(new Font("Lato Black", Font.PLAIN, 10));
		btnIngReg.setBackground(new Color(31, 51, 61));
		btnIngReg.setBorder(null);
		btnIngReg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngReg.setBounds(0, 378, 150, 31);
		panelbotones.add(btnIngReg);

		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(Invitados.class.getResource("/IMGS/LogoN.png")));
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
				btnexit.setBackground(new Color(112, 169, 161));
				btnexit.setForeground(new Color(0, 0, 0));
			}
		});
		btnexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnexit.setBackground(new Color(112, 169, 161));
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