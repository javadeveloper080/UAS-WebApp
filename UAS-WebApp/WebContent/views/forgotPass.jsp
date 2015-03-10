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
	function forgotPassWordAction() {

		userNameVlaue = document.getElementById('userName').value;

		if (userNameVlaue == null || userNameVlaue == "") {
			alert("Username must be filled out");
			document.getElementById('userName').focus();
			return false;
		} else {
			alert('Get Password Details');
			document.loginForm.action = "loginAction.do?method=forgotPassWordAction";
			document.loginForm.submit();
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
			<html:form action="/loginAction">

				<div class="body-content">


					<div class="courseHeader">Forgot Password</div>
					<div class="contacttable">
						<table>

							<tr>
								<td><font color="red" size="3px">*</font>Username</td>
								<td>&nbsp;:&nbsp;</td>
								<td><html:text name="loginForm" property="userName"  styleId="userName" size="30"/><br />
									<label style="padding-top: 10px; color: #ADADAD;">(On
										submit your password will be mailed to your email if you are a
										valid user)</label><br /></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<!-- <td align="right"><a href="" class="loginBtn" >Submit</a></td> -->
								<td></td>

								<div>
								<td align="justify"><html:button property="loginBtn"
										styleClass="loginBtn" value="submit"
										onclick="return forgotPassWordAction();" /></td>
							</tr>

						</table>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>
