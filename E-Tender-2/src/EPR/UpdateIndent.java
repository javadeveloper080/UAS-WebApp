package EPR;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateIndent extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("EInserted.jsp");
        PrintWriter out=null;
        try
		{
			out= res.getWriter();

			String indno=req.getParameter("indno");
    	    String indt=req.getParameter("indt");
			String deldt=req.getParameter("deldt");
			String estrt=req.getParameter("estrt");
			ConnectionBean CBean=new ConnectionBean();

			int c_id=0;
		    String 	strQry="update indent_master set inddate='"+indt+"',delv_date='" + deldt + "',est_rate='" + estrt + "' where ind_no='" + indno + "' ";
			int inserted=CBean.executeUpdate(strQry);
   		    if(inserted==1)
			{

			        out.println("<html> <script> function check() { self.close(); opener.location='IndentStatus.jsp';}</script><center><h1><b>Details Updated Successfully</b></h1></center></html>");
				    out.println("<center><input type=button value='Close' onclick='return check()'></center>");


		    }

		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
