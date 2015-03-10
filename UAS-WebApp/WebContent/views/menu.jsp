<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">

function adminLoginPage()
{	
	alert('Admin Login Page');
	
	document.loginForm.action="loginAction.do?method=adminLoginPage";
	document.loginForm.submit();
	
}	

function userLoginPage()
{	
	alert('User Login Page');
	
	document.loginForm.action="loginAction.do?method=userLoginPage";
	document.loginForm.submit();
	
}	

</script>
    </head>
    <body>
        <!--        <a href="Link.do?method=friends" >Friends</a><br>
                <a href="Link.do?method=office" >The Office</a>-->
        <div id="leftmenu">
            <div style="padding-left:0px;padding-top:10px;"><img height="220" width="200" src="images/karthik.jpg" alt="userimage.jpg" /></div>

            <div class="seperator"></div>

            <div class="form">
                <table>
                    <tr><td><a style="color: green;" href="#" onclick="adminLoginPage();">Login</a></td></tr>
                    <tr><td><a style="color: green;" href="#" onclick="adminLoginPage();">Student Enrollment</a></td></tr>
                </table>
                <br clear="all" />
            </div>
        </div>
    </body>
</html>
