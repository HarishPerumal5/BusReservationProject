package BusResPac;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
		private static final String url="jdbc:mysql://localhost:3306/Busres";
		private static final String username="root";
		private static final String password="Socialexam@sql";
		
		public static Connection getConnection() throws SQLException{
			return DriverManager.getConnection(url,username,password);
		}
		

	}


