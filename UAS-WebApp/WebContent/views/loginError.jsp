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

function selectedCourseExam()
	{	
	alert('Start Exam');
	
	document.examForm.action="examAction.do?method=selectedCourseExam";
	document.examForm.submit();
	
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
			<html:form action="/loginAction">

				<div class="body-content">

					<div class="personaltable">
						<table>
							<logic:notEmpty name="loginForm" property="loginMessage">
								<tr>
									<td><bean:write name="loginForm"
											property="loginMessage" /></td>
								</tr>
								<tr>
							</logic:notEmpty>
						</table>
					</div>
				</div>

			</html:form>
		</div>
	</div>
</body>
</html>
