<script>
function ShowItemCost(ittno,sid)
{
  alert(ittno);
  alert(sid);
  
  window.open("ShowItemCost.jsp?ittno="+ ittno + "&sid=" + sid + " ","popup","width=550,height=400");
  
  
  
}

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


f1.action="SupHome.jsp";
f1.submit();


}



</script>



<html>
<head>
</head>

<jsp:include page="SupHome.jsp" />

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
	 
	 ittno=request.getParameter("ittno");
	 
	// rs=stmt.executeQuery("select si.sup_id,si.name,si.address,si.phno,si.email from supplier_info si where si.sup_id =(select sup_id from itt_details where itt_no="+ ittno + " and sbidamt=(select min(sbidamt) from itt_details where itt_no=" + ittno + "))");
     
	 System.out.println("Itt Details"+ittno);
	 
	 rs=stmt.executeQuery("select si.sup_id,si.name,si.address,si.phno,si.email from supplier_info si where si.sup_id=( select sup_id from itt_details where sid=(select min(sid) from itt_details where sbidamt=(select min(sbidamt) from itt_details where itt_no=" + ittno + ") and itt_no=" + ittno + "))");
	 
	  
	  
	  
	 rs1=stmt1.executeQuery("select si.sup_id,si.name,si.address,si.phno,si.email from supplier_info si  where  si.sup_id in (select sup_id from itt_details where itt_no=" + ittno + ")");
	  
	 
	 }catch(Exception ex)
 {
  
  
  out.println("Erro"+ex);
  
 }
        
     
         
          
 %>
  
              	
              	
<form name="f1" method="post" action="AcceptInvitation" onsubmit="return CheckInput()">
<table border="0" cellpadding="5" cellspacing="1">
<tr>
<input type="hidden" name="supid" readonly>
      <td class=tabhead1><b>Tender No</b></td>
<td class=tabhead1><%=ittno%></td>
</tr>
<br>
<br>

<tr>
<td class=tabhead3>Tender Granted</td>
</tr>

</table>

<table >
	 <th class=tabhead3>SupId
	 <th class=tabhead3>SupplierName
	 <th class=tabhead3>Address
	 <th class=tabhead3>Phone No
	 <th class=tabhead3>Email
	 <th class=tabhead3>Tender Amount
	  
	  
	 
  <%
       while(rs.next())
       {
	       
	       String sid=rs.getString(1);
	       rs2=stmt2.executeQuery("select sbidamt from itt_details where itt_no=" + ittno + " and sup_id='" + sid+ "' ");
	       if(rs2.next())
	       {
		   
		      bamt=rs2.getString(1);
		           
	       }
	       rs2.close();
	       
	       
	%>

  <tr>
	<td class=tabhead1><%=sid%></td>
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	<td class=tabhead1><%=rs.getString(4) %></td>
	<td class=tabhead1><%=rs.getString(5) %></td>
	<td class=tabhead7><%=bamt %></td>
	
	
	</tr>
	<%
}
%>

 
</table>
<br>
<br>
<table>
 <tr>
	 <td class=tabhead3>All Suppliers Tender Details</td>
	 </tr>
</table>
<table >
	 <th class=tabhead3>SupId
	 <th class=tabhead3>SupplierName
	 <th class=tabhead3>Address
	 <th class=tabhead3>Phone No
	 <th class=tabhead3>Email
     <th class=tabhead3>Tender Amount
	<th class=tabhead3>Show Items
	 
	 

	 	 <tr>
  <%
     String sid1="";
	 
	 
    while(rs1.next())
       {
	       
	       sid1=rs1.getString(1);
	       rs2=stmt2.executeQuery("select sbidamt from itt_details where itt_no=" + ittno + " and sup_id='" + sid1+ "' ");
	       
	       if(rs2.next())
	       {
		   
		      bamt=rs2.getString(1);
		           
	       }
	       rs2.close();
	       
	       
	       
	%>
	
	<tr>
	<td class=tabhead1><%=sid1%></td>
	<td class=tabhead1><%=rs1.getString(2) %></td>
	<td class=tabhead1><%=rs1.getString(3) %></td>
	<td class=tabhead1><%=rs1.getString(4) %></td>
	<td class=tabhead1><%=rs1.getString(5) %></td>
	
	<%
	if(bamt == null)
	{
		
	 bamt="0";
	 
		}
	%>
	
		
	<td class=tabhead7><%=bamt%></td>
<td class=tabhead1><a style={cursor:hand} onclick="ShowItemCost('<%=ittno%>','<%=sid1%>')"  >Show Items Cost</a></td>

	<%
}

 
    

%>
 
 

</table >

         <input  type="button" id="clear" value="Close" onclick="dispose()">
         
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe> 
</body>
</html>
