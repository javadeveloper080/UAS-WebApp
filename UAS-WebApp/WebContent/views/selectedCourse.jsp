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



function readCourseSession(tempSessionId)
{	
	
	
	
	alert('Read Course Topic');
	alert('temp session'+tempSessionId);
	var sessionId = document.getElementById('sessionId').value;
	alert('sessionId'+sessionId);

window.open("courseAction.do?method=readCourseContent&sessionId="+tempSessionId, "displayCourseTopicWin", "menubar=1,status=0,toolbar=0,resizable=1,location=0");



}	

	
</script>
</head>

<body>
	<div id="wrapper">
    <div id="header">
    	<div id="logo">
        	Virtual <strong>Learning</strong> Environment
            <span>EARN MORE KNOWLEDGE</span>
        </div>
        
    </div>
		<div id="body">
		<html:form action="/courseAction" >

			<div class="body-content">
			
				<div class="courseHeader">Course Content</div>
				
				<logic:notEmpty name="courseForm" property="sessList">
				<div class="personaltable">
					<table width=75% border=1 >
							
							
							<tr>
								
									<th>Topic</th>
									<th>Course</th>
									<th>Course Key</th>
								
							</tr>
					<logic:iterate id="sess" name="courseForm" property="sessList" type="com.learning.server.pojo.SessionMasterEntity">
					<bean:define id="course" name="sess" property="courseId" type="com.learning.server.pojo.CourseMasterEntity"></bean:define>
							<tr>
									
									<td><bean:write name="sess" property="topicName"/></td>
									<td><bean:write name="sess" property="topic"/></td>
									<td><bean:write name="course" property="courseKey"/></td>
									<td><a href='#' onclick='readCourseSession(${sess.sessionId});'>Read</a></td>
									<html:hidden name="courseForm" property="sessionId" value="${sess.sessionId}" styleId="sessionId"/>
							</tr>

					</logic:iterate>
							<tr><td><html:button property="loginBtn" styleClass="loginBtn" value="Close" onclick="window.close()" /></td></tr>		
						</table>
				</div>
				</logic:notEmpty>
				</div>
				
				
			</html:form>
		</div>
	</div>
</body>
</html>
