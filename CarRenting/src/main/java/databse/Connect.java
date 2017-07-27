package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public static void function() throws SQLException {
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentingsystem","","");
		Statement stmt=con.createStatement();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
