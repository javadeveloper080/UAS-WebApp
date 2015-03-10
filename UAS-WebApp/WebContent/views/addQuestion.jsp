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
	function addQuestion() {
		
		courseIdValue=document.getElementById('courseId').value;
		questionDescriptionValue=document.getElementById('questionDescriptionId').value;
		choice1Value=document.getElementById('choice1Id').value ;
		choice2Value=document.getElementById('choice2Id').value ;
		choice3Value=document.getElementById('choice3Id').value ;
		choice4Value=document.getElementById('choice4Id').value ;
		answerNumberValue=document.getElementById('answerNumberId').value ;

		if (questionDescriptionValue == null || questionDescriptionValue == "" ||
				choice1Value == null || choice1Value == "" ||
				choice2Value == null || choice2Value == "" ||
				choice3Value == null || choice3Value == "" ||
				choice4Value == null || choice4Value == "" ||
				answerNumberValue == null || answerNumberValue == "" ||
				courseIdValue==null ||courseIdValue=="" || courseIdValue=="0") {
			alert("Please make sure all fields are filled");
			return false;
		}
		
		if (isNaN(answerNumberValue) || answerNumberValue<"1" || answerNumberValue > "4")
		{
		    alert("Please make sure answer number should be in the range of 1-4 only");
		    document.getElementById('answerNumberId').focus();
		    return false;
		} 
 
		
		else {

			alert('Add Question');

			document.questionForm.action = "questionAction.do?method=addQuestion";
			document.questionForm.submit();
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
				<li><a href="forumMasterAction.do?method=getForumPage">Forum</a></li>
				<li><a href="loginAction.do?method=logOutAction">Logout</a></li>
			</ul>
		</div>
		<div id="body">
			<html:form action="/questionAction">

				<div class="body-content">

					<div class="courseHeader">Add Question for Exam</div>
					<div class="personaltable">
						<table>
							<logic:notEmpty name="questionForm"
								property="questionAddedMessage">
								<tr>
									<td><bean:write name="questionForm"
											property="questionAddedMessage" /></td>
								</tr>
								<tr>
							</logic:notEmpty>


							<tr>
								<td><font color="red" size="3px">*</font>Course Id</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:select property="courseId" styleId="courseId" >
								<html:option value="0">Select a Course Id</html:option>
										<html:optionsCollection name="questionForm"
											property="courseKeyList" label="courseKey" value="id" />
									</html:select>	<br />
									<label style="padding-top: 10px; color: #ADADAD;">(Select a Course Id)</label><br /></td>
							</tr>



							<tr>
								<td><font color="red" size="3px">*</font>Question Description</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:textarea name="questionForm"
										property="questionDescription" rows="10" cols="20"
										styleId="questionDescriptionId"/><td>
							</tr>

							<tr>
								<td><font color="red" size="3px">*</font>Option #1</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="questionForm" property="choice1"
										size="60" styleId="choice1Id" styleClass="login-input" maxlength="256"/></td>
							</tr>
							<tr>
								<td><font color="red" size="3px">*</font>Option #2</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="questionForm" property="choice2"
										size="60" styleId="choice2Id" styleClass="login-input" maxlength="256"/></td>
							</tr>

							<tr>
								<td><font color="red" size="3px">*</font>Option #3</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="questionForm" property="choice3"
										size="60" styleId="choice3Id" styleClass="login-input" maxlength="256"/></td>
							</tr>

							<tr>
								<td ><font color="red" size="3px">*</font>Option #4</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="questionForm" property="choice4"
										size="60" styleId="choice4Id" styleClass="login-input" maxlength="256"/></td>
							</tr>


							<tr>
								<td><font color="red" size="3px">*</font>Answer Number</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="questionForm" property="answerNumber"
										size="10" styleId="answerNumberId" styleClass="login-input" maxlength="1"/><br />
									<label style="padding-top: 10px; color: #ADADAD;">(Answer number should be in the range of 1-4 only)</label><br /></td>
							</tr>
							
							
							<tr>
								<td>&nbsp;</td>

								<td><html:button property="addBtn" styleClass="loginBtn"
										value="Add" onclick="return addQuestion();" /></td>

								<td><html:reset property="resetBtn" styleClass="loginBtn" value="Reset" /></td>
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
