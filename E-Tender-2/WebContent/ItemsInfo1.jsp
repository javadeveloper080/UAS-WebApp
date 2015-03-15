<script>
function Update(pid)
{
  alert(pid);
  window.open("UpdateItem.jsp?pid="+ pid + " ","popup","width=500,height=500")
}
</script>


<HTML><HEAD>
<TITLE>Home Page</TITLE>
<body>
<LINK href="css/styles.css" type=text/css rel=stylesheet>


<jsp:include page="DeptHeader.jsp" />

<%@ page import="java.sql.*" %>
<script language="Javascript">
function check(test1)
{
 
if ( test1 == 'first') { document.emp.mode.value='First'; }
if ( test1 == 'previous') { document.emp.mode.value='Previous'; }
if ( test1 == 'next') { document.emp.mode.value='Next'; }
if ( test1 == 'last') { document.emp.mode.value='Last'; }
 document.emp.test.value="2";
document.emp.action="ItemsInfo1.jsp";
document.emp.submit();
}

function sub()
{
  
document.emp.test.value="1";
 
document.emp.action="ItemsInfo1.jsp";
document.emp.submit();
}
function Go()
{
   emp.action="ItemRegister.jsp";
   emp.submit();
   
   
  

}


</script>
<body bgcolor="lightblue">



<%
  
%>
<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 String empid=session.getValue("empid")+"";
 
 try 
 {
        
        
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 stmt = con.createStatement();
	 rs = stmt.executeQuery("select * from items_info where itcat=(select dept from employee_info where emp_id='" + empid + "')");
  
 } 
 catch(Exception e) 
 {
 
 }	
              	        
              	        
              	
   	 
     
  
  

    
	%>        
           
           
           
        <FORM NAME="emp"   METHOD="POST"  >
       
       	 
       	 <center><h1 class=tabhead>ITEMS INFORMATION </h1> </center>
       	 <table align=center border=1 colspace=10>
	 <th class=tabhead3>Item Id
	 <th class=tabhead3>Item Name
	 <th class=tabhead3>Item Description
	 <th class=tabhead3>Item Specialisation
	 <th class=tabhead3>Units
	 <th class=tabhead3>Rate
	
	 
	 
	 
	 
        

        <%
          int rowCount = 0; 
          while(rs.next())
          
          
          {
	        
	        String tid=rs.getString(1);
	        
	    %>  
   
        <tr>
	<td class=tabhead1><%=tid%></td>
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	<td class=tabhead1><%=rs.getString(4) %></td>
	<td class=tabhead1><%=rs.getString(5) %></td>
	<td class=tabhead1><%=rs.getString(6) %></td>
	
	
	
	
       </tr>
        <%
        }
        
        
		      
        %>
        </table>
        <TABLE WIDTH="985"><TR>
	       	 
	       	 <TD ALIGN=CENTER> 
	       	 
	       	 
	       	 
	 
	       	 
       	 </TD></TR></TABLE>
       	 
       	 <TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0>
	   <TBODY>
	   <TR>
	 
	     <TD class=tabhead width="10%"><H4></TD>
	 
   </TBODY></TABLE>
 </FORM>
 </body>
 </html>       