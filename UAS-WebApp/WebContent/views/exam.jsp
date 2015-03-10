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

function selectedExamPage()
	{	
	
	answerNumberValue=document.getElementById('answerNumberId').value ;

	if (answerNumberValue == null || answerNumberValue == "") {
		alert("Please select  your answer");
		return false;
	}
	else{
	alert('Next Question');
	document.examForm.action="examAction.do?method=selectedExamPage";
	document.examForm.submit();
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
		</div>
		<div id="body">
			<html:form action="/examAction">

				<div class="body-content">

					<div class="courseHeader">Exam in Process</div>
					<div class="personaltable">
						<table>

							<tr>
								<logic:notEmpty name="examForm" property="noQuestionsAttempted">
									<tr>
										<td><b><font color="red" size="3px"><bean:write
														name="examForm" property="noQuestionsAttempted" /></font></b></td>
									</tr>
									<tr>
								</logic:notEmpty>
							</tr>

							<tr>
								<logic:notEmpty name="examForm" property="noQuestionsPending">
									<tr>
										<td><b><font color="red" size="3px"><bean:write
														name="examForm" property="noQuestionsPending" /></font></b></td>
									</tr>
									<tr>
								</logic:notEmpty>
							</tr>

							<tr>&nbsp;
							</tr>
							<tr>&nbsp;
							</tr>



							<tr>
								<td><b><font color="green" size="3px"><bean:write
												name="examForm" property="questionDescription" /></font></b></td>
								<td><b><font color="black" size="3px"><bean:write
												name="examForm" property="questionId" /></font></b></td>
								<html:hidden name="examForm" property="questionKey" />
								<html:hidden name="examForm" property="courseId" />
							</tr>


							<logic:iterate id="answerOption" property="options"
								name="examForm">
								<tr>
									<td><bean:write name="answerOption" property="answer" /></td>
									<td><html:radio value="${answerOption.answerNumber }"
											property="answerNumber" styleId="answerNumberId" /></td>
								</tr>
							</logic:iterate>







							<tr>
								<td>&nbsp;</td>

								<td><html:button property="addBtn" styleClass="loginBtn"
										value="Submit" onclick="return selectedExamPage();" /></td>
							</tr>
						</table>
					</div>
				</div>

			</html:form>
		</div>
	</div>
</body>
</html>
