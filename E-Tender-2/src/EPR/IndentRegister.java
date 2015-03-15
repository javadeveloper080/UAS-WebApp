package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IndentRegister extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("EInserted.jsp");
        PrintWriter out=null;
        ResultSet rs=null;
        Statement stmt=null;
Statement stmt1=null;
Connection con=null;

        try
		{
			out= res.getWriter();
			String empid=req.getParameter("empid");
			System.out.println("Employee$$$$$$$"+empid);

			String indno=req.getParameter("indno");
            	String indt=req.getParameter("indt");
			String deldt=req.getParameter("deldt");
			String estrt=req.getParameter("estrt");
			ConnectionBean CBean=new ConnectionBean();
                  con=CBean.getConnection();
                  stmt=con.createStatement();
                  stmt1=con.createStatement();
			
   String 	strQry="insert into indent_master values('"+  indno +"','"+indt+"','"+empid+"','" + deldt + "','" + estrt + "','Pending'  )";




                int inserted=CBean.executeUpdate(strQry);



rs=stmt.executeQuery("select * from ind_items_tmp");
                 
                  while(rs.next())
                  {

System.out.println("EEError Inside");

                    int updated=stmt1.executeUpdate("insert into ind_items values(" + indno + "," +rs.getString(1) + "," + rs.getString(2) + " ) ");


                  }


int updated1=stmt.executeUpdate("delete from ind_items_tmp");


                int c_id=0;
		 
   		    if(inserted==1)
			{
			       rd.forward(req, res);
		    }
		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
