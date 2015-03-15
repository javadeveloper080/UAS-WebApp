<%@page import="java.sql.*,EPR.*" %>
<%
  try
  {
    ConnectionBean CBean=new ConnectionBean();
    Connection con=CBean.getConnection();
    String loginName=request.getParameter("name");
    String Pwd=request.getParameter("pwd");
    
    ResultSet custrs=CBean.executeQuery("select emp_id from employee_info where emp_id='" + loginName + "' and pwd='" + Pwd + "' ");
    if(custrs.next())
    {
    
          
          String emp_id=custrs.getString(1);
          session.putValue("empid",emp_id);
          
          
    	  System.out.println(session.getValue("empid"));
    	  
      %>
    	<jsp:forward page="DeptHome.jsp" />
		
		<%
		
    	 	
    }else 
    {
     %>
     	<jsp:forward page="DeptLogin.jsp" />
    	 
     <%
    }
  }catch(Exception ex)
  {
     System.out.println(ex);
  }


%>
