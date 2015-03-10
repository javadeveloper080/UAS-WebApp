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
		</div>
		<div id="body">
			<html:form action="/courseAction">

				<div class="body-content">

					<div class="courseHeader">Course Content for <bean:write name="courseForm" property="topic"/></div>
					<div class="personaltable">
						
						<table width=75% border=1 >
							
							<tr>
								
									<td><html:textarea name="courseForm" property="topicContent" readonly="true"></html:textarea></td>
									<html:hidden name="courseForm" property="sessionId" styleId="sessionId"/>
								
							</tr>
							<tr><td width="50%" align="center">
							
   								 <html:button property="loginBtn" styleClass="loginBtn" value="Close" onclick="window.close()" /></td>
   								
							</tr>
						</table>
					</div>
				</div>

			</html:form>
		</div>
	</div>
</body>
</html>
