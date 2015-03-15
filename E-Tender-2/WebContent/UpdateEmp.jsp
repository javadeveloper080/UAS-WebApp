


<script language="javascript" >


function Dispose()
{
    self.close();
    


}


function CheckInput()
{
	 var sel=0;
	 if(f1.dob.value!="")
	 {
	 	  sel=1;
	 }
	 if (f1.ename.value=="")
     {
          alert("Please Enter Employee Name");
          return false;
     }
     else if(f1.gen.selectedIndex==0)
     {
           alert("Please Select Gender");
           return false;
     }
     else if (f1.phno.value=="")
     {
         alert("Please Enter Phone Number");
         return false;
     }
	 else if (f1.address.value=="")
     {
         alert("Please Enter Address");
         return false;
     }
         else if (f1.qlfy.value=="")
     {
         alert("Please Enter Qualification");
         return false;
     }else if(f1.dob.value=="")
     {
           alert("Please Select Date");
           return false;
     }else if(f1.desg.value=="")
     {
           alert("Please Enter desgination");
           return false;
     }else if(sel==1)
     {
     		  var Date1=new Date();
   		  var Date2=new Date();
  		  dt1=f1.dob.value;
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
  			  alert("Join Date Should Not be Greater than Current Date");
   			  return false;
     
  		 }
		 else
		 {
		 	  return true;
		 }
   
 	}


}

function onlyno(obj)
{
     phno=obj.value;
     no=phno.charAt(phno.length-1)
     if ( isNaN(no) && no!='-' )
          obj.value=phno.substring(0,phno.length-1)
          
          len=obj.value;
	  	  	  	        if(len.charAt(len.length-1)==" ")
	  	  	  	        {
	  	  	  	           alert("Spaces are not Allowed");
	  	  	  	           obj.value=len.substring(0,len.length-1);
	  	  	  	        }
	  	  	  	        if(len.length>12)
	  	  	  	        {
	  	  	  	             alert("Length Should Be Lessthan or eqaul to 12 characters");
	  	  	  	             obj.value=len.substring(0,len.length-1);
                         }
}



function CharCheck(obj)
{
len=obj.value;


len=obj.value;

if(len.charAt(0)==" " || len.charAt(0)=="."  )
{
  var oldvalue=len.substring(1,len.length);
  obj.value=oldvalue;
}

n = event.keyCode;



len=obj.value;


if((n>=65 && n<=90)|| (n>=33 && n<=36) || (n==37) || (n==18) ||(n==92) ||(n==93) ||(n==17) ||(n==145) ||(n==19) ||(n==144) ||(n==35)|| (n==46)||(n==45)||(n==40)|| (n==38) || (n==39)||(n==32) || (n==8) || (n==110) || (n==190) || (n==20) || (n==9) || (n==16) || n==36)
{
	
	
}else
{
  obj.value="";
  return false;
}
}

function its_whitespace(obj)
{
len=obj.value;
var colors=new Array("~","`","!","@","#","$","%","^","&","*","(",")","_","+","<",">","/","?","}","{","[","]","'",";","=","-","|",",","1","2","3","4","5","6","7","8","9","0");
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

	
  // These are the whitespace characters
  var whitespace = " \n\r\t\."
  var existed="No";
  var Valid="No";
  
  
  
  
  // Run through each character in the string
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
</script>
<html>
<head>

</head>
<body bgcolor=lightblue >
<strong><font size="5" face="Courier New, Courier, mono">EMPLOYEE MODIFICATION</font></strong></p>
<LINK href="css/styles.css" type=text/css rel=stylesheet>
<form name="f1" method="post" action="EmpUpdate" >
<table border="0" cellpadding="5" cellspacing="1">


<%@page import="java.sql.*,java.util.Date,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 String dt="";
 


 try 
 {
        
        
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 String empid=request.getParameter("pid");
	
	stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	  rs=stmt.executeQuery("select to_char(sysdate,'dd-Mon-yyyy') from dual");       
          rs.next();
	  dt=rs.getString(1);
          rs.close();
         
         
	
	rs = stmt.executeQuery("select emp_id,pwd,name,gen,phno,address,qlfy,to_char(doj,'dd-mon-yyyy'),desg,dept from employee_info where emp_id='" + empid +"' ");
	 rs.next();
   
 } 
 catch(Exception e) 
 {
   out.println(e);
 }	
 
 
 
 %>
 
<tr>
<td><b>Employee ID </b></td>
<td><input type="text" name="empid" readonly value=<%=rs.getString(1)%> maxlength=10>
        <input type="hidden" name="sysdate" value="<%=dt%>" >
      </td>
</tr>


<tr>

<td><b>Employee Name</b></td>
<td><input  type="text"  name="ename"  maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)" value=<%=rs.getString(3)%>></td></tr><tr>
</tr>

<tr>
<td><b>Gender</b></td>
<td><select name=gen>
    <option>--Select--></option>
    
    <%
    String gen=rs.getString(4);
       
    if(gen.equals("Male"))
    {
    %>
    
    <option selected>Male</option>
    <option>Female</option>
    
    <%
    }else
    {
    
    %>
    <option>Male</option>
    <option selected>Female</option>
    
    <%
    }
    
    %>
    
    
    </select>
    
    
</td>
</tr>



<tr>
<td><b>Phone Number</b></td>
<td><input type="text" name="phno" onkeyup="onlyno(phno)" value=<%=rs.getString(5)%> maxlength=12></td></tr><tr>
</tr>
<tr>
<td><b>Address</b></td>
<td><textarea name="address" rows=5 cols=20 maxlength=100><%=rs.getString(6)%></textarea></td>
</tr>

<tr>

<td><b>Qualification</b></td>
<td><input type="text" name="qlfy" maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)" value=<%=rs.getString(7)%>></td>
</tr>
<tr>
  <td><b>Date Of Joining</b></td>
             <td><input type="text" name="dob" readonly value="<%=rs.getString(8)%>" maxlength=30 >
          <a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.dob);
  				 return false;" HIDEFOCUS tabIndex=5>
			<img name="popcal" align="absmiddle" src="Calendar\calbtn.gif" width="34" height="22" border="0" alt=""></a>
		</td>	
</tr>
<td>
<tr>
<td><b>Designation</b></td>
<td><input type="text" name="desg" value=<%=rs.getString(9)%> maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)"></td>
</tr>



<tr>
      <td><b>Department</b></td>
	  <td><select name=dept>
   
   
   
   
    <%
   
       String dept=rs.getString(10);
   
   
   if(dept.equals("TRAINING DEVELOPMENT"))
   {
     
   %>
   
   <option selected>TRAINING DEVELOPMENT</option>
   <%
   }else
   {
   %>
   <option >TRAINING DEVELOPMENT</option>
   
   <%
   }
   
     
     if(dept.equals("WIRE ROD MILL"))
      {
        
      %>
      
      <option selected>WIRE ROD MILL</option>
      <%
      }else
      {
      %>
      <option >WIRE ROD MILL</option>
      
      <%
      }
   if(dept.equals("BLAST FURNACE"))
         {
           
         %>
         
         <option selected>BLAST FURNACE</option>
         <%
         }else
         {
         %>
         <option >BLAST FURNACE</option>
         
         <%
         }
         if(dept.equals("STEEL MELTING SHOP"))
         {
         %>
         <option selected>STEEL MELTING SHOP</option>
         <%
            }else
            {
            %>
            <option >STEEL MELTING SHOP</option>
            
            <%
            }
         if(dept.equals("THERMAL POWER PLANT"))
               {
                 
               %>
               
               <option selected>THERMAL POWER PLANT</option>
               <%
               }else
               {
               %>
               <option >THERMAL POWER PLANT</option>
               
               <%
               }
               %>
            
         
      
    
          
    </select></td>
	
    </tr>
<td colspan=4><input name="Add" type="submit" id="Add" value="Update" onclick="return CheckInput()">
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input name="clear" type="reset" id="clear" value="Close" onclick="Dispose()">
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
