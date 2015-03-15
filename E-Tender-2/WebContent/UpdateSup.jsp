
<script language="javascript" >

function Dispose()
{
    self.close();
    


}

function CheckInput()
{
     if (f1.sname.value=="")
     {
         alert("Please Enter Supplier Name");
         f1.sname.focus();
         return false;
     }
     else if (f1.address.value=="")
     {
         alert("Please Enter Address");
         f1.address.focus();
         return false;
     }
     else if (f1.phno.value=="")
     {
         alert("Please Enter Phone Number");
         f1.phno.focus();
         return false;
     }
     else if ((f1.email.value=="") || (f1.email.value==" "))
     {
         alert("Please Enter E-mail ID");
		 f1.email.value=""
         f1.email.focus();
         return false;
     }
	 else if (echeck(f1.email.value)==false)
 	 {
		f1.email.value="";
		f1.email.focus();
		return false
	 }
     else if (f1.rem.value=="")
     {
         alert("Please Enter Remarks");
         f1.rem.focus();
         return false;
     }

}
function echeck(str)
{

		var at="@"
		var dot="."
		var lat=str.indexOf(at)
		var lstr=str.length
		var ldot=str.indexOf(dot)
		if (str.indexOf(at)==-1){
		   alert("Invalid E-mail ID")
		   return false
		}

		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr)
		{
		   alert("Invalid E-mail ID")
		   return false
		}

		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr)
		{
		    alert("Invalid E-mail ID")
		    return false
		}

		 if (str.indexOf(at,(lat+1))!=-1){
		    alert("Invalid E-mail ID")
		    return false
		 }

		 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		    alert("Invalid E-mail ID")
		    return false
		 }

		 if (str.indexOf(dot,(lat+2))==-1){
		    alert("Invalid E-mail ID")
		    return false
		 }

		 if (str.indexOf(" ")!=-1){
		    alert("Invalid E-mail ID")
		    return false
		 }

 		 return true
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

function onlychar(obj)
{
     str=obj.value;
     ch=str.charAt(str.length-1)
     if ( !(( ch>='a' && ch<='z') || ( ch>='A' && ch<='Z') ) && ch!=' ')
          obj.value=str.substring(0,str.length-1)
                
           len=obj.value;
	  	  	        
	  	  	      
}



function onlychar1(obj)
{

     str=obj.value;
     ch=str.charAt(str.length-1)
     if ( !(( ch>='a' && ch<='z') || ( ch>='A' && ch<='Z') ) && ch!=' ')
          obj.value=str.substring(0,str.length-1)
                
           
	  	  	        
	  	  	       
}


function Length(obj)
{
                       len=obj.value;
	  	        if(len.charAt(len.length-1)==" ")
	  	        {
	  	           alert("Spaces are not Allowed");
	  	           obj.value=len.substring(0,len.length-1);
	  	        }
	  	        if(len.length>10)
	  	        {
	  	             alert("Length Should Be Lessthan or eqaul to 10 characters");
	  	             obj.value=len.substring(0,len.length-1);
                         }

}
function Length1(obj)
{
                       len=obj.value;
	  	       
	  	        if(len.length>100)
	  	        {
	  	             alert("Length Should Be Lessthan or eqaul to 100 characters");
	  	             obj.value=len.substring(0,len.length-1);
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
<body bgcolor=lightblue >
<strong><font size="5" face="Courier New, Courier, mono">SUPPLIER MODIFICATION </font></strong></p>
<LINK href="css/styles.css" type=text/css rel=stylesheet>
<form name="f1" method="post" action="SupUpdate" >
<table border="0" cellpadding="5" cellspacing="1">

<%@page import="java.sql.*,EPR.*" %>
<%
 Connection con=null;
 ResultSet rs=null;
 
 try 
 {
        
        
         ConnectionBean CBean=new ConnectionBean();
	 con=CBean.getConnection();
	 Statement stmt = null;
	 String sid=request.getParameter("pid");
	
	stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	rs = stmt.executeQuery("select sup_id,name,gen,address,phno,email,remarks,scat from supplier_info where sup_id='" + sid + "'");
	  
	 rs.next();
   
 } 
 catch(Exception e) 
 {
   out.println(e);
 }	
 
 
 
 %>
 
 
 
 
<tr>
<td><b>Supplier ID </b></td>
<td><input type="text" name="supid" value=<%=rs.getString(1) %> readonly ></td>
</tr>


<tr>
<td><b>Supplier Name</b></td>
<td><input  type="text"  name="sname"  value=<%=rs.getString(2) %> maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)" ></td></tr><tr>
</tr>

<tr>
<td><b>Gender</b></td>
<td><select name=gen>

<%
    String gen=rs.getString(3);
       
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
    </SELECT>
    
</tr>


<tr>
<td><b>Address</b></td>
<td><textarea name="address"   rows=5 cols=20 maxlength=100><%=rs.getString(4)%> </textarea></td>
</tr>
<tr>
<td><b>Phone Number</b></td>
<td><input type="text" name="phno" value=<%=rs.getString(5) %>  onkeyup="NoCheck(this)"  onblur="Check(this)" maxlength=12></td></tr><tr>
</tr>
<tr>

<td><b>Email</b></td>
<td><input type="text" name="email" value=<%=rs.getString(6)%>  maxlength=40></td>
</tr>
<td>
<tr>
<td><b>Remarks</b></td>
<td><input type="text" name="rem" value=<%=rs.getString(7)%> maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)"></td>
</tr>

<tr>
<td><b>Supplier Catagory</b></td>
<td><select name="scat">
<%
   
  String dept=rs.getString(8);
   
   
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
            
         
         
         



</select>


</td>
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
