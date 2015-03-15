package EPR;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveItem extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("EInserted.jsp");
		PrintWriter out=null;
		int inserted=0;
		ConnectionBean CBean=new ConnectionBean();
		try
		{

			out= res.getWriter();
			String qty=req.getParameter("qty");
			String itid=req.getParameter("itid");

			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;

			con=CBean.getConnection();
			stmt=con.createStatement();

			rs=stmt.executeQuery("select * from ind_items_tmp where item_id=" + itid + " ");
			if(rs.next())
			{
				out.println("Item Already Selected");

			}else
			{

				String 	strQry="insert into ind_items_tmp values("+itid+","+qty+")";
				int updated=stmt.executeUpdate(strQry);

			}

			rs.close();




		}
		catch(Exception ex)
		{
			out.println("Error While Processing" +ex);
		}
	}
}
