package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SupUpdate extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Updated.jsp");
        PrintWriter out=null;
        try
		{
			out= res.getWriter();
			String supid=req.getParameter("supid");
    	    String gen=req.getParameter("gen");
			String sname=req.getParameter("sname");
			String address=req.getParameter("address");
			String phno=req.getParameter("phno");
			String email=req.getParameter("email");
			String rem=req.getParameter("rem");
			String scat=req.getParameter("scat");


			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;

		    String 	strQry="update supplier_info set name='"+sname+"',gen='"+gen  +"',address='"+address+"',phno=" + phno + " ,email='"+email +"',remarks='"+rem+"',scat='" + scat + "' where sup_id='"+ supid + "' ";

			int inserted=CBean.executeUpdate(strQry);
   		    if(inserted==1)
			{
			      out.println("<html> <script> function check() { self.close(); opener.location='SupplierInfo.jsp';}</script><center><h1><b>Details Updated Successfully</b></h1></center></html>");
                  out.println("<center><input type=button value='Close' onclick='return check()'></center>");

		    }
		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
