package EPR;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import EPR.*;

public class CheckEmp extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
			PrintWriter out = response.getWriter();
         //   RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			try
			{


	        ConnectionBean CBean=new ConnectionBean();
            Connection con=CBean.getConnection();
			response.setContentType("text/html");
			String uid = request.getParameter("uid");
            String pwd = request.getParameter("pwd");
            System.out.println("user uid" +uid);
            System.out.println("pwd uid" +pwd);
            ResultSet custrs=CBean.executeQuery("select emp_id from employee_info where emp_id='" + uid + "' and pwd='" + pwd + "' ");
			if(!custrs.next())
			{
                out.println("Invalid Login Information");
			}
	    }
		catch(Exception e)
		{
			out.println("Invalid Login Information");
	    }

	}

}
