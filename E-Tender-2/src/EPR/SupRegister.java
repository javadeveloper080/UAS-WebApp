package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SupRegister extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Inserted.jsp");
        PrintWriter out=null;
        try
		{

			out= res.getWriter();
			String supid=req.getParameter("supid");
    	    String pwd=req.getParameter("pwd");
			String gen=req.getParameter("gen");
			String sname=req.getParameter("sname");
			String address=req.getParameter("address");
			String phno=req.getParameter("phno");
			String email=req.getParameter("email");
			String rem=req.getParameter("rem");
			String scat=req.getParameter("scat");

			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;
		    String 	strQry="insert into supplier_info values('"+  supid +"','"+pwd+"','"+sname+"','"+gen  +"','"+address+"'," + phno + " ,'"+email +"','"+rem+"','" + scat + "')";
			int inserted=CBean.executeUpdate(strQry);
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
