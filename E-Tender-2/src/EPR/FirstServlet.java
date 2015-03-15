package EPR;

 import javax.servlet.*;
 import java.io.*;
 public class FirstServlet extends GenericServlet
 {
	 public void init(ServletConfig sc) throws ServletException
	 {
		System.out.println("In Initalization part of Servlet ");
	 }
	 public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	 {
		 System.out.println("In Service Method of Servlet ...");
			PrintWriter pw=res.getWriter();

			pw.println("WELCOME TO FIRST SERVLET");
			pw.close();
	 }
 };





