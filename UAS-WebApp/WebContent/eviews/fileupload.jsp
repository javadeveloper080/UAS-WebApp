<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<html>
<head>
</head>
<body>
	<h1>
		<bean:message key="label.common.title" />
	</h1>

	<html:messages id="err_name" property="common.file.err">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.ext">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.size">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>

	<html:form action="/uploadDocument" method="post"
		enctype="multipart/form-data" >
		<br />
		<bean:message key="label.common.file.label" /> : 
	<html:file property="file" size="50" />
		<br />
		<br />
		<html:submit onclick="submitForm();">
			<bean:message key="label.common.button.submit" />
		</html:submit>

	</html:form>
	
	    <!--script for this page-->
    
    <script>
    
    function submitForm(){	
        document.fileUploadForm.action="uploadDocument.do?method=uploadFile";
        document.fileUploadForm.submit();
    }
    </script>


</body>
</html>