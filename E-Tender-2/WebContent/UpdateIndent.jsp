<script>
function GetId()
{
 
 
 
 f1.itid1.options[f1.itid.value-1].selected=true;
 f1.itid.value=f1.itid1.selectedIndex+1;
 
 document.getElementById("txt").style.visibility='hidden';
 
}
function CheckInput()
{
	var sel=0;
	var sel1=0;
	if(f1.indt.value!="")
	{
		sel=1;
	}
	if(f1.deldt.value!="")
	{
		sel1=1;
	}
	if (f1.indt.value=="")
	{
	     alert("Please select the Indent date");
	     f1.indt.focus();
	     return false;
	}
	else if (f1.itid1.selectedIndex==0)
	{
	     alert("Please select Item Name");
	     f1.itid1.focus();
	     return false;
	}
	else if (f1.qreq.value=="")
	{
	     alert("Enter the Required Quality");
	     f1.qreq.focus();
	     return false;
	}
	else if (f1.deldt.value=="")
	{
	     alert("Please select the Indent date");
	     f1.deldt.focus();
	     return false;
	}
	else if (f1.estrt.value=="")
	{
	     alert("Enter the Estimated Rate");
	     f1.estrt.focus();
	     return false;
	}else if(sel==1)
     {
   
  		  var Date1=new Date();
   		  var Date2=new Date();
  		  dt1=f1.indt.value;
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
   
   
  		 if(Date1>Date2)
 		 {
  			  alert("Indent Date Should Not be Greater than Current Date");
   			  return false;
     
  		 }
		 
   
 	}
	 if(sel1==1)
     {
   
  		  var Date1=new Date();
   		  var Date2=new Date();
  		  dt1=f1.deldt.value;
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
  			  alert("Delivery Date Should Not be Lesser than or Equal Current Date and Indent Date");
   			  return false;
     
  		 }
		 else
		 {
		 	  return true;
		 }
   
 	}
	
}
function GetSet()
{

f1.itid.focus();
}

function Close()
{
  self.close();
}

function GetItemId()
{

 f1.itid.value=f1.itid1.selectedIndex+1;
 
}

function Check(obj)
{
len=obj.value;
var colors=new Array("`","~","!","@","#","$","%","^","&","*","(",")","_","+","<",">","/","?","}","{","[","]","'",";","=","-","|",",","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
for(j=0;j<=len.length-1;j++)
{
var char=len.substring(j,j+1);
for(i=0;i<=colors.length-1;i++)
{
 var sNumber=colors[i];
 if(sNumber==char)
 {
  obj.value="";
  obj.focus();
  
  return false;
 }
}
}
if(obj.value.length==0)
{
   return false;
}
string_value=obj.value;
var whitespace = " \n\r\t\."
var existed="No";
var Valid="No";
for (var counter = 0; counter < string_value.length; counter++) 
 {
      // Get the current character
      current_char = string_value.charAt(counter)
      // If it's not in the whitespace characters string,
      // return false because we found a non-whitespace character
      if(whitespace.indexOf(current_char) =="") 
      {
  	    var existed="Yes";
      }else if(whitespace.indexOf(current_char) ==-1) 
      {
  	     existed="No";
  	     Valid="Yes";
  	     break;
      }
    }
    if(existed=="No" && Valid=="Yes")
    {
        existed="Yes";
   	  Valid="No";
   	  return false;
    }else
    {
  		 obj.value="";
  		  existed="Yes";
  		  Valid="No";
  		  obj.focus();
  		  return false;
  	
    }

}


function NoCheck(obj)
{
n=event.keyCode;
len=obj.value;
if((n<=57 && n>=48) ||  n==8 || (n<=105 && n>=96) || n==46 ||(n>=33 && n<=36) || (n==37) || (n==18) ||(n==92) ||(n==93) ||(n==17) ||(n==145) ||(n==19) ||(n==144) ||(n==35)|| (n==46)||(n==45)||(n==40)|| (n==38) || (n==39) || (n==9))
{

}else
{
 obj.value="";

}

}

</script>


<html>
<head>

</head>
<body bgcolor=lightblue onload="GetSet()" >
<LINK href="css/styles.css" type=text/css rel=stylesheet>
<%@page import="java.sql.*,java.util.Date,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 ResultSet rs1=null;
  String indno=null;
  Statement stmt = null;
  Statement stmt1 = null;
  String iname=null;
   String itid=null;
   String dt="";
   
	

   
 try 
 {
         
           
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 indno=request.getParameter("pid");
	 System.out.println(indno);
	
	 stmt = con.createStatement();
	 stmt1 = con.createStatement();
	 rs = stmt.executeQuery("select inm.ind_no,to_char(inm.inddate,'dd-mon-yyyy'),to_char(inm.delv_date,'dd-mon-yyyy'),inm.est_rate,inm.status from indent_master inm where inm.ind_no=" + indno + " ");
	 rs.next();
         indno=rs.getString(1);
         
     
         rs1=stmt1.executeQuery("select to_char(sysdate,'dd-Mon-yyyy') from dual");       
	          
	 rs1.next();
	          
	 dt=rs1.getString(1);
         rs1.close();
         
       }catch(Exception Ex)
	   {
	   
	   }
	      
 %>
  
              	

<strong><font size="5" face="Courier New, Courier, mono">INDENT MODYFICATION</font></strong></p>



<form name="f1" method="post" action="UpdateIndent" onsubmit="return CheckInput()">



  <table border="0" cellpadding="5" cellspacing="1" >
    <tr> 
      <td><b>Indent No</b></td>
      <td>
        <input type="text" name="indno" value="<%=indno%>" readonly>
        <input type="hidden" name="sysdate" value="<%=dt%>" >
      </td>
    </tr>
    <tr> 
      <td><b>Indent Date</b></td>
      <td>
        <input type="text" name="indt" readonly value="<%=rs.getString(2)%>" maxlength=30 ><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.indt);
  				 return false;" HIDEFOCUS tabIndex=5>
        <img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""> </a>
      </td>
    </tr>
    <tr> 
      <td><b>Delevery Date</b></td>
      <td>
        <input type="text" name="deldt" readonly value="<%=rs.getString(3)%>" maxlength=30 ><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.deldt);
  			 return false;" HIDEFOCUS tabIndex=5>
        <img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""> </a>
      </td>
    </tr>
    <tr> 
      <td><b>Estimated Rate</b></td>
      <td>
        <input type="text" id="it" name="estrt" value="<%=rs.getString(4)%>" onkeyup="NoCheck(this)"  onblur="Check(this)" maxlength=12>
      </td>
    </tr>
    <td> 
      
    <td colspan=4>
      <input name="Add" type="submit" id="Add" value="Update" >
      &nbsp;&nbsp;&nbsp;&nbsp; 
      <input name="clear" type="reset" id="clear" value="Close" onclick="Close()">
    </td>
    </tr>
  </table>
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe> 
</body>
</html>
