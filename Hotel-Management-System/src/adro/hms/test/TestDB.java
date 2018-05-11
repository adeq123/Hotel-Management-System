package adro.hms.test;

import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		
		try {
			String query = "INSERT INTO guest VALUES ('7','Arnold','Norek','male','Passport','RFTasdasd9','888999777','Ciodrive 50', 'Standard 101', '3','2018-01-01') ";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system?useSSL=false","hmsUser", "hmsUser");
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("OK!"
					+ "");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
