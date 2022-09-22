package dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;


public class studentconn {
         
	      public static Connection createConnection() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	}

