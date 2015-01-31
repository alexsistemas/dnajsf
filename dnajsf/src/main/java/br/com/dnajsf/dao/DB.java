package br.com.dnajsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "url=jdbc:postgresql://localhost:5432/";
	private static final String databaseName = "dnajsf";
	private static final String user = "postgres";
	private static final String pw = "mr7@bra@83";
	
	public Connection getConn() throws ClassNotFoundException, SQLException{
            Class.forName(driver);
            return DriverManager.getConnection(url.trim() + databaseName.trim(),user.trim(),pw.trim());
	}

}
