package EPR;

import EPR.ConnectionBean;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SavePas extends HttpServlet
{
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
			String indno=req.getParameter("indno");
			String qty=req.getParameter("qty");
     	    	    String itid=req.getParameter("itid");

       Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;

            con=CBean.getConnection();
			stmt=con.createStatement();

rs=stmt.executeQuery("select * from ind_items where ind_no=" + indno + " and item_id=" + itid );
if(rs.next())
{
out.println("Item Already Selected");

}else
{

String 	strQry="insert into ind_items values("+  indno +","+itid+","+qty+")";
ResultSet updated=stmt.executeQuery(strQry);

}

rs.close();
    



		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
