package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	Connection conect = null;
	String url ="jdbc:postgresql://localhost:5432/sistemaOficina";
	String user = "postgres";
	String pass = "arsec021";
	
	
	public Connection getConnection() {
		if(conect == null) {
			try {
				conect = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conect;
		}else return conect;
	}
	
}
