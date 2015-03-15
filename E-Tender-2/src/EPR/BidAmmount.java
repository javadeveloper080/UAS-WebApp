package EPR;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BidAmmount extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("SInserted.jsp");
        PrintWriter out=null;
        try
		{
			out= res.getWriter();

			String ittno=req.getParameter("ittno");
			String bamt=req.getParameter("bamt");
	        String supid=req.getParameter("supid");
			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;

			String 	strQry="update itt_details set sbidamt=" + bamt + " where ittno=" + ittno + " and sup_id='" + supid + "' ";

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
