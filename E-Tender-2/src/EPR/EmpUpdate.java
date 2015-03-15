package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmpUpdate extends HttpServlet
{
RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Updated.jsp");
PrintWriter out=null;

        try
		{

			out= res.getWriter();

			String empid=req.getParameter("empid");
    	    String gen=req.getParameter("gen");
			String ename=req.getParameter("ename");
			String address=req.getParameter("address");
			String phno=req.getParameter("phno");
			String qlfy=req.getParameter("qlfy");
			String dob=req.getParameter("dob");
            String desg=req.getParameter("desg");
            String dept=req.getParameter("dept");

			ConnectionBean CBean=new ConnectionBean();
			int c_id=0;
		String 	strQry="update employee_info set name='"+ename+"',gen='"+gen  +"',phno='" + phno + "',address='"+address+"',qlfy='"+qlfy+"',doj='"+dob+"',desg='" + desg + "',dept='" + dept + "' where emp_id='" + empid + "'";
			int inserted=CBean.executeUpdate(strQry);
   		    if(inserted==1)
			    {
			      out.println("<html> <script> function check() { self.close(); opener.location='EmployeeInfo.jsp';}</script><center><h1><b>Details Updated Successfully</b></h1></center></html>");
                  out.println("<center><input type=button value='Close' onclick='return check()'></center>");
				}
		}
		catch(Exception ex)
		{
              out.println("Error While Processing" +ex);
	    }


	}
}
