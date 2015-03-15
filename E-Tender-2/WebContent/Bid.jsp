<script>



function Close()
{

f1.action="SupHome.jsp"
f1.submit();


}



</script>



<html>
<head>
</head>
<jsp:include page="SupHome.jsp" />
<body bgcolor=lightblue >
<form name="f1" method="post" action="BidAmount" onsubmit="return CheckInput()">
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
    String supid=session.getValue("supid")+""; 
	String  indno=null;
	
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
	
	 
	  indno=request.getParameter("pid");
	 
		  
	 rs1=stmt1.executeQuery("select it.item_id,itnf.name,it.qty from ind_items it,items_info itnf where  it.item_id=itnf.item_id  and it.ind_no=(select ind_no from itt_master where itt_no=" + indno +") order by it.item_id ");
	 
	 }catch(Exception ex)
 {
  
  
  out.println("Erro"+ex);
  
 }
        
     
         
          
 %>
  
              	
              	

  <br>
  <input type="hidden" name="supid" value=<%=supid%> >
<input type="hidden" name="ittno" value=<%=indno%> >
  <table align="center">
    <tr>
	  <td class=tabhead3>All Items Details</td>
	 </tr>
</table>
  <table align="center" >
    <th class=tabhead3>Item Id
      <th class=tabhead3>Item Name
	 <th class=tabhead3>Qty
	 <th class=tabhead3>Bid Amount
	 
	 
 	 <tr>
  <%
     
    while(rs1.next())
       {
	  String itemid=rs1.getString(1);
	  
	%>
	<tr>
	<td class=tabhead1><%=itemid %></td>
	<td class=tabhead1><%=rs1.getString(2) %></td>
	<td class=tabhead1><%=rs1.getString(3) %></td>
	<td class=tabhead1><input type=text value="0" name="<%=itemid%>"></td>
<%
}
%>



</table >
  <table width="8%" border="0" align="center">
    <tr>
    <td> <input  type="submit" id="clear" value=" Bid "></td>
	 <td> <input  type="button" id="clear" value=" Close " onclick="Close()"></td>
  </tr>
</table>
        
         
</form>

</body>
</html>

