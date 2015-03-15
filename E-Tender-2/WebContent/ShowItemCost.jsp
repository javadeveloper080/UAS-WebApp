<script>

function CheckInput()
{
	
if(f1.supid1.selectedIndex==0)
{
	
alert("Please Select Supplier Id");
return false;

	}
	
}

function GetId()
{

f1.supid.value=f1.supid1.options[f1.supid1.selectedIndex].text;
}

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
<strong class=tabhead1>TENDER BIDDING DETAILS</font></strong></p>
<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
  Statement stmt2 = null;
  String indno=null;
  String ittno=null;
    String bamt="0";
    
 try 
 {
         
     ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 Statement stmt1 = null;
	
	 stmt = con.createStatement();
	 
	 stmt1 = con.createStatement();
	 stmt2 = con.createStatement();
	 String supid=request.getParameter("sid");
	 
	 
	 ittno=request.getParameter("ittno");
	 
	 
	 rs=stmt.executeQuery("select ind_no  from itt_master where itt_no='" + ittno + "' ");
	 
	 
	 if(rs.next())
	 {
	   indno=rs.getString(1);
	 }
	 rs.close();
	 rs=stmt.executeQuery("select sit.item_id,itnf.name,sit.qty,sit.amt  from sup_item_amnt  sit,items_info itnf where sit.item_id=itnf.item_id and sit.sup_id='" + supid + "' and sit.ind_no=" + indno + " ");
	 

 }catch(Exception ex)
 {
         
 }
         
         
          
 %>
  
              	
              	
<form name="f1" method="post" action="AcceptInvitation" onsubmit="return CheckInput()">
<table border="0" cellpadding="5" cellspacing="1">
<tr>
<input type="hidden" name="supid" readonly>
<td class=tabhead1><b>Tender No </b></td>
<td class=tabhead1><%=ittno%></td>
</tr>
<br>
<br>

<tr>
      <td class=tabhead3>Item Wise Bid Amount</td>
</tr>

</table>

  <table >
    <tr valign="top"> 
      <th class=tabhead3>ItemId 
      <th class=tabhead3>ItemName 
      <th class=tabhead3>Quantity 
      <th class=tabhead3>BidAmount 
        <%
       while(rs.next())
       {
	       
	%>
    <tr>

	<td class=tabhead1><%=rs.getString(1) %></td>
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	<td class=tabhead1><%=rs.getString(4) %></td>
	</tr>
	<%
}
%>
</table>
<br>
<br>
  <input  type="button" id="clear" value="Close" onclick="dispose()">
         
</form>
</body>
</html>
