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
<strong class=tabhead1>INVITATION TO TENDERS</font></strong></p>
<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
  String ittno=null;
  
 try 
 {
         
     ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 stmt = con.createStatement();
	 
	 ittno=request.getParameter("pid");
	String  indno=request.getParameter("indno");
	 String cat="No";
	 
	 rs=stmt.executeQuery("select dept from employee_info where emp_id=(select emp_id from indent_master where ind_no=" + indno + ")");
	 if(rs.next())
	 {
	 cat=rs.getString(1);
	 }
	 
	 
	 
	 
	 
	 System.out.println("select sup_id from supplier_info where sup_id not in(select sup_id from itt_details where itt_no=" + ittno + " ) and scat='" + cat +"' ");
	 
	 rs=stmt.executeQuery("select sup_id from supplier_info where sup_id not in(select sup_id from itt_details where itt_no=" + ittno + " ) and scat='" + cat + "' ");
     
	     




 }catch(Exception ex)
 {
         
 }
         
         
          
 %>
  
              	
              	
<form name="f1" method="post" action="AcceptInvitation" onsubmit="return CheckInput()">
<table border="0" cellpadding="5" cellspacing="1">
<tr>
<input type="hidden" name="supid" readonly>

<td class=tabhead1><b>ITT No </b></td>
<td class=tabhead1><input type="text" name="ittno" readonly value=<%=ittno%> maxlength=3 size=5 ></td>
</tr>

<tr>
<td class=tabhead1><b>Supplier Id</b></td>

<td class=tabhead1><select name=supid1 onchange="GetId()">
  <option>--Select Supplier Id--></option>
    <%
      while(rs.next())
      {
      
      %>
      <option><%=rs.getString(1)%></option>
      <%
      
      }
    %>
    
    </select>
    
    
</td>


</tr>

<td>
<td colspan=4><input name="Add" type="submit" id="Add" value="Invite" >
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input  type="button" id="clear" value="Close" onclick="dispose()">
          </td></tr>

<tr>






</td>
</tr>
</table>
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe> 
</body>
</html>
