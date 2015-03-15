package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ItemUpdate extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
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

		    String 	strQry="Update items_info set name='"+itmname+"',itemdesc='"+itdesc+"',itemspec='"+itspec +"',units='"+unts+"',rate=" + rts + " ,itcat='" + itcat + "' where item_id='" + itmid + "' ";

			int inserted=CBean.executeUpdate(strQry);
   		    if(inserted==1)
			{
			        out.println("<html> <script> function check() { self.close(); opener.location='ItemsInfo.jsp';}</script><center><h1><b>Details Updated Successfully</b></h1></center></html>");
                  out.println("<center><input type=button value='Close' onclick='return check()'></center>");

		    }
		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
