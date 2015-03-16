<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<script>

function addCourse()
	{	
	
	alert('Add Course');
	var courseNameId = document.getElementById('courseNameId').value;
	var categoryId = document.getElementById('categoryId').value;
	var sessionsId = document.getElementById('sessionsId').value;
	var fileId=document.getElementById('fileId').value;
	
	if(courseNameId == null || courseNameId =="" || 
			categoryId == null || categoryId =="" ||
			sessionsId == null || sessionsId =="" ||
			fileId == null || fileId =="")
		{
			alert("Please make sure all fields are filled");
			
			return false;
		}
	
	
	if (isNaN(sessionsId))
	{
	    alert("Please make sure Number of Sessions should be a whole number");
	    document.getElementById('answerNumberId').focus();
	    return false;
	} 
	
	else{
	alert('Add Course');
	document.courseForm.action="courseAction.do?method=addCourse";
	document.courseForm.enctype="multipart/form-data";
	document.courseForm.submit();
	}
	
	}	

function clear()
	{	
		alert('clear');
		
		document.getElementById('courseNameId').value=" ";
		document.getElementById('categoryId').value=" ";
		document.getElementById('sessionsId').value=" ";
		
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
 <section id="main-content">
          <section class="wrapper">


		
		<html:form action="/courseAction" >

			<div class="body-content">
			
				<div class="courseHeader">Add Course</div>
				<div class="personaltable">
					<table>
					<logic:notEmpty name="courseForm" property="courseAddedMessage"><tr> <td><bean:write name="courseForm" property="courseAddedMessage" /></td></tr>
						<tr></logic:notEmpty>
		<td><font color="red">*</font>Enter Course Name</td>
		<td><html:text name="courseForm"
				property="courseName" size="30" styleId="courseNameId" styleClass="login-input" maxlength="255" /></td>
	</tr>
	<tr>
		<td><font color="red">*</font>Category</td>
		<td><html:text name="courseForm"
				property="category" size="30" styleId="categoryId" styleClass="login-input" maxlength="255"/></td>
	</tr>
	<tr>
		<td><font color="red">*</font>Number of Sessions</td>
		<td><html:text name="courseForm"
				property="sessions" size="30" styleId="sessionsId" styleClass="login-input"  maxlength="2" /></td>
	</tr>
	
	<tr>
		<td><font color="red">*</font>Upload Course Contents</td>
	<td><html:file property="file" styleId="fileId" styleClass="login-input"  /></td>
	</tr>
	
	<tr>
		<td><html:button property="addBtn" styleClass="loginBtn" value="Add" onclick="addCourse();" /></td>
		<td><html:button property="clearBtn" styleClass="loginBtn" value="Clear" onclick="this.form.reset();"/></td>
	</tr>
					</table>
				</div>
				</div>
				
			</html:form>
		</div>
	 </section>
 </section>
