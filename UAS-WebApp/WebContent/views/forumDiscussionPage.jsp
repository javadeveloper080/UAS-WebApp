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
	function addForumComment() {

		var commentValue = document.getElementById('commentId').value;

		if (commentValue == null || commentValue == "") {
			alert("Please make sure all fields comment field is field");
			return false;
		}
		else if(commentValue.length>160){
			alert("Please make sure  comment has a max of 160 charaxters");
			return false;
		}
		

		else {
			alert('Add Comment');
			document.forumMasterForm.action = "forumMasterAction.do?method=addForumComment";
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
				<li><a href="loginAction.do?method=userLoginPage">Home</a></span></li>
				<li><a href="courseAction.do?method=displayCourses">Courses</a></li>
				<li><a href="examAction.do?method=selectCourseExam">Exam</a></li>
				<li><a href="resultAction.do?method=getResults">Results</a></li>
				<li><a href="loginAction.do?method=logOutAction">Logout</a></li>
			</ul>
		</div>
		<div id="body">
			<html:form action="/forumMasterAction">

				<div class="body-content">

					<div class="courseHeader">Forum Details</div>
					<div class="personaltable">
						<table>
							<tr>
								<td><font color="blue" size="3">Course Key</font></td>
								<td>&nbsp;:&nbsp;</td>
								<td><bean:write name="forumMasterForm" property="courseKey" /></td>
								<td>&nbsp;&nbsp;&nbsp;<font color="blue" size="3">Forum Name</font></td>
								<td>&nbsp;:&nbsp;</td>
								<td><bean:write name="forumMasterForm" property="forumName" /></td>
							</tr>
							<tr>
								<td><font color="blue" size="3">Topic</font></td>
								<td>&nbsp;:&nbsp;</td>
								<td><bean:write name="forumMasterForm" property="topic" /></td>
								<td>&nbsp;&nbsp;&nbsp;<font color="blue" size="3">Owner</font></td>
								<td>&nbsp;:&nbsp;</td>
								<td><bean:write name="forumMasterForm" property="ownerName" /></td>
								</td>
							</tr>

							<tr>
								<td>Comment</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:textarea name="forumMasterForm"
										property="comment" rows="10" cols="20" styleId="commentId" />
								<br /><label style="padding-top: 10px; color: #ADADAD;">(Max 160 Comment characters allowed)</label><br />
									<td>
							</tr>

							<html:hidden name="forumMasterForm" property="forumId" />

							<tr>
								<td>&nbsp;</td>

								<td><html:button property="addBtn" styleClass="loginBtn"
										value="submit" onclick="return addForumComment();" /></td>

								<td><html:reset property="resetBtn" styleClass="loginBtn"
										value="Reset" /></td>
								<td>&nbsp;</td>
							</tr>

						</table>
					</div>

					<div class="courseHeader">Forum Discussion</div>
					<div class="personaltable">

						<table width=75% border=1>

							<tr>
								<th>Subscriber Name</th>
								<th>Comment</th>

							</tr>



							<logic:notEmpty name="forumMasterForm"
								property="forumSubscribersDTOList">
								<logic:iterate id="forumSubscribers" name="forumMasterForm" property="forumSubscribersDTOList">
									<tr>
										<td><bean:write name="forumSubscribers" property="subscriberName" /></td>
												
									<td><html:textarea   value="${forumSubscribers.comment }" property="comment"  rows="10" cols="200" readonly="true"/></td>
									</tr>

								</logic:iterate>
							</logic:notEmpty>
						</table>
					</div>
				</div>

			</html:form>
		</div>
	</div>
</body>
</html>
