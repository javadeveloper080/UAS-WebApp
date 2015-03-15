package EPR;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcceptInvitation extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("PInserted.jsp");
        PrintWriter out=null;
        try
		{
			out= res.getWriter();

			String supid=req.getParameter("supid");
			String ittno=req.getParameter("ittno");

			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;

			String 	strQry="insert into itt_details(itt_no,sup_id) values("+  ittno +",'" + supid  +"')";

			int inserted=CBean.executeUpdate(strQry);
   		    if(inserted==1)
			{

			     out.println("<html> <script> function check() { self.close(); opener.location='InvTender.jsp';}</script><center><h1><b>Invitation Successfull Updated</b></h1></center></html>");
				 out.println("<center><input type=button value='Close' onclick='return check()'></center>");




		    }
		}
		catch(Exception ex)
		{
            out.println("Error While Processing" +ex);
	    }
	}
}
