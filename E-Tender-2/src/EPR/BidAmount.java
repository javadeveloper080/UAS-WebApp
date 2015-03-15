package EPR;

import EPR.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class BidAmount extends HttpServlet
{
    RequestDispatcher rd;
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		RequestDispatcher rd=req.getRequestDispatcher("SInserted.jsp");
        PrintWriter out=null;

        try
		{

ConnectionBean CBean=new ConnectionBean();
Connection con=null;
con=CBean.getConnection();
Statement stmt=con.createStatement();
Statement stmt1=con.createStatement();

			out= res.getWriter();

			String ittno=req.getParameter("ittno");
      	      String supid=req.getParameter("supid");
String indno1="";

int  bamt=0;
ResultSet rs1=null;
String itemid="";
String qty="";


rs1=stmt1.executeQuery("select ind_no from itt_master where itt_no=" + ittno +" ");
if(rs1.next())
{
  indno1=rs1.getString(1);
}
rs1.close();

System.out.println("The Indent Number"+indno1);




rs1=stmt1.executeQuery("select it.item_id,it.qty  from ind_items it where it.ind_no=(select ind_no from itt_master where itt_no=" + ittno +") order by it.item_id ");
while(rs1.next())
{
itemid=rs1.getString(1);
qty=rs1.getString(2);
int amnt=(Integer.parseInt(req.getParameter(itemid)));
bamt=bamt+amnt;
int updated=stmt.executeUpdate("insert into sup_item_amnt values('" + supid + "'," + indno1 + "," + itemid + "," + qty + "," + amnt + " )");

}

rs1.close();

System.out.println("The Bid AmounbtI"+bamt);




			
			int c_id=0;

             ResultSet rs = CBean.executeQuery("select nvl(max(sid),0)+1 from itt_details");
		     rs.next();
			 int  indno=rs.getInt(1);
             rs.close();

         System.out.println("THE ERRO IS"+indno);
         System.out.println("update itt_details set sbidamt=" + bamt + ",sid=" + indno + " where ittno=" + ittno + " and sup_id='" + supid + "'");
    	   String 	strQry="update itt_details set sbidamt=" + bamt + ",sid=" + indno + " where itt_no=" + ittno + " and sup_id='" + supid + "' ";
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
