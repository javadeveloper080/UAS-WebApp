<script>

function ShowItems(ittno)
{
  alert(ittno);
  window.open("ShowItems1.jsp?tid="+ ittno + " ","popup","width=550,height=400");
  
}




function Bid(pid)
{
 
  emp.action="Bid.jsp?pid="+ pid ;
  emp.submit();
   
  
}

function Show(ittno)
{
  alert(ittno);
  
  //window.open("TenderDetails.jsp?ittno="+ ittno + " ","popup","width=550,height=400");
    emp.action="TenderDetails2.jsp?ittno="+ ittno ;
  emp.submit();
  
  
}




</script>
<HTML><HEAD>
<TITLE>Home Page</TITLE>
<body>
<LINK href="css/styles.css" type=text/css rel=stylesheet>

<jsp:include page="SupHome.jsp" />
<%@ page import="java.sql.*" %>
<script language="Javascript">
function check(test1)
{
if ( test1 == 'first') { document.emp.mode.value='First'; }
if ( test1 == 'previous') { document.emp.mode.value='Previous'; }
if ( test1 == 'next') { document.emp.mode.value='Next'; }
if ( test1 == 'last') { document.emp.mode.value='Last'; }
 document.emp.test.value="2";
 document.emp.action="InvTender.jsp";
 document.emp.submit();
}

function sub()
{
  
document.emp.test.value="1";
 
document.emp.action="InvTender.jsp";
document.emp.submit();
}
function Go()
{
   emp.action="InvitationRegister.jsp";
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
  ResultSet rs1=null;
  	 Statement stmt1 = null;
	  String supid=null;
	  
  
 try 
 {
        
        
     ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 
	 stmt = con.createStatement();
	 	 
	 stmt1 = con.createStatement();
	 rs = stmt.executeQuery("select to_char(sysdate,'dd-mon-yyyy') from dual");
	 rs.next();
	 String date=rs.getString(1);

	 rs.close();

	 supid=session.getValue("supid") +"";
	 
	 System.out.println("Supplier Id"+ supid);

    	 int updated= stmt.executeUpdate("update itt_master set itt_status='Closed' where to_char(ittldate,'dd-mon-yyyy')<to_date('" + date + "') ");
	
	 
	 rs = stmt.executeQuery("select itm.itt_no,to_char(itm.ittdate,'dd-mon-yyyy'),to_char(itm.ittldate,'dd-mon-yyyy'),itm.itt_status from itt_master itm,indent_master ind where itm.ind_no=ind.ind_no and  itm.itt_no in (select itt_no from itt_details where sup_id='" + supid + "') order by itm.ind_no ");
	 
	 
	 
   
      // rs.last();
     //noofRows=rs.getRow();
    // rs.beforeFirst();
 

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
       	 <center><h1 class=tabhead>TENDERS INFORMATION </h1> </center>
       	 <table align=center border=1 colspace=10>
	  <th class=tabhead3>Tender No 
      <th class=tabhead3>Invitation Date
	 <th class=tabhead3>Tender Last Date
	
	 <th class=tabhead3>Status
	  <th class=tabhead3>Show Items
	  
	 <th class=tabhead3>Auction
	
	 
	  
	
	 
	 
	 
	 
        

        <%
          int rowCount = 0; 
          while(rs.next())
          
          
          {
	      //    rowCount=rowCount+1;
		//    if (rowCount>fromRows && rowCount<=toRows) 
		    
		    
	//{
	        String tid=rs.getString(1);
	        
	    %>  
   
        <tr>
	<td class=tabhead1><%=tid%></td>
	
	<%
		 
	 rs1 = stmt1.executeQuery("select sbidamt from itt_details where itt_no=" + tid + "  and sup_id='" + supid + "' ");
	 
	 
	 rs1.next();
	 
	 String amt=rs1.getString(1);

	 rs1.close();
	 
	 
	
	%>
	
	
	<td class=tabhead1><%=rs.getString(2) %></td>
	<td class=tabhead1><%=rs.getString(3) %></td>
	
	 
	<%
	   String status=rs.getString(4);
	%>
	<td class=tabhead1><%=status%></td>
	 <td class=tabhead1><a style={cursor:hand} onclick="ShowItems('<%=tid%>')">Show Items</a></td>
	<%
	if(amt == null )
	{
	%>
	
	<%
	 if(status.equals("Closed"))
	   {
		   %>
		   
	<td class=tabhead1><a style={cursor:hand} onclick="Show('<%=tid%>')">Show Details</a></td>    			
	  
	<%
    }else
    {
	    
	    %>
<td class=tabhead1><a style={cursor:hand} onclick="Bid('<%=tid%>')" >Bid Amount</a></td>

	    <%
    }
    
    %>
    
	 
	    
	<%
	}else if(status.equals("Closed"))
	{
	%>
	
	<td class=tabhead1><a style={cursor:hand} onclick="Show('<%=tid%>')" >Show Details</a></td>
	
	<%
	
	}else
	{
		
		
	
	%>
	<td class=tabhead1><a style={cursor:hand} disabled >Show Details</a></td>
	
	 <%
 }
 %>
 
	
	  
	
	
       </tr>
        <%
      //  }
        
        
        }
        
        
			} catch(Exception e ) {
			
			System.out.println("ok Erro");
			
			
			}
                     	    
        
        %>
        </table>
       
       	 
       	 
       	 <TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0>
	   <TBODY>
	   <TR>
	 
	     <TD class=tabhead width="10%"><H4></TD>
	 
   </TBODY></TABLE>
 </FORM>
  <iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
 </body>
 </html>       