package br.edu.ifpe.ads.arqsoft.repository.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgreSQL implements Database {

	private Connection connection;
	
	@Override
	public Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/arqsoft2024", "postgres", "ifpe");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
