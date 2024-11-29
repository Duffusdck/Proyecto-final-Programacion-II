package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	//Creamos un m�todo constructor Privado dado que haremos uso de patron Singleton
		private Conexion() {	
		}
		
	// Lo primero creamos una variable en la cual vamos a guardar el estado de la
	// conexi�n a nuestra BD
	private static Connection conexion;

	// Creamos una variable para crear una sola instancia
	private static Conexion instancia;

	// Creamos las variables para poder conectarnos a la BD
	private static final String URL = "jdbc:mysql://localhost:3306/bd_prueba";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	// Creamos el m�todo para conectarnos a la base de datos
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			JOptionPane.showMessageDialog(null, "Conexi�n Exitosa!!");
			return conexion;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e);
		}
		return conexion;
	}
	
	//Creamos el m�todo para cerrar la conexi�n
	public void cerrarConexion() throws SQLException{
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se desconect� de la base de datos. ");
			
		}catch (Exception e1){
			JOptionPane.showMessageDialog(null, "Error: ");
			conexion.close();
		}finally {
			conexion.close();
		}
	}
	
	//Vamos a hacer uso del Patr�n Singleton para Optimizar la escritura del c�digo
	public static Conexion getInstance() {
		if (instancia==null) {
			instancia=new Conexion();
		}
		return instancia;
	}
}
