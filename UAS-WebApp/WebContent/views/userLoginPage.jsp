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
	function login() {

		userNameVlaue = document.getElementById('userName').value;
		passWordValue = document.getElementById('passWord').value;

		if (userNameVlaue == null || userNameVlaue == "") {
			alert("Username must be filled out");
			return false;
		}

		else if (passWordValue == null || passWordValue == "") {
			alert("Password must be filled out");
			return false;
		}

		else {
			alert('login');

			document.loginForm.action = "loginAction.do?method=checkLoginDetails";
			document.loginForm.submit();
		}

	}

	function forgotPassWordPageAction() {
		alert('forgot Pass Word Page');

		document.loginForm.action = "loginAction.do?method=forgotPassWordPageAction";
		document.loginForm.submit();
	}

	function userRegistration() {
		alert('Registration');

		document.loginForm.action = "userAction.do?method=registerUser";
		document.loginForm.submit();

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
			<div class="loginbox">
				<html:form action="/loginAction">
					<div class="loginheader">
						<img src="images/user-icon.png" alt="usericon.png" width="20px"
							height="20" class="login-header-icon" /> <label
							class="login-text">Login</label>
					</div>
					<table class="table">
						<tr>
							<td><font color="red" size="3px">*</font>Username</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="text" name="userName" id="userName"
								size="30" maxlength="30" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><font color="red" size="3px">*</font>Password</td>
							<td>&nbsp;:&nbsp;</td>
							<td><input type="password" name="password" id="passWord"
								size="30" maxlength="15" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td align="center"><input type="submit" value="Login"
								onclick="return login()"></td>

						</tr>
					</table>

					<div class="forgotpass">
						New User ? <a style="color: red;" href="#"
							onclick="userRegistration();">SignUp here</a>
					</div>
					<div class="forgotpass">
						Forgot Password ? <a style="color: red;" href="#"
							onclick="forgotPassWordPageAction();">click here</a>
					</div>
				</html:form>
			</div>

			<div class="empty"></div>
			<div>
				<p class="loginpage-text">Cookies and Javascript must be enabled
					in order to login. If you are working on a public computer, be sure
					to log out and close the web browser when you are done.</p>
			</div>
		</div>
	</div>
</body>
</html>
