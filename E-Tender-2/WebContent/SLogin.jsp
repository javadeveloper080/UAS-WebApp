<html>
<script language="javascript">
	function SetFocus() {

		f1.name.focus();

	}

	function Clear() {
		f1.name.value = "";
		f1.pwd.value = "";
		f1.name.focus();

	}
	function checkinput() {
		if (f1.name.value == "") {
			alert("Please Enter User Name")
			f1.pwd.value = "";
			f1.name.focus();
			return false;
		} else if (f1.pwd.value == "") {
			alert("Please Enter Password");
			f1.pwd.focus();
			return false;
		} else {

			f1.action = "CheckSLogin.jsp";
			f1.submit();

		}
	}
</script>
<body onload="SetFocus()" text="#6666CC">
	<b>Supplier Login</b>
	<form name="f1" method="post">
		<br>
		<table border=0>
			<tr>
				<td><b>User Id<b></td>
				<td><input type="text" name="name" size=20 maxlength=25></td>
				<td rowspan=3><img src="IMAGES/Supl.jpg" width=140></td>
			</tr>
			<tr>
				<td><b>Password<b></td>
				<td><input type="password" name="pwd" size=20 maxlength=15></td>
			</tr>
			<tr>
				<td><input type="Submit" name="submit" value="Signin"
					onclick="return checkinput()"></td>
				<td><input type="button" name="reset" value="Clear"
					onclick="Clear()"></td>

			</tr>
		</table>
		<br> <b><a href="Home.jsp">HomePage</a></b>
	</form>
</body>
</html>
