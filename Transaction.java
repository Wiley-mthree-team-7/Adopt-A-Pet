import java.sql.*;
import java.util.Date;

public class Transaction {
	String url;
	String userName;
	String password;
	Connection con;
	Statement stmnt;
	PreparedStatement ps;
	public Transaction() throws Exception
	{
		con = DriverManager.getConnection(UserJDBC.url,UserJDBC.user, UserJDBC.password);
	}
	
	public void addEntry(int user_id, int pet_id, int amount) throws SQLException
	{
		Date cdate = new Date();
		long time = cdate.getTime();
		Timestamp ts  = new Timestamp(time);
		String dt = ts.toString();
		String insert_data = "INSERT INTO TRANSACTION VALUES (DEFAULT, ?, ?, ?, ?)";
		ps = con.prepareStatement(insert_data);
		ps.setInt(1, user_id);
		ps.setInt(2, pet_id);
		ps.setString(3, dt);
		ps.setInt(4, amount);
		
		ps.executeUpdate();
	}
	
	public void getUserTransactions(int user_id) throws SQLException
	{
		String get_data = "select * from Transaction where User_id = ?";
		ps = con.prepareStatement(get_data);
		ps.setInt(1, user_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.format("%3d %3d %3d %20s %10d\n",rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			
		}
	}
	public static void main(String args[]) throws Exception
	{
		Transaction t = new Transaction();
		
		t.getUserTransactions(2);
	}

}
