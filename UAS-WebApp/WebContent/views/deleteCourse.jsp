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

function deleteCourse(couId)
	{	
	alert('Delete Course');
	var courseId = document.getElementById('couId').value;
	
	if(courseId == 0)
	{
		alert( "Please select the course to be deleted!" );
     	return false;

	}
	
	
	document.courseForm.action="courseAction.do?method=deleteCourses";
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
			<li><a href="courseAction.do?method=displayCourses&pageName=ModifyCourse">Modify  course</a></li>
			<li><span><a href="courseAction.do?method=displayCourses&pageName=DeleteCourse">Delete Course</a></span></li>
			 <li><a href="questionAction.do?method=addQuestionPage">Create exam question</a></li>
        	 <li><a href="loginAction.do?method=logOutAction">Logout</a></li>
        </ul>
    </div>
		<div id="body">
		<html:form action="/courseAction" >

			<div class="body-content">
			
				<div class="courseHeader">Delete Course</div>
				<div class="personaltable">
					<table>
					<tr>
							<td><font color="red" size="3px">*</font>Choose Course</td>
							<td>&nbsp;:&nbsp;</td>
							<td><html:select styleId="couId" property="courId" onchange="deleteCourse('couId');">
							<html:option value="0">Select Course</html:option>
							<html:optionsCollection name="courseForm" property="courseList"
								label="courseName" value="id" />
						</html:select></td>
						</tr>
					</table>
				</div>
				
				</div>
				
			</html:form>
		</div>
	</div>
</body>
</html>
