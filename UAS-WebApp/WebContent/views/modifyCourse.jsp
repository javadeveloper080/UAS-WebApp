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

function modifyCourse(couId)
	{	
	alert('Course Selected');
	var courseId = document.getElementById('couId').value;
	
	
	
	if(courseId == 0)
		{
			alert( "Please select the course to be modified!" );
	     	return false;

		}
	document.courseForm.action="courseAction.do?method=modifyCourses";
	document.courseForm.submit();
	
	}	

//Function retrieves the attached document from DB
function modifyCourseContent(sessionId) {
	window.open("courseAction.do?method=modifyCourseContent&sessionId="+sessionId, "displayCourseWin", "menubar=1,status=0,toolbar=0,resizable=1,location=0");	
}

function deleteCourseSession(sessionId)	
{
	alert('Delete Selected Course Session'+sessionId);
	
	var r=confirm("Press OK to delete!")
	 if (r==true)
	   {
		 document.courseForm.action="courseAction.do?method=deleteCourseSession&sessionId="+sessionId;
		 document.courseForm.submit();
	   }
	 else
		 {
		 	return false;
		 }
	
	
}

function addCourseTopic()
{	
	
	alert('Add Course Topic');
	var sessionId = document.getElementById('sessionId').value;
	var courId = document.getElementById('couId').value;
	alert('sessionId'+sessionId);
	alert('courseId'+courId);

window.open("courseAction.do?method=redirectToAddTopic&courseId="+courId+"&sessionId="+sessionId, "displayCourseTopicWin", "menubar=1,status=0,toolbar=0,resizable=1,location=0");



}	

function updateCourseFileContent()
{
alert('Update Course File Content');

var sessionId = document.getElementById('sessionId').value;
var courId = document.getElementById('couId').value;
var fileId=document.getElementById('fileId').value;
alert('sessionId'+sessionId);
alert('courseId'+courId);

if(fileId == null || fileId =="")
	{
		alert("Please select the file to be uploaded");
		return false;
	}

document.courseForm.action="courseAction.do?method=updateCourseFileContent&courseId="+courId;
document.courseForm.enctype="multipart/form-data";
document.courseForm.submit();
	
	
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
        <ul id="navigation">
            <li><a href="loginAction.do?method=userLoginPage">Home</a></li>
            <li><a href="courseAction.do?method=displayCourses">Courses</a></li>
            <li><a href="courseAction.do?method=courseAddPage">Add a course</a></li>
			<li><span><a href="courseAction.do?method=displayCourses&pageName=ModifyCourse">Modify course</a></span></li>
			<li><a href="courseAction.do?method=displayCourses&pageName=DeleteCourse">Delete Course</a></li>
			 <li><a href="questionAction.do?method=addQuestionPage">Create exam question</a></li>
        	 <li><a href="loginAction.do?method=logOutAction">Logout</a></li>
        </ul>
    </div>
		<div id="body">
		<html:form action="/courseAction" >

			<div class="body-content">
			
				<div class="courseHeader">Modify Course</div>
				<div class="personaltable">
					<table>
					<tr>
							<td><font color="red" size="3px">*</font>Choose Course</td>
							<td>&nbsp;:&nbsp;</td>
							<td><html:select styleId="couId" property="courId" onchange="modifyCourse('couId');">
							<html:option value="0">Select Course</html:option>
							<html:optionsCollection name="courseForm" property="courseList"
								label="courseName" value="id" />
						</html:select></td>
						</tr>
					</table>
				</div>
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
									<td><a href='#' onclick='modifyCourseContent(${sess.sessionId});'><bean:write name="sess" property="topic"/></a></td>
									<td><bean:write name="course" property="courseKey"/></td>
									<td><a href='#' onclick='deleteCourseSession(${sess.sessionId});'>Delete</a></td>
									<%-- <html:hidden name="courseForm" property="sessionId" value="${sess.sessionId}" styleId="sessionId"/> --%>
									
								
							</tr>
							

					</logic:iterate>
							<%-- <tr><html:button property="addBtn" styleClass="loginBtn" value="Add" onclick="addCourseTopic();" ></html:button> </tr>	 --%>	
							<tr>
								<td><font color="red">*</font>Upload Course Contents</td>
								<td><html:file property="file" styleId="fileId" styleClass="login-input"  /></td>
								<td><html:button property="updateBtn" styleClass="loginBtn" value="Update File Upload" onclick="updateCourseFileContent()" ></html:button></td>
							</tr>
						</table>
				</div>
				</logic:notEmpty>
					<html:hidden name="courseForm" property="sessionId" value="${sess.sessionId}" styleId="sessionId"/>
				<logic:notEqual name="courseForm" property="courId" value="0"><table><tr><html:button property="addBtn" styleClass="loginBtn" value="Add Course Session" onclick="addCourseTopic();" ></html:button> </tr></table>
				</logic:notEqual>
				</div>
				
				
			</html:form>
		</div>
	</div>
</body>
</html>
