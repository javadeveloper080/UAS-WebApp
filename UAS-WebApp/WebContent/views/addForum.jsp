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
	function addForum() {

		courseIdValue = document.getElementById('courseId').value;
		forumNameValue = document.getElementById('forumNameId').value;
		topicValue = document.getElementById('topicId').value;

		if (forumNameValue == null || forumNameValue == ""
				|| topicValue == null || topicValue == ""
				|| courseIdValue == null || courseIdValue == ""
				|| courseIdValue == "0") {
			alert("Please make sure all fields are filled");
			return false;
		} else {

			alert('Add a Forum');

			document.forumMasterForm.action = "forumMasterAction.do?method=addForum";
			document.forumMasterForm.submit();
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
				<li><a href="adminAction.do?method=adminAddPage">Add an
						Administrator</a></li>
				<li><a href="courseAction.do?method=displayCourses">Courses</a></li>
				<li><a href="courseAction.do?method=courseAddPage">Add a
						course</a></li>
				<li><a
					href="courseAction.do?method=displayCourses&pageName=ModifyCourse">Modify
						course</a></li>
				<li><span><a
						href="questionAction.do?method=addQuestionPage">Create exam
							question</a></span></li>
				<li><a href="loginAction.do?method=logOutAction">Logout</a></li>
			</ul>
		</div>
		<div id="body">
			<html:form action="/forumMasterAction">

				<div class="body-content">

					<div class="courseHeader">Add Forum for a Course</div>
					<div class="personaltable">
						<table>

							<tr>
								<td><font color="red" size="3px">*</font>Course Id</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:select property="courseId" styleId="courseId">
										<html:option value="0">Select a Course Id</html:option>
										<html:optionsCollection name="forumMasterForm"
											property="courseKeyList" label="courseKey" value="id" />
									</html:select> <br /> <label style="padding-top: 10px; color: #ADADAD;">(Select
										a Course Id)</label><br /></td>
							</tr>



							<tr>
								<td><font color="red" size="3px">*</font>Forum Name</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="forumMasterForm" property="forumName"
										size="60" maxlength="60" styleId="forumNameId" />
									<td>
							</tr>



							<tr>
								<td><font color="red" size="3px">*</font>Topic</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:textarea name="forumMasterForm" property="topic"
										rows="10" cols="20" styleId="topicId" />
									<td>
							</tr>



							<tr>
								<td>&nbsp;</td>

								<td><html:button property="addBtn" styleClass="loginBtn"
										value="Add" onclick="return addForum();" /></td>

								<td><html:reset property="resetBtn" styleClass="loginBtn"
										value="Reset" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</div>
				</div>

			</html:form>
		</div>
	</div>
</body>
</html>
