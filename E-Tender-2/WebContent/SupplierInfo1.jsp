<script>

function Update(pid)
{
  alert(pid);
  window.open("UpdateSup.jsp?pid="+ pid + " ","popup","width=500,height=500");
  
}

</script>

<HTML><HEAD>
<jsp:include page="PurchHeader.jsp" />



<%@ page import="java.sql.*" %>
<script language="Javascript">
function check(test1)
{
 
if ( test1 == 'first') { document.emp.mode.value='First'; }
if ( test1 == 'previous') { document.emp.mode.value='Previous'; }
if ( test1 == 'next') { document.emp.mode.value='Next'; }
if ( test1 == 'last') { document.emp.mode.value='Last'; }
 document.emp.test.value="2";
document.emp.action="SupplierInfo1.jsp";
document.emp.submit();
}

function sub()
{
  
document.emp.test.value="1";
 
document.emp.action="SupplierInfo1.jsp";
document.emp.submit();
}
function Go()
{
   emp.action="SupRegister.jsp";
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

<%@page import="java.sql.*,EPR.*"%>
<%
 Connection con=null;
 ResultSet rs=null;
 try 
 {
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 rs = stmt.executeQuery("select sup_id,name,gen,phno,address,email,remarks from supplier_info order by sup_id");
  
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
       	 <center><h1 class=tabhead>SUPPLIER INFORMATION </h1> </center>
       	 <table align=center border=1 colspace=10>
	 <th class=tabhead3>Supplier Id
	 <th class=tabhead3>Name
	 <th class=tabhead3>Gender
	 <th class=tabhead3>Phone No
	 <th class=tabhead3>Address
	 <th class=tabhead3>Email
	 <th class=tabhead3>Remarks
	
	 
	 
	 
	 
        

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
	<td class=tabhead1><%=rs.getString(7) %></td>
	
	
	
	
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
	       	 
	       
	       	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       	 
	       	 <INPUT  TYPE=BUTTON value="First" onclick="check('first')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Previous" onclick="check('previous')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Next" onclick="check('next')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Last" onclick="check('last')";>
	       	 
	       	 
	       	 
       	 </TD></TR></TABLE>
       	 
       	 <TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0>
	   <TBODY>
	   <TR>
	 
	     <TD class=tabhead width="10%"><H4></TD>
	 
   </TBODY></TABLE>
 </FORM>
 </body>
 </html>       