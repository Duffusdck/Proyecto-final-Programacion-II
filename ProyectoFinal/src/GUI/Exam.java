package GUI;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Exam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texttitulo;

	

	/**
	 * Create the frame.
	 */
	public Exam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(373, 11, 484, 415);
		contentPane.add(tabbedPane);

		texttitulo = new JTextField();
		texttitulo.setBounds(73, 57, 259, 20);
		contentPane.add(texttitulo);
		texttitulo.setColumns(10);

		JTextArea textinfo = new JTextArea();
		textinfo.setBounds(73, 86, 259, 149);
		contentPane.add(textinfo);

		JDialog dialog = new JDialog((Frame) null, "Nueva Pestaña", true);
		dialog.setSize(400, 300);
		dialog.getContentPane().setLayout(new BorderLayout());

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = texttitulo.getText();
				String contenido = textinfo.getText();

				if (titulo.isEmpty() || contenido.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese tanto el título como el contenido.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JPanel panelContenido = new JPanel();
				panelContenido.setLayout(new BorderLayout());
				JTextArea areaTexto = new JTextArea(contenido);
				areaTexto.setEditable(false); // Hacer que el contenido no sea editable
				areaTexto.setLineWrap(true); // Habilitar ajuste de línea
				areaTexto.setWrapStyleWord(true); // Ajuste por palabra completa
				panelContenido.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

				// Agregar una nueva pestaña al JTabbedPane
				tabbedPane.addTab(titulo, panelContenido);

				// Limpiar los campos de texto
				texttitulo.setText("");
				textinfo.setText("");
			}
		});
		btnNewButton.setBounds(163, 297, 89, 23);
		contentPane.add(btnNewButton);

	}
}
