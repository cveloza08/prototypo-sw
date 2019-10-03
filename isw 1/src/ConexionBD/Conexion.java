package ConexionBD;

import java.sql.*;


//Hola mundo

import javax.swing.JOptionPane;

public  class Conexion {
	private static String bd = "INVENTARIO";
	private static String login = "root";
	private static String password = "12345678";
	private static String server = "PCDFL9";
	private static  Connection connection ;

	public Conexion() {
	}

	private void Conectar() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://" + server + ":" + "1433" + ";user=" + login
					+ ";password=" + password + ";databasename=" + bd;
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException | ClassNotFoundException  e) {
			JOptionPane.showMessageDialog(null, e.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public Connection getConnection() {
		if (connection==null){ this.Conectar(); } return connection;
	}

	public void desconectar() throws SQLException {
		connection.close();
	}
}