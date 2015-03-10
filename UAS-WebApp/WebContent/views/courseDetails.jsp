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

//Function retrieves the attached document from DB
function displaySelectedCourse(courseId) {
	window.open("courseAction.do?method=displaySelectedCourse&courseId="+courseId, "displaySelectedCourseWin", "menubar=1,status=0,toolbar=0,resizable=1,location=0");	
}

function downloadCourse(courseId)
{	

alert('Download Course Document');
document.courseForm.action="courseAction.do?method=downloadCourseContent&courseId="+courseId;
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
             <li><span><a href="courseAction.do?method=displayCourses">Courses</a><span></li>
        	 <li><a href="loginAction.do?method=logOutAction">Logout</a></li>
        </ul>
    </div>
		<div id="body">
			<html:form action="/courseAction">

				<div class="body-content">

					<div class="courseHeader">Courses Information</div>
					<div class="personaltable">
						
						<table width=75% border=1 >
							<tr>
								
									<th>Course Category</th>
									<th>Course Name</th>
									<th>Course Key</th>
									<th>Course Document</th>
								
							</tr>
							<logic:notEmpty name="courseForm" property="courseList">
									<logic:iterate id="course" name="courseForm" property="courseList" type="com.learning.server.pojo.CourseMasterEntity">
							<tr>
									
									<td><bean:write name="course" property="category"/></td>
									<td><a href='#' onclick='displaySelectedCourse(${course.id});'><bean:write name="course" property="courseName"/></a></td>
									<td><bean:write name="course" property="courseKey"/></td>
									 <td><a href='#' onclick='downloadCourse(${course.id});'>Download</a></td>
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
