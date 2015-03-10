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
            <li><span><a href="loginAction.do?method=userLoginPage">Home</a></span></li>
			<li><a href="courseAction.do?method=displayCourses">Courses</a></li>
			<li><a href="examAction.do?method=selectCourseExam">Exam</a></li>
			<li><a href="resultAction.do?method=getResults">Results</a></li>
			<li><a href="forumMasterAction.do?method=getForumPage">Forum</a></li>
			 <li><a href="loginAction.do?method=logOutAction">Logout</a></li>
        </ul>
		</div>
		<div id="body">
			<html:form action="/resultAction">

				<div class="body-content">

					<div class="courseHeader">Results</div>
					<div class="personaltable">

						<table width=75% border=1>
							<tr>

								<th>Course Key</th>
								<th>Course Category</th>
								<th>Course Name</th>
								<th>Percentage</th>

							</tr>
									
							
							<logic:notEmpty name="resultForm" property="resultsDTOList">
								<logic:iterate id="result" name="resultForm" property="resultsDTOList">
									<tr>
										<td><bean:write name="result" property="courseKey" /></td>
										<td><bean:write name="result" property="category" /></td>
										<td><bean:write name="result" property="courseName" /></td>
										<td><bean:write name="result" property="percentage" /></td>
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
