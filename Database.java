/*import java.sql.*;

import com.mysql.jdbc.Connection;

public class Database {
	Connection con=null;
	Statement stmt;
	
	public void executeQuery(){
		try{  
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/saipyeru_db","saipyeru","saipyeru");  
			System.out.println("Database Connected");
			stmt=(Statement)con.createStatement();
			
	}
	catch(SQLException e){
		e.printStackTrace();
	}
		
}
}*/