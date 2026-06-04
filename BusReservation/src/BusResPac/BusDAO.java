package BusResPac;

import java.sql.*;

public class BusDAO {
	public void getBusInfo() throws SQLException {
		String sql = "select * from Bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.println("Bus no : " + rs.getInt(1));
			if (rs.getInt(2) == 1) 
				System.out.println("Ac : yes");
			else 
				System.out.println("Ac : No");
			System.out.println("Capacity : "+rs.getInt(3));
		}
		

	}
	public int getCapacity(int id)throws SQLException {
		String sql="select capacity from bus where id ="+id;
		Connection con=DbConnection.getConnection();
		
		Statement st =con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt(1);
	}
}
