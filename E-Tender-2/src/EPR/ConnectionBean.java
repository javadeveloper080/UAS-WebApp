package EPR;
import java.sql.*;

public class ConnectionBean
{
	private Connection connection;
	private Statement statement;
	/*private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String login="hr";
	private static final String password="hr";*/

	/*private static final String driver="org.hsqldb.jdbcDriver";
	private static final String dbURL="jdbc:hsqldb:hsql://localhost:9001";
	private static final String login="sa";
	private static final String password="";*/


	
		
		private static final String driver="org.postgresql.Driver";
	private static final String dbURL="jdbc:postgresql://localhost:5432/MS";
	private static final String login="postgres";
	private static final String password="password";


	public static void main(String[] args) {

		ConnectionBean CBean=new ConnectionBean();
		Connection con=CBean.getConnection();
		System.out.println("custrs");
		System.out.println(con);
		String loginName="1236";
		String Pwd="pwd";

		try {
			ResultSet custrs=CBean.executeQuery("select sup_id from supplier_info where sup_id='1235' and pwd='pwd'");
			System.out.println("custrs"+custrs);
			if(custrs.next())
			{


				String sup_id=custrs.getString(1);
				System.out.println("sup_id"+sup_id);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public ConnectionBean()
	{
		try
		{
			Class.forName(driver);
			connection=DriverManager.getConnection(dbURL,login,password);
			statement=connection.createStatement();

		}
		catch (ClassNotFoundException e)
		{
			System.err.println("ConnectionBean: driver unavailable");
			connection = null;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			connection = null;
		}



	}
	public Connection getConnection()
	{
		return connection;
	}

	public void commit() throws SQLException
	{
		connection.commit();
	}
	public void rollback() throws SQLException
	{
		connection.rollback();
	}



	public void setAutoCommit(boolean autoCommit) throws SQLException
	{
		connection.setAutoCommit(autoCommit );
	}



	public ResultSet executeQuery(String sql) throws SQLException
	{
		return statement.executeQuery(sql);
	}

	public int executeUpdate(String sql) throws SQLException
	{
		return statement.executeUpdate(sql);
	}
	public boolean execute(String sql) throws SQLException
	{
		return statement.execute(sql);
	}

	protected void finalize()
	{
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
		}
	}
}