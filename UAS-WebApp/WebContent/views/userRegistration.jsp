<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Virtual Learning Environment</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<style type="text/css">
</style>
<script>

function userRegistrationAction()
	{	
	alert('register');
	
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var gender = document.getElementById('gender').value;
	var addressLine1 = document.getElementById('addressLine1').value;
	var addressLine2 = document.getElementById('addressLine2').value;
	var city = document.getElementById('city').value;
	var country = document.getElementById('country').value;
	var pin = document.getElementById('pin').value;
	var mobile = document.getElementById('mobile').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if(firstName == null || firstName =="" || 
			lastName == null || lastName =="" ||
			gender ==""  || 
			addressLine1 == null || addressLine1 =="" || 
			addressLine2 == null || addressLine2 =="" || 
			city == null || city =="" || 
			country == null || country =="" || 
			pin == null || pin =="" || 
			mobile == null || mobile =="" || 
			email == null || email =="" || 
			password == null || password =="")
		{
			alert("Please make sure all fields are filled");
			
			return false;
		}
	if (!filter.test(email)) {
		alert('Please provide a valid email address');
		document.getElementById('email').focus;
		return false;
	}
	
	if(isNaN(mobile)){
		alert('Please Enter Numeric value for Mobile');
		document.getElementById('mobile').focus;
		return false;

	}
	if(isNaN(pin)){
		alert('Please Enter Numeric value for PinCode');
		document.getElementById('pin').focus;
		return false;

	}
        
        function checkEmail() {
		email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
		alert('Please provide a valid email address');
		email.focus;
		return false;
		} else {
			   emailValue=email.value;
			  hp=createObject();
			   hp.open("GET",url,false);
			   hp.onreadystatechange=callMe;
			   hp.send(null);
		}
	}
	function isNumberKey(evt)
	{
	   var charCode = (evt.which) ? evt.which : event.keyCode;
	   if (charCode != 46 && charCode > 31 
	     && (charCode < 48 || charCode > 57))
	      return false;
	
	   return true;
	}

	else{
	
	document.userForm.action="userAction.do?method=userRegistrationAction";
	document.userForm.submit();
	}
	
	}	
	
	$(function() {
		$( "#dob" ).datepicker({
			 showOn: "button",
			 buttonImage: "images/calendar.gif",
			 buttonImageOnly: true,
			changeMonth: true,
			changeYear: true
		});
		});
	function checkEmail() {
		email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!filter.test(email.value)) {
		alert('Please provide a valid email address');
		email.focus;
		return false;
		} else {
			   emailValue=email.value;
			  hp=createObject();
			   hp.open("GET",url,false);
			   hp.onreadystatechange=callMe;
			   hp.send(null);
		}
	}
	function isNumberKey(evt)
	{
	   var charCode = (evt.which) ? evt.which : event.keyCode;
	   if (charCode != 46 && charCode > 31 
	     && (charCode < 48 || charCode > 57))
	      return false;
	
	   return true;
	}
	function formSubmit()
	{
	document.getElementById("frm1").submit();
	}
		$("document").ready(function(){
		$("#login_usn").focus(function(){
			 $("#login_usn").css("border","1px solid red");
		});
		$("#login_usn").blur(function(){
			 $("#login_usn").css("border","0px solid red");
		});
		$("#login_Pass").focus(function(){
			 $("#login_Pass").css("border","1px solid red");
		});
		$("#login_Pass").blur(function(){
			 $("#login_Pass").css("border","0px solid red");
		});
	});
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				Virtual <strong>Learning</strong> Environment <span>EARN MORE
					KNOWLEDGE</span>
			</div>
		</div>
		<div id="body">
		<html:form action="/userAction" >

			<div class="body-content">
			
				<div class="courseHeader">Personal Details</div>
				<div class="personaltable">
					<table>
						<tr>
							<td><font color="red" size="3px">*</font>First Name</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="firstName" size="30" id="firstName" /></td>
							<td>&nbsp;&nbsp;&nbsp;<font color="red" size="3px">*</font>Last Name</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="lastName" size="30" id="lastName"/></td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Gender</td>
							<td>&nbsp;:&nbsp;</td>
							<td><select name="gender" class="" id="gender">
									<option value="">...Select Please...</option>
									<option value="Female">Female</option>
									<option value="Male">Male</option>
									<option value="Undefine">Undefine</option>
							</select></td>
						</tr>
						
						<tr>
							<td><font color="red" size="3px">*</font>User Type</td>
							<td>&nbsp;:&nbsp;</td>
							<td>
							<html:select property="userTypeId">
							<html:optionsCollection name="userForm" property="userTypeList"
								label="value" value="id" />
						</html:select>
							</td>
						</tr>
					</table>
				</div>
				<div class="courseHeader">Contact Details</div>
				<div class="contacttable">
					<table>
						<tr>
							<td><font color="red" size="3px">*</font>Address Line1</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="addressLine1" size="30" id="addressLine1"/></td>
							<td>&nbsp;&nbsp;&nbsp;<font color="red" size="3px">*</font>Address Line2</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="addressLine2" size="30" id="addressLine2"/></td>
						</tr>

						<tr>
							<td><font color="red" size="3px">*</font>City</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="city" id="city" size="30" /></td>
							<td>&nbsp;&nbsp;&nbsp;<font color="red" size="3px">*</font>State</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="state" id="state" size="30" /></td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Country</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="country" id="country" size="30" /></td>
							<td>&nbsp;&nbsp;&nbsp;<font color="red" size="3px">*</font>Pin</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="pin" id="pin" size="30"
								maxlength="6" onkeypress="return isNumberKey(event)" /></td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Mobile</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="mobile" id="mobile" size="30"
								maxlength="10" onkeypress="return isNumberKey(event)" /></td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Email</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="email" id="email" size="30" maxlength="30"
								onblur="return checkEmail()" placeholder="abc@gmail.com" /><br />
								<label style="padding-top: 10px;color:#ADADAD;">(Here email id is
									going to use as userid)</label>
							<div id="errorDiv" style="color: red; font-size: 9px"></div></td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Password</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="password" name="passWord" id="password" size="30"
								 maxlength="15" /><br />
								<label style="padding-top: 10px;color:#ADADAD;">(Here password musr be more than 8 characters.)</label><br />
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!-- <td align="right"><a href="" class="loginBtn" >Submit</a></td> -->
							<td></td>
							<td align="right"><html:button  property="loginBtn" styleClass="loginBtn" value="Register" onclick="userRegistrationAction();"/></td>
						</tr>
						
					</table>
				</div>
			</div>
			</html:form>
		</div>
	</div>
</body>
</html>
