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
	function createAdminAction() {

		nameValue = document.getElementById('adminName').value;
		passwordValue = document.getElementById('password').value;
		var emailValue = document.getElementById('email').value;
		alert(emailValue);

		var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		if (nameValue == null || nameValue == "" || passwordValue == null
				|| passwordValue == "" || emailValue == null
				|| emailValue == "") {
			alert("Please make sure all fields are filled");
			return false;
		}

		if (!passwordValue.match(passw)) {
			alert("Password must be 6 to 15 characters which contain at least one numeric digit, one uppercase and one lowercase letter.");
			document.getElementById('password').focus();
			return false;
		}

		if (!filter.test(emailValue)) {
			alert('Please provide a valid email address');
			document.getElementById('email').focus;
			return false;
		}

		else {
			document.adminForm.action = "adminAction.do?method=createAdmin";
			document.adminForm.submit();
		}

	}
</script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				Virtual <strong>Learning</strong> Environment <span>EARN MORE
					KNOWLEDGE</span>
			</div>
			<ul id="navigation">
				<li><a href="loginAction.do?method=userLoginPage">Home</a></li>
				<li><span><a href="adminAction.do?method=adminAddPage">Add
							an Administrator</a></span></li>
				<li><a href="courseAction.do?method=displayCourses">Courses</a></li>
				<li><a href="courseAction.do?method=courseAddPage">Add a
						course</a></li>
				<li><a
					href="courseAction.do?method=displayCourses&pageName=ModifyCourse">Modify
						course</a></li>
				<li><a href="questionAction.do?method=addQuestionPage">Create
						exam question</a></li>
						<li><a href="forumMasterAction.do?method=getForumPage">Forum</a></li>
				<li><a href="loginAction.do?method=logOutAction">Logout</a></li>
			</ul>
		</div>
		<div id="body">
			<html:form action="/adminAction">

				<div class="body-content">

					<div class="courseHeader">Add an Administrator</div>
					<div class="personaltable">
						<table>
						
						
						<logic:notEmpty name="adminForm"
								property="message">
								<tr>
									<font color="red" size="3px"><bean:write name="adminForm"
											property="message" /></font>
								</tr>
								<tr>
							</logic:notEmpty>
						
							<tr>
								<td><font color="red" size="3px">*</font>Name</td>
								<td>&nbsp;:&nbsp;</td>
								<td><input type="text" name="adminName" size="30"
									maxlength="30" id="adminName" /></td>
							</tr>


							<tr>
								<td><font color="red" size="3px">*</font>Email</td>
								<td>&nbsp;:&nbsp;</td>
								<td><input type="text" name="email" id="email" size="30"
									placeholder="abc@gmail.com" /><br/></td>
							</tr>
							<tr>
								<td><font color="red" size="3px">*</font>Password</td>
								<td>&nbsp;:&nbsp;</td>
								<td><input type="password" name="passWord" id="password"
									size="30" maxlength="15" /><br /> <label
									style="padding-top: 10px; color: #ADADAD;">(Password
										must be 6 to 20 characters which contain at least one numeric
										digit, one uppercase and one lowercase letter.)</label><br /></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td align="right"><html:button property="loginBtn"
										styleClass="loginBtn" value="Add"
										onclick="return createAdminAction();" /></td>
							</tr>

						</table>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>
