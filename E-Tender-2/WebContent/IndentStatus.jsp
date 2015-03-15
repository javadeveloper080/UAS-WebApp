<script>

function Show(ittno)
{
  alert(ittno);
  
  window.open("TenderDetails1.jsp?ittno="+ ittno + " ","popup","width=550,height=400");
  
}

function ShowItems(ittno)
{
  alert(ittno);
  window.open("ShowItems.jsp?tid="+ ittno + " ","popup","width=550,height=400");
  
}




function GetData()
{

 if(document.emp.inddt1.value=="" || document.emp.inddt=="")
 {
 
   alert("Please Select Valid Dates");
   }else
   {
    emp.action="IndentStatusDateWise.jsp";
    emp.submit();
  
  }
 
}


function Update(pid,iname)
{
 
  
  window.open("UpdateIndent.jsp?pid="+ pid + "&iname='" + iname +"' " ,"popup","width=500,height=500")
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
 document.emp.action="IndentStatus.jsp";
 document.emp.submit();
}
function sub()
{
document.emp.test.value="1";
document.emp.action="IndentStatus.jsp";
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
String Exists="False";

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
 ResultSet rs2=null;
 Statement stmt2 = null;
  
 ResultSet rs3=null;
 Statement stmt3 = null;
 
 
 try 
 {	
 	 ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 stmt2 = con.createStatement();
	 stmt3 = con.createStatement();
	 String empid=session.getValue("empid")+"";
	 
	 
	 
	 rs = stmt.executeQuery("select to_char(sysdate,'dd-mon-yyyy') from dual");
	 rs.next();
	 String date=rs.getString(1);
	 rs.close();
	System.out.println("Date Is"+date);
	int updated= stmt.executeUpdate("update itt_master set itt_status='Closed' where to_char(ittldate,'dd-mon-yyyy')<to_date('" + date + "') ");
	
	
	updated= stmt2.executeUpdate("update indent_master set status='Closed' where ind_no in(select ind_no from itt_master where itt_status='Closed') ");
	rs = stmt.executeQuery("select inm.ind_no,to_char(inm.inddate,'dd-mon-yyyy'),to_char(inm.delv_date,'dd-mon-yyyy'),inm.est_rate,inm.status from indent_master inm  where emp_id='" + empid + "' order by inm.ind_no");
  	 
  	 
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
       	 <center><h1 class=tabhead>INDENT STATUS INFORMATION </h1> </center>
       	 <table align=center border=1 colspace=10>
	 <th class=tabhead3>Indent No
	 <th class=tabhead3>Indent Date
	 <th class=tabhead3>Delivery Date
	 <th class=tabhead3>Esitmate Rate
	 <th class=tabhead3>Status	 
	 <th class=tabhead3>Check
	 <th class=tabhead3>Show Items
	 	 
	 
	 
	 
        

        <%
          int rowCount = 0; 
          while(rs.next())
          
          
          {
	          rowCount=rowCount+1;
		    if (rowCount>fromRows && rowCount<=toRows) 
		    {
	        String tid=rs.getString(1);
	     	        
	        rs3=stmt3.executeQuery("select * from itt_master  where ind_no='" + tid + "' ");
	        if(rs3.next())
	        {
	        
	        Exists="True";
	        
	        }else
	        {
	        Exists="False";
	        
	        
	        }
	        
	        
	        rs3.close();
	        
	        
	        
	        
	    %>  
   
        <tr>
	<td class=tabhead1><%=tid%></td>
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	<td class=tabhead1><%=rs.getString(4) %></td>
	
	<%
	   String status=rs.getString(5);
	%>
	
	<td class=tabhead1><%=status%></td>
	<%
	if(status.equals("Pending") &&  Exists.equals("False"))
	{
	%>
	 <td class=tabhead1><a style={cursor:hand} onclick="Update('<%=tid%>')">Update</a></td>
	<%
	
	}else if(status.equals("Pending") &&  Exists.equals("True"))
	{
	%>
	   <td class=tabhead1 disabled><a style={cursor:hand} onclick="Show('<%=tid%>')">Show Details</a></td>
	<%
	
	}else if(status.equals("Closed") &&  Exists.equals("True"))
	{
	%>
	   <td class=tabhead1><a style={cursor:hand} onclick="Show('<%=tid%>')">Show Details</a></td>
	<%
	}
	
	%>
	
	   <td class=tabhead1><a style={cursor:hand} onclick="ShowItems('<%=tid%>')">Show Items</a></td>
       </tr>
        <%
        }
        
        
        }
        
        
			} catch(Exception e ) {
			
			System.out.println("ok Erro"+e);
			
			
			}
                     	    
        
        %>
        </table>
        <TABLE WIDTH="985"><TR>
	       	 <TD ALIGN=CENTER> 
	       	 <INPUT  TYPE=BUTTON value="First" onclick="check('first')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Previous" onclick="check('previous')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Next" onclick="check('next')";>&nbsp;&nbsp;&nbsp;&nbsp;
	       	 <INPUT  TYPE=BUTTON value="Last" onclick="check('last')";>
       	 </TD></TR></TABLE>
       	 
       	<TABLE align=center border=1 colspace=10>
       	
       	<tr >
       	  <td  class=tabhead1  ><b>Datewise Indent Status</b>
       	  <br>
         <b>From</b>    <input type="text" name="inddt" readonly value="" maxlength=30 >
       	          <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.emp.inddt);
       	  				 return false;" HIDEFOCUS tabIndex=5>
       				<img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt="">
       		
       		</a>
       		
       		
       	
       		
       	 <b>To</b> 	 <input type="text" name="inddt1" readonly value="" maxlength=30 >
       			          <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.emp.inddt1);
       			  				 return false;" HIDEFOCUS tabIndex=5>
       						<img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt="">
       				
       				</a>
				
		
		
		<INPUT  TYPE=BUTTON value="GetData" onclick="GetData()";>
			</td>	
			
		
				
	</tr>


       	</TABLE>
       	
       	
       	 
       	 <TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0>
	   <TBODY>
	   <TR>
	 
	     <TD class=tabhead width="10%"><H4></TD>
	 
   </TBODY></TABLE>
   
 </FORM>
 <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
 </body>
 </html>       