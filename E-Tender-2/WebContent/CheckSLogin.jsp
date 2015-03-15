<%@page import="java.sql.*,EPR.*" %>
<%
  try
  {
    ConnectionBean CBean=new ConnectionBean();
    Connection con=CBean.getConnection();
    String loginName=request.getParameter("name");
    String Pwd=request.getParameter("pwd");
    
    ResultSet custrs=CBean.executeQuery("select sup_id from supplier_info where sup_id='" + loginName + "' and pwd='" + Pwd + "' ");
    if(custrs.next())
    {
    
          
          String sup_id=custrs.getString(1);
          session.putValue("supid",sup_id);
    	  System.out.println(session.getValue("supid")+ "Valid");
    	  
      %>
    	<jsp:forward page="SupHome.jsp" />
		
		<%
		
    	 	
    }else 
    {
     %>
     	<jsp:forward page="SPLogin.jsp" />
    	 
     <%
    }
  }catch(Exception ex)
  {
     System.out.println(ex);
  }


%>
