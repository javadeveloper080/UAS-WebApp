
<jsp:include page="AdminHeader.jsp" />

<script>
function CheckInput()
{
     if (f1.supid.value=="")
     {
         alert("Please Enter Supplier Id");
         f1.supid.focus();
         return false;
     }
     else if (f1.pwd.value=="")
     {
     	 alert("Please Enter Password");
     	 f1.pwd.focus();
     	 return false;
     }
     else if (f1.sname.value=="")
     {
         alert("Please Enter Supplier Name");
         f1.sname.focus();
         return false;
     }
     else if (f1.gen.selectedIndex==0)
     {
         alert("Select the Gender");
         f1.gen.focus();
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

function validateuserid(obj)
{
	
	var string_value=obj.value;
	var user=obj.value;
	
	its_whitespace1(obj);
	
	var oXMLHTTP = new ActiveXObject( "Microsoft.XMLHTTP" );
	var sURL = "./CheckUser?user=" + user
	oXMLHTTP.open( "POST", sURL, false );
	oXMLHTTP.send();
	var  status=oXMLHTTP.responseText;
	var s=status;
	
	var str="a";
	
	
	if(s.charAt(0)==str)
        {
        alert(s);
        
         f1.txtlogin.value="";
         
	 f1.txtlogin.focus();
        }
        
        	
}
function its_whitespace3(obj)
{
len=obj.value;
var colors=new Array("~","`","!","@","#","$","%","^","&","*","(",")","_","+","<",">","/","?","}","{","[","]","'",";","=","-","|",",");

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
function setfocus()
{

f1.supid.focus();


}

</script>

<html>
<head>

</head>
<body bgcolor=lightblue onload="setfocus()"><p>
<strong><font size="5" face="Courier New, Courier, mono">SUPPLIER REGISTRATION </font></strong></p>

<form name="f1" method="post" action="SupRegister" onsubmit="return CheckInput()">
<table border="0" cellpadding="5" cellspacing="1">
<tr>
<td><b>Supplier ID </b></td>
<td><input type="text" name="supid" onblur=its_whitespace3(this) maxlength=10></td>
</tr>

<tr>
<td><b>Password</b></td>
<td><input type="password" name="pwd" maxlength=10></td>
</tr>

<tr>

<td><b>Supplier Name</b></td>
<td><input  type="text"  name="sname"  maxLength=30 onkeyup="CharCheck(this)" onblur="its_whitespace(this)" ></td></tr><tr>
</tr>

<tr>
<td><b>Gender</b></td>
<td><select name=gen>
    <option>--Select--></option>
    <option>Male</option>
    <option>Female</option>
    </select>
</td>
</tr>


<tr>
<td><b>Address</b></td>
<td><textarea name="address" rows=5></textarea></td>
</tr>


<tr>
<td><b>Phone Number</b></td>
<td><input type="text" name="phno" onkeyup="NoCheck(this)"  onblur="Check(this)" maxlength=13></td></tr><tr>
</tr>

<tr>
<td><b>Email</b></td>
<td><input type="text" name="email"  maxlength=40></td>
</tr>
<tr>
<td><b>Remarks</b></td>
<td><textarea name="rem" rows=5 onkeyup="CharCheck(this)" onblur="its_whitespace(this)"></textarea></td>
</tr>
<tr>
<td><b>Supplier Catagory</b></td>
<td>
<select name="scat">
<option><--Slect Catagory--></option>

    <option>TRAINING DEVELOPMENT</option>
    <option>WIRE ROD MILL</option>
    <option>BLAST FURNACE</option>
	<option>STEEL MELTING SHOP</option>
    <option>THERMAL POWER PLANT</option>
</select>


</td>
</tr>


<tr>
<td colspan=4><input name="Add" type="submit" id="Add" value="Add" >
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input name="clear" type="reset" id="clear" value="Clear">
</td>
</tr>


</table>
</form>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe> 
</body>
</html>