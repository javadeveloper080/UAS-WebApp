<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Virtual Learning Environment</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<style type="text/css">
</style>
</head>

<body>
<div id="wrapper">
    <div id="header">
    	<div id="logo">
        	Virtual <strong>Learning</strong> Environment
            <span>EARN MORE KNOWLEDGE</span>
        </div>
        <ul id="navigation">
            <li><span><a href="loginAction.do?method=userLoginPage">Home</a></span></li>
			<li><a href="courseAction.do?method=courseAddPage">AddCourse</a></li>
			<li><a href="courseAction.do?method=displayCourses">Courses</a></li>
			<li><a href="courseAction.do?method=displayCourses&pageName=ModifyCourse">Modify Course</a></li>
			<li><a href="courseAction.do?method=displayCourses&pageName=DeleteCourse">Delete Course</a></li>
			<li><span><a href="questionAction.do?method=addQuestionPage">Create exam question</a></span></li>
			<li><a href="forumMasterAction.do?method=getForumPage">Forum</a></li>
			 <li><a href="loginAction.do?method=logOutAction">Logout</a></li>
        </ul>
    </div>
    <div id="body">
    	<div id="leftmenu">
        <div style="padding-left:0px;padding-top:10px;"><img height="220" src="images/karthik.jpg" alt="userimage.jpg" /></div>
        
        <div class="seperator"></div>
        
        <div class="form">
        	<table>
				<tr><td>Name</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="name" /></td></tr>
				<tr><td>User type</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="userType" /></td></tr>
				<tr><td>Gender</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="gender" /></td></tr>
				<tr><td>Email</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="email" /></td></tr>
				<tr><td>City</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="city" /></td></tr>
				<tr><td>State</td><td>&nbsp;:&nbsp;</td><td><bean:write name="loginForm" property="state" /></td></tr>
			</table>
            <br clear="all" />
        </div>
        </div>
        <div id="content">
        
		<h2>Introduction</h2>
        <p align="justify">Virtual Learning Environment (VLE)-It is a standardized, computer-based environment that supports the delivery of real-time web-based education system.
		This system facilitates online courses virtually either by audio or text or power point presentation or video. It is also a social space where students and teachers can interact through threaded discussions or chat.
		Our System is based on "Self-paced" learning; students are expected to complete lessons, assignments, quizzes and Final examination independently through the system. There will be a time period for all courses a deadline, the reason to it is that each student is learning at his own pace.</p>

		<h2>VLE Learning platforms commonly allow:</h2>
        <p> -> Content management - creation, storage, access to and use of learning resources.<br />
		-> Curriculum mapping and planning - lesson planning, assessment and personalisation of the learning experience.<br />
		-> Learner engagement and administration - managed access to learner information and resources and tracking of progress and achievement.<br />
		-> Communication and collaboration - emails, notices, chat, wikis, blogs.</p>
        

        <h2>Our Motto:</h2> 
        <p>To give a learning platform that is safe and secure environment that is reliable, available online and accessible to a wide user base.
        </p>
</div>
        
        <div class="clear"></div>
        <div id="footer">
            
		<p>	Copyright &copy; 2013 Virtual Learning Environment </p>
	    </div>
    </div>
</div>
</body>
</html>
