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
<TABLE>
<TR>
    <TD><image src="IMAGES/Header1.JPG" height=130 width="980" ></TD>
<TR>
</TABLE>
<TABLE width="78%">
  <TR>
	<TD class=tabdata width="13%">ADMINISTRATOR</TD>
    <TD align=center class=title1 width="87%">E-PROCURE SYSTEM</TD>
<TR>
</TABLE>
<font color="#ECE9D8"></font>

<TABLE width=100%>
<TR>
    <TD class=tabdata width=25%><a href="EmployeeInfo.jsp"><font color="#FFFFFF">EMPLOYEE INFORMATION</font></a></TD>
	<TD class=tabdata  width=25%><a href="SupplierInfo.jsp"><font color="#FFFFFF">SUPPLIER INFORMATION</font></a></TD>
	<TD class=tabdata  width=25%><a href="ItemsInfo.jsp"><font color="#FFFFFF">ITEMS INFORMATION</font></a></TD>
	<TD  class=tabdata width=25%><a href="Home.jsp"><font color="#FFFFFF">LOG OUT</font></a></TD>
<TR>
</TABLE>




</BODY></HTML>



<%@ page import="java.sql.*" %>
<script language="Javascript">
function check(test1)
{
 
 
if ( test1 == 'first') { document.emp.mode.value='First'; }
if ( test1 == 'previous') { document.emp.mode.value='Previous'; }
if ( test1 == 'next') { document.emp.mode.value='Next'; }
if ( test1 == 'last') { document.emp.mode.value='Last'; }
 document.emp.test.value="2";
document.emp.action="ItemsInfo.jsp";
document.emp.submit();
}

function sub()
{
  
document.emp.test.value="1";
 
document.emp.action="ItemsInfo.jsp";
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
String test="";


int pageNo=0;
int fromRows=0;
int toRows=0;
int noofRows=0;
int nn=0;

try {
        pageNo = Integer.parseInt((String)request.getParameter("pageNo"));
     }catch (Exception e)
    {
      pageNo=0;
      
      
    }   
%>
<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 
 try 
 {
        
        
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 rs = stmt.executeQuery("select * from items_info order by item_id");
  
           rs.last();
           noofRows=rs.getRow();
           rs.beforeFirst();
   
 } 
 catch(Exception e) 
 {
   out.println(e);
 }	
              	        
              	        
              	
    int remRows=noofRows%10;
    int LastPage=(noofRows-remRows)/10;
              		
    if (remRows>0) { LastPage++; }	   
              		   
   try 
        {
          if (request.getParameter("mode").equals("Previous")) {pageNo--;}		
              		    
          if (request.getParameter("mode").equals("Next")) 
          { 
              pageNo++; 
              			if (pageNo>LastPage) 
              			{
              			    pageNo=LastPage;
              			}
          }		
              	            if (request.getParameter("mode").equals("Last"))
              	             { pageNo=LastPage;}	
              	             
              	             	
              	            if (request.getParameter("mode").equals("First")) 
              	            { pageNo=1;}	
              	        
        } 
        
        
        catch(Exception e) { pageNo++;}		 
              			   
        if (pageNo<=0) {pageNo=1;}     		   
              		  
             pageNo=pageNo;
             toRows=pageNo*10;
             int gm=0;
              		
              		 
              		
           if (toRows > noofRows ) 
           {  gm=  noofRows;   } 
           else { gm=pageNo*10; }
              	        
           fromRows=toRows-10;
   
  %> 
  
  <%
	try
	{

	int cv=0;
	cv=pageNo;
	 
	
	 %>
	 
	 
	 
	 <%  


	 
    
	%>        
           
           
           
        <FORM NAME="emp"   METHOD="POST"  >
       
       	 
       	 <input type=hidden name=pageNo value="<%=pageNo%>">
       	 <input type=hidden  name="test">
       	 <input type=hidden name=mode >
       	 <center><h1 class=tabhead>ITEMS INFORMATION </h1> </center>
       	 <table align=center border=1 colspace=10>
	 <th class=tabhead3>Item Id
	 <th class=tabhead3>Item Name
	 <th class=tabhead3>Item Description
	 <th class=tabhead3>Item Specialisation
	 <th class=tabhead3>Units
	 <th class=tabhead3>Rate
	 
	 <th class=tabhead3> Check
	 
	 
	 
	 
        

        <%
          int rowCount = 0; 
          while(rs.next())
          
          
          {
	          rowCount=rowCount+1;
		    if (rowCount>fromRows && rowCount<=toRows) {
	        String tid=rs.getString(1);
	        
	    %>  
   
        <tr>
	<td class=tabhead1><%=tid%></td>
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	<td class=tabhead1><%=rs.getString(4) %></td>
	<td class=tabhead1><%=rs.getString(5) %></td>
	<td class=tabhead1><%=rs.getString(6) %></td>
	<td class=tabhead1><a style={cursor:hand} onclick="Update('<%=tid%>')">Update</a></td>
	
	
	
       </tr>
        <%
        }
        
        
        }
        
        
			} catch(Exception e ) {
			
			System.out.println("ok Erro");
			
			
			}
                     	    
        
        %>
        </table>
        <TABLE WIDTH="985"><TR>
	       	 
	       	 <TD ALIGN=CENTER> 
	       	 
	       	 <INPUT  TYPE=BUTTON value="NEW" onclick="Go()";>
	       	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       	 
	       	 <INPUT  TYPE=BUTTON value="First" onclick="check('first')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Previous" onclick="check('previous')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Next" onclick="check('next')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Last" onclick="check('last')";>
	       	 
	       	 
	       	 
       	 </TD></TR></TABLE>
       	 
       	 <TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0>
	   <TBODY>
	   <TR>
	 
	     <TD class=tabhead width="10%">Select Item Catagory :<select name=cat>
		 <option><--Select Item Catagory--></option>
		 <option>STORES</option>
		 <option>HR</option>
		 <option>ACCOUNT</option>
						 
		 </select><input type=submit value="Get Data"></TD>
	 
   </TBODY></TABLE>
 </FORM>
 </body>
 </html>       