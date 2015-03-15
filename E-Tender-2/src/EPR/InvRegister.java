package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InvRegister extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("PInserted.jsp");
        PrintWriter out=null;
        try
		{
			out= res.getWriter();
			
			String ittno=req.getParameter("ittno");
			String indno=req.getParameter("indno");
    	    String ittldt=req.getParameter("ittldt");
			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;
		    
			String 	strQry="insert into itt_master values("+  ittno +",sysdate,'"+indno+"','"+ ittldt +"','Pending'  )";

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
