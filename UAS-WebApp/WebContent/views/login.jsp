<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
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
        <div id="wrapper">
            <div id="body">
                <div class="loginbox">
                    <html:form action="/loginAction" >
                        <div class="loginheader">
                            <img src="images/user-icon.png" alt="usericon.png" width="20px" height="10" class="login-header-icon"/>
                            <label class="login-text">Welcome User</label>
                        </div>
                        
                        <tr><div class="forgotpass">Admin ? <a style="color: green;" href="#" onclick="adminLoginPage();">Click here</a></div></tr>
                        
                        <tr><div class="forgotpass">User ? <a style="color: green;"  href="#" onclick="userLoginPage();">Click here</a></div></tr>
                        
                    </html:form>
                </div>
            </div>
        </div>
    </body>
</html>
