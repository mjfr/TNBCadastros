package br.com.animefriends.tnbcadastros.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection connection;

	public void open() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String USER = "root";
		final String PASSWORD = "root132";

		String sql = "jdbc:mysql://localhost:3306/bookstore?useTimezone=true&serverTimezone=UTC";
		connection = DriverManager.getConnection(sql, USER, PASSWORD);
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}
}