package BusResPac;
import java.sql.*;
import java.util.Date;

public class BookingDAO {
	public int getBookedCount(int busno,Date date)throws SQLException {
		String sql="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, busno);
		pst.setDate(2, sqldate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
		
		
	}
	public void addBooking(Booking booking)throws SQLException {
		String sql="insert into booking values(?,?,?)";
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3,sqldate);
		pst.executeUpdate();
		}

}
