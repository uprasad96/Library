import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class javaconnect {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/MAIN";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "sqlisfun";
	static Connection conn=null;
	
	public static Connection estConn(){
		
		  try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      return conn;
		   }catch(Exception e){
			  JOptionPane.showMessageDialog(null, e);
			  return null;
		   }
		  
	}
}