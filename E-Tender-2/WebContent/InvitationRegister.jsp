<script>
function CheckInput()
{
	var sel=0;
	if(f1.ittldt.value!="")
	{
		 sel=1;
	}
	if (f1.indno1.selectedIndex==0)
	{
	     alert("Select the Indent Number");
	     f1.indno1.focus();
	     return false;
	}
	else if (f1.ittldt.value=="")
	{
	     alert("Select Tender Lastdate");
	     f1.ittldt.focus();
	     return false;
	}
	else if(sel==1)
     {
   
  		  var Date1=new Date();
  		  
   		  var Date2=new Date();
  		  
  		  
  		  dt1=f1.ittldt.value;
 		  
 		  dt2=f1.sysdate.value;
   
 		  var day1=dt1.substring(0,2);
 		  var mon1=dt1.substring(3,6);
 		  var year1=dt1.substring(7,11);
 		  
 		  var day2=dt2.substring(0,2);
 		  var mon2=dt2.substring(3,6);
 		  var year2=dt2.substring(7,11);
 		  
 		  
 		  
 		  
 		  
 		  
 		  
		  if(mon1=="Jan")
 		  {
    		  mon1=01;
    		  
  		  }else if(mon1=="Feb")
 		  {
  			  mon1=02;
   
 		  }else if(mon1=="Mar")
 		  {
 			  mon1=03;
   
		  }else if(mon1=="Apr")
 		  {
			  mon1=04;
   
 		  }else if(mon1=="May")
 		  {
 			  mon1=05;
   
 		  }else if(mon1=="Jun")
 		  {
 			  mon1=06;
   
 		  }else if(mon1=='Jul')
 		  {
 			  mon1=07;
   
 		  }else if(mon1=="Aug")
 		  {
 			  mon1=08;
   
 		  }else if(mon1=="Sep")
 		  {
 			  mon1=09;
   
 		  }else if(mon1=="Oct")
 		  {
 			  mon1=10;
   
 		  }else if(mon1=="Nov")
 		  {
 			  mon1=11;
   
 		  }else if(mon1=="Dec")
 		  {
  			  mon1=12;
   
 		  }
   
   
   
  		 if(mon2=="Jan")
 		 {
   
   
   
 		  	 mon2=01;
   
 		 }else if(mon2=="Feb")
 		 {
 			 mon2=02;
   
 		 }else if(mon2=="Mar")
 		 {
 			 mon2=03;
   
  		 }else if(mon2=="Apr")
 		 {
  			 mon2=04;
   
  		 }else if(mon2=="May")
  		 {
  			 mon2=05;
   
  		 }else if(mon2=="Jun")
   		 {
  			 mon2=06;
   
   		 }else if(mon2=="Jul")
 		 {
     
   			 mon2=07;
   
 		 }else if(mon2=="Aug")
  		 {
 			 mon2=08;
   
  		 }else if(mon2=="Sep")
  		 {
  			 mon2=09;
   
  		 }else if(mon2=="Oct")
  		 {
 			  mon2=10;
   
  		 }else if(mon2=="Nov")
 		 {
 			  mon2=11;
   
  		 }else if(mon2=="Dec")
 		 {
    		  mon2=12;
 		 }
   
   
  			  Date1.setFullYear(year1,mon1,day1);
  			  
  			  
 			  Date2.setFullYear(year2,mon2,day2);
   
   
   
   
   
  		 if(Date1<=Date2)
 		 {
  			  alert("Invitation Last Date Should Not be Less than or Equal Current Date");
   			  return false;
     
  		 }
		 else
		 {
		 	  return true;
		 }
   
 	}
}

function GetId()
{


if(f1.indno1.selectedIndex==0)
{
document.getElementById("inddet").style.visibility='hidden';
  
return false;

f1.action="InvitationRegister.jsp";
f1.submit();
   
   


}

f1.indno.value=f1.indno1.options[f1.indno1.selectedIndex].text;
var indno=f1.indno.value;

f1.action="InvitationRegister.jsp";
f1.submit();
   
   
   
}


</script>


<jsp:include page="PurchHeader.jsp" />
<html>
<head>
</head>
<body bgcolor=lightblue >

              	
              	
<form name="f1" method="post" action="InvRegister" onsubmit="return CheckInput()">
  <strong><font size="5" face="Courier New, Courier, mono">NEW TENDER</font></strong>
  <%@page import="java.sql.*,java.util.Date,EPR.*" %>
  <%
 Connection con=null;
 ResultSet rs=null;
  ResultSet rs1=null;
  String itno=null;
  String dt="";
   String indno=request.getParameter("indno1");
  
 try 
 {
         
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 Statement stmt1 = null;
	if(indno==null)
	{
	 System.out.println("Indent NO"+indno);
	 indno="0";
	 
	 }else
	 {
	  System.out.println("Indent $$$$$NO"+indno);
	 }
	 
	 stmt = con.createStatement();
	 /*select nvl(max(itt_no),0)+1 from itt_master*/
	 rs = stmt.executeQuery("select coalesce(max(itt_no),0)+1 from itt_master");
         rs.next();
         itno=rs.getString(1);
         rs.close();
         
      /*   rs = stmt.executeQuery("select to_char(sysdate,'dd-Mon-yyyy') from dual");*/
         rs = stmt.executeQuery("select current_date");
	 rs.next();
	 dt=rs.getString(1);
         rs.close();
         
		  stmt1 = con.createStatement();
		  
	 rs1=stmt1.executeQuery("select inm.ind_no,inm.inddate,inm.delv_date,inm.est_rate,inm.status from indent_master inm where inm.ind_no=" + indno + " ");



   rs=stmt.executeQuery("select ind_no from indent_master  where status='Pending' and ind_no not in(select ind_no from itt_master) order by ind_no ");
         
         
       
         
 }catch(Exception ex)
 {
         
 }
         
         
          
 %>
  <table width="75%" border="0" height="251">
    <tr> 
      <td height="103" width="47%" valign="top"> 
        <table border="0" cellpadding="5" cellspacing="1">
          <tr> 
            <input type="hidden" name="indno" value=<%=indno%> >
            <td height="42"><b>Tender No </b></td>
            <td height="42"> 
              <input type="text" name="ittno" readonly value=<%=itno%> maxlength=3 size=5 >
              <input type="hidden" name="sysdate" value="<%=dt%>" >
            </td>
          </tr>
          <tr> 
            <td><b>Indent No</b></td>
            <td>
              <select name=indno1 onChange="GetId()">
                <option>--Select Indent No--></option>
                <%
      while(rs.next())
      {
      String indno1=rs.getString(1);
	  
	  if(indno1.equals(indno))
	  {
	    %>
	       <option selected><%=indno1%></option>
      <%
	  }else
	  {
	  %>
	       <option ><%=indno1%></option>
	 <%
	   }
		       
      }
	  rs.close();
	  
    %>
              </select>
            </td>
          </tr>
          <tr> 
            <td><b>Tender Last Date</b></td>
            <td>
              <input type="text" name="ittldt" readonly value="" maxlength=30 >
              <a href="javascript:void(0)" onClick="if(self.gfPop)gfPop.fPopCalendar(document.f1.ittldt);
  				 return false;" HIDEFOCUS tabindex=5> <img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""></a> 
            </td>
          </tr>
          <tr> 
            <td colspan=4>
              <input name="Add" type="submit" id="Add" value="Add" >
              &nbsp;&nbsp;&nbsp;&nbsp; 
              <input name="clear" type="reset" id="clear" value="Clear">
            </td>
          </tr>
          <tr> 
            <td height="25"> </td>
          </tr>
        </table>
      </td>
      <td height="103" width="53%" valign="top"> 
	 <div id=inddet>
	 
	  <%
	  
	  
if(rs1.next())
{
	 
         indno=rs1.getString(1);

%>
<strong><font size="5" face="Courier New, Courier, mono">INDENT INFORMATION</font></strong>

  <table border="0" cellpadding="5" cellspacing="1" >
    <tr> 
      <td><b>Indent No</b></td>
      <td>
        <input type="text" name="indno" value="<%=indno%>" readonly>
        
		      </td>
    </tr>
    <tr> 
      <td><b>Indent Date</b></td>
      <td>
        <input type="text" name="indt" readonly value="<%=rs1.getString(2)%>" maxlength=30 ><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.indt);
  				 return false;" HIDEFOCUS tabIndex=5>
        <img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""> </a>
      </td>
    </tr>
    <tr> 
      <td><b>Delevery Date</b></td>
      <td>
        <input type="text" name="deldt" readonly value="<%=rs1.getString(3)%>" maxlength=30 ><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.deldt);
  			 return false;" HIDEFOCUS tabIndex=5>
        <img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""> </a>
      </td>
    </tr>
    <tr> 
      <td><b>Estimated Rate</b></td>
      <td>
        <input type="text" id="it" name="estrt" value="<%=rs1.getString(4)%>" onkeyup="NoCheck(this)"  onblur="Check(this)" maxlength=12>
      </td>
    </tr>
    <td> 
    </tr>
  </table>

<%
}


%>
</div>
<%

rs1.close();
%>

	  
	   
      </td>
    </tr>
  </table>
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe> 
</body>
</html>
