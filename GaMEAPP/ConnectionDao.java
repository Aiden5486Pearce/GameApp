package GaMEAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton class
public class ConnectionDao {

	 public static ConnectionDao instance;
	 private Connection connection;
	    private String url = "jdbc:mysql://localhost/mydb";
	    private String username = "root";
	    private String password = "";

	    private ConnectionDao() throws SQLException{
	    	
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
	            this.connection = DriverManager.getConnection(url, username, password);
	         }catch (ClassNotFoundException ex) {
	             System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	         }
	    }
	    public Connection getConnection() {
	        return connection;
	    }
	    

	    
	    public static ConnectionDao getInstance() {
            try {

	    	if(instance == null) {
					instance = new ConnectionDao();
				
	         } else if (instance.getConnection().isClosed()) {
	             instance = new ConnectionDao();
	         }
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	    return instance;

      	    
	    }

}

	 	 
