package context;
import java.sql.*;
public class DBContext {
    //attribute
	private final String userID = "sa";
	private final String password="binh09112001";
	private final String serverName = "localhost";
	private final String port = "1433";
	private final String dbName = "luanvan";
	//function
	public Connection getConnection() throws ClassNotFoundException, SQLException  {
		String url = "jdbc:sqlserver://"+serverName+":"+port+";databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID,password);
		
	}
	//ham main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBContext db = new DBContext();
		Connection conn = db.getConnection();
		System.out.println(conn);
		
		
		System.out.println(new DBContext().getConnection());
		
	}
}