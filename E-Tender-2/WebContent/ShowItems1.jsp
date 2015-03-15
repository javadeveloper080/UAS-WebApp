<script>



function dispose()
{


self.close();

}



</script>



<html>
<head>
</head>


<body bgcolor=lightblue >
<LINK href="css/styles.css" type=text/css rel=stylesheet>

<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
  Statement stmt2 = null;
  String ittno=null;
    String bamt="0";
    
 try 
 {
         System.out.println("Ok");
         
     ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 Statement stmt1 = null;
	
	 stmt = con.createStatement();
	 
	 stmt1 = con.createStatement();
	 stmt2 = con.createStatement();
	 
	String  indno=request.getParameter("tid");
	 
		  
	 rs1=stmt1.executeQuery("select it.item_id,itnf.name,it.qty from ind_items it,items_info itnf where  it.item_id=itnf.item_id  and it.ind_no=(select ind_no from itt_master where itt_no=" + indno +") ");
	 
	 }catch(Exception ex)
 {
  
  
  out.println("Erro"+ex);
  
 }
        
     
         
          
 %>
  
              	
              	
<form name="f1" method="post" action="AcceptInvitation" onsubmit="return CheckInput()">
  <br>
<table>
 <tr>
	  <td class=tabhead3>All Items Details</td>
	 </tr>
</table>
<table >
	  <th class=tabhead3>Item Id
      <th class=tabhead3>Item Name
	 <th class=tabhead3>Qty
 	 <tr>
  <%
     
    while(rs1.next())
       {
	  
	%>
	
	<tr>

	<td class=tabhead1><%=rs1.getString(1) %></td>
	<td class=tabhead1><%=rs1.getString(2) %></td>
	<td class=tabhead1><%=rs1.getString(3) %></td>

<%
}
%>



</table >

         <input  type="button" id="clear" value="Close" onclick="dispose()">
         
</form>

</body>
</html>
