package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ItemRegister extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Inserted.jsp");
        PrintWriter out=null;
        try
		{

			out= res.getWriter();
			String itmid=req.getParameter("itmid");
    	    String itmname=req.getParameter("itmname");
			String itdesc=req.getParameter("itdesc");
			String itspec=req.getParameter("itspec");
			String unts=req.getParameter("unts");
			String rts=req.getParameter("rts");

			String itcat=req.getParameter("itcat");

			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;
		      String 	strQry="insert into items_info values('"+  itmid +"','"+itmname+"','"+itdesc+"','"+itspec +"','"+unts+"'," + rts + ",'" + itcat + "' )";

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
