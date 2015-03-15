package EPR;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ApplicationUtil;

public class EmpRegister extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9127062361236139275L;
	
	RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("Inserted.jsp");
		PrintWriter out=null;

		try
		{

			out= res.getWriter();

			String empid=req.getParameter("empid");
			String pwd=req.getParameter("pwd");
			String gen=req.getParameter("gen");
			String ename=req.getParameter("ename");
			String address=req.getParameter("address");
			String phno=req.getParameter("phno");
			String qlfy=req.getParameter("qlfy");
			String dob=req.getParameter("dob");
			if (dob!=null && dob.length()==11) {
				dob=ApplicationUtil.getFomatedSQLDate(dob);
			}
			String desg=req.getParameter("desg");
			String dept=req.getParameter("dept");
			
			ConnectionBean CBean=new ConnectionBean();
			
			int c_id=0;
			String 	strQry="insert into employee_info values('"+  empid +"','"+pwd+"','"+ename+"','"+gen  +"','" + phno + "' ,'"+address+"','"+qlfy+"','"+dob+"','" + desg + "','" + dept + "')";
			System.out.println("strQry:"+strQry);	
			
	int inserted=CBean.executeUpdate(strQry);
	inserted=1;
			if(inserted==1)
			{
				rd.forward(req, res);
			}
		}
		catch(Exception ex)
		{
			out.println("Error While Processidsdsdsdg" +ex);
		}


	}
}
