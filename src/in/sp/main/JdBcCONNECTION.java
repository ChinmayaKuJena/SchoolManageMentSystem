package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdBcCONNECTION {
	
	Connection con;
	Statement st;
	
	public JdBcCONNECTION() {
		// TODO Auto-generated constructor stub
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scms","root","root");
			st=con.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
