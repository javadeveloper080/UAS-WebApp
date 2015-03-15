<jsp:include page="AdminHeader.jsp" />
<script language="javascript">
	function CheckInput() {
		var sel = 0;
		if (f1.dob.value != "") {
			sel = 1;
		}
		if (f1.empid.value == "") {
			alert("Please Enter Employee Id");
			f1.empid.focus();
			return false;
		} else if (f1.pwd.value == "") {
			alert("Please Enter Employee Password");
			f1.pwd.focus();
			return false;
		} else if (f1.gen.selectedIndex == 0) {
			alert("Please Select Gender");
			f1.gen.focus();
			return false;
		} else if (f1.ename.value == "") {
			alert("Please Enter Employee Name");
			f1.ename.focus();
			return false;
		} else if (f1.address.value == "") {
			alert("Please Enter Address");
			f1.address.focus();
			return false;
		} else if (f1.phno.value == "") {
			alert("Please Enter Phone Number");
			f1.phno.focus();
			return false;
		} else if (f1.qlfy.value == "") {
			alert("Please Enter Qualification");
			f1.qlfy.focus();
			return false;
		} else if (f1.dob.value == "") {
			alert("Please Select Date");
			f1.dob.focus();
			return false;
		}

		else if (f1.desg.value == "") {
			alert("Please Enter desgination");
			f1.desg.focus();
			return false;
		} else if (f1.dept.selectedIndex == 0) {
			alert("Please Select Department");
			f1.dept.focus();
			return false;
		} else if (sel == 1) {

			var Date1 = new Date();
			var Date2 = new Date();
			dt1 = f1.dob.value;
			dt2 = f1.sysdate.value;

			var day1 = dt1.substring(0, 2);
			var mon1 = dt1.substring(3, 6);
			var year1 = dt1.substring(7, 11);
			var day2 = dt2.substring(0, 2);
			var mon2 = dt2.substring(3, 6);
			var year2 = dt2.substring(7, 11);
			if (mon1 == "Jan") {
				mon1 = 01;
			} else if (mon1 == "Feb") {
				mon1 = 02;

			} else if (mon1 == "Mar") {
				mon1 = 03;

			} else if (mon1 == "Apr") {
				mon1 = 04;

			} else if (mon1 == "May") {
				mon1 = 05;

			} else if (mon1 == "Jun") {
				mon1 = 06;

			} else if (mon1 == 'Jul') {
				mon1 = 07;

			} else if (mon1 == "Aug") {
				mon1 = 08;

			} else if (mon1 == "Sep") {
				mon1 = 09;

			} else if (mon1 == "Oct") {
				mon1 = 10;

			} else if (mon1 == "Nov") {
				mon1 = 11;

			} else if (mon1 == "Dec") {
				mon1 = 12;

			}

			if (mon2 == "Jan") {

				mon2 = 01;

			} else if (mon2 == "Feb") {
				mon2 = 02;

			} else if (mon2 == "Mar") {
				mon2 = 03;

			} else if (mon2 == "Apr") {
				mon2 = 04;

			} else if (mon2 == "May") {
				mon2 = 05;

			} else if (mon2 == "Jun") {
				mon2 = 06;

			} else if (mon2 == "Jul") {

				mon2 = 07;

			} else if (mon2 == "Aug") {
				mon2 = 08;

			} else if (mon2 == "Sep") {
				mon2 = 09;

			} else if (mon2 == "Oct") {
				mon2 = 10;

			} else if (mon2 == "Nov") {
				mon2 = 11;

			} else if (mon2 == "Dec") {
				mon2 = 12;
			}

			Date1.setFullYear(year1, mon1, day1);
			Date2.setFullYear(year2, mon2, day2);

			if (Date1 > Date2) {
				alert("Join Date Should Not be Greater than Current Date");
				return false;

			} else {
				return true;
			}

		}

	}

	function CharCheck(obj) {
		len = obj.value;

		len = obj.value;

		if (len.charAt(0) == " " || len.charAt(0) == ".") {
			var oldvalue = len.substring(1, len.length);
			obj.value = oldvalue;
		}

		n = event.keyCode;

		len = obj.value;

		if ((n >= 65 && n <= 90) || (n >= 33 && n <= 36) || (n == 37)
				|| (n == 18) || (n == 92) || (n == 93) || (n == 17)
				|| (n == 145) || (n == 19) || (n == 144) || (n == 35)
				|| (n == 46) || (n == 45) || (n == 40) || (n == 38)
				|| (n == 39) || (n == 32) || (n == 8) || (n == 110)
				|| (n == 190) || (n == 20) || (n == 9) || (n == 16) || n == 36) {

		} else {
			obj.value = "";
			return false;
		}
	}

	function its_whitespace(obj) {
		len = obj.value;
		var colors = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&",
				"*", "(", ")", "_", "+", "<",">", "/", "?", "}", "{", "[", "]",
				"'", ";", "=", "-", "|", ",", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "0");
		for (j = 0; j <= len.length - 1; j++) {
			var char = len.substring(j, j + 1);
			for (i = 0; i <= colors.length - 1; i++) {
				var sNumber = colors[i];
				if (sNumber == char) {

					obj.value = "";
					obj.focus();
					return false;
				}
			}

		}

		if (obj.value.length == 0) {

			return false;

		}

		string_value = obj.value;

		// These are the whitespace characters
		var whitespace = " \n\r\t\."
		var existed = "No";
		var Valid = "No";

		// Run through each character in the string
		for ( var counter = 0; counter < string_value.length; counter++) {
			// Get the current character
			current_char = string_value.charAt(counter)
			// If it's not in the whitespace characters string,
			// return false because we found a non-whitespace character
			if (whitespace.indexOf(current_char) == "") {
				var existed = "Yes";
			} else if (whitespace.indexOf(current_char) == -1) {
				existed = "No";
				Valid = "Yes";
				break;
			}
		}
		if (existed == "No" && Valid == "Yes") {
			existed = "Yes";
			Valid = "No";
			return false;
		} else {
			obj.value = "";
			existed = "Yes";
			Valid = "No";
			obj.focus();
			return false;

		}

	}

	function its_whitespace2(obj) {
		if (obj.value.length == 0) {
			return false;
		}

		// These are the whitespace characters

		var whitespace = " \n\r\t"
		var existed = "No";
		var Valid = "No";
		len = obj.value;
		var string_value = obj.value;
		var char = len.substring(len.length, len.length - 1);

		// Run through each character in the string
		for ( var counter = 0; counter < string_value.length; counter++) {
			// Get the current character
			current_char = string_value.charAt(counter)
			// If it's not in the whitespace characters string,
			// return false because we found a non-whitespace character
			if (whitespace.indexOf(current_char) == "") {
				var existed = "Yes";
			} else if (whitespace.indexOf(current_char) == -1) {
				existed = "No";
				Valid = "Yes";
				break;
			}
		}
		if (existed == "No" && Valid == "Yes") {
			existed = "Yes";
			Valid = "No";
			return false;
		} else {
			obj.value = "";
			existed = "Yes";
			Valid = "No";
			obj.focus();
			return false;
		}

		// Otherwise, the string has nothing but
		// whitespace characters, so return true

	}

	function Check(obj) {
		len = obj.value;
		var colors = new Array("`", "~", "!", "@", "#", "$", "%", "^", "&",
				"*", "(", ")", "_", "+", "<",">", "/", "?", "}", "{", "[", "]",
				"'", ";", "=", "-", "|", ",", "a", "b", "c", "d", "e", "f",
				"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
				"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
		for (j = 0; j <= len.length - 1; j++) {
			var char = len.substring(j, j + 1);
			for (i = 0; i <= colors.length - 1; i++) {
				var sNumber = colors[i];
				if (sNumber == char) {
					obj.value = "";
					obj.focus();

					return false;
				}
			}
		}
		if (obj.value.length == 0) {
			return false;
		}
		string_value = obj.value;
		var whitespace = " \n\r\t\."
		var existed = "No";
		var Valid = "No";
		for ( var counter = 0; counter < string_value.length; counter++) {
			// Get the current character
			current_char = string_value.charAt(counter)
			// If it's not in the whitespace characters string,
			// return false because we found a non-whitespace character
			if (whitespace.indexOf(current_char) == "") {
				var existed = "Yes";
			} else if (whitespace.indexOf(current_char) == -1) {
				existed = "No";
				Valid = "Yes";
				break;
			}
		}
		if (existed == "No" && Valid == "Yes") {
			existed = "Yes";
			Valid = "No";
			return false;
		} else {
			obj.value = "";
			existed = "Yes";
			Valid = "No";
			obj.focus();
			return false;

		}

	}

	function NoCheck(obj) {
		n = event.keyCode;
		len = obj.value;
		if ((n<=57 && n> = 48) || n == 8 || (n<=105 && n> = 96) || n == 46
				|| (n >= 33 && n <= 36) || (n == 37) || (n == 18) || (n == 92)
				|| (n == 93) || (n == 17) || (n == 145) || (n == 19)
				|| (n == 144) || (n == 35) || (n == 46) || (n == 45)
				|| (n == 40) || (n == 38) || (n == 39) || (n == 9)) {

		} else {
			obj.value = "";

		}

	}

	function its_whitespace3(obj) {
		len = obj.value;
		var colors = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&",
				"*", "(", ")", "_", "+", "<",">", "/", "?", "}", "{", "[", "]",
				"'", ";", "=", "-", "|", ",");

		for (j = 0; j <= len.length - 1; j++) {
			var char = len.substring(j, j + 1);
			for (i = 0; i <= colors.length - 1; i++) {
				var sNumber = colors[i];
				if (sNumber == char) {

					obj.value = "";
					obj.focus();
					return false;
				}
			}

		}
		if (obj.value.length == 0) {
			return false;
		}

		string_value = obj.value;
		// These are the whitespace characters
		var whitespace = " \n\r\t\."
		var existed = "No";
		var Valid = "No";
		// Run through each character in the string
		for ( var counter = 0; counter < string_value.length; counter++) {
			// Get the current character
			current_char = string_value.charAt(counter)
			// If it's not in the whitespace characters string,
			// return false because we found a non-whitespace character
			if (whitespace.indexOf(current_char) == "") {
				var existed = "Yes";
			} else if (whitespace.indexOf(current_char) == -1) {
				existed = "No";
				Valid = "Yes";
				break;
			}
		}
		if (existed == "No" && Valid == "Yes") {
			existed = "Yes";
			Valid = "No";
			return false;
		} else {
			obj.value = "";
			existed = "Yes";
			Valid = "No";
			obj.focus();
			return false;

		}
	}
	function setfocus() {

		f1.empid.focus();

	}
</script>
<%@page import="java.sql.*,EPR.*"%>
<%
	Connection con = null;
	ResultSet rs = null;
	String dt = "";
	try {

		ConnectionBean CBean = new ConnectionBean();
		con = CBean.getConnection();
		Statement stmt = null;
		stmt = con.createStatement();

		rs = stmt.executeQuery("select current_date");

		rs.next();
		dt = rs.getString(1);
		rs.close();

	} catch (Exception ex) {

		out.println("Error" + ex);

	}
%>
<html>
<head>

</head>
<body bgcolor=lightblue onload="setfocus()">
	<strong><font size="5" face="Courier New, Courier, mono">EMPLOYEE
			REGISTRATION </font></strong>
	</p>

	<form name="f1" method="post" action="EmpRegister"
		onsubmit="return CheckInput()">
		<table border="0" cellpadding="5" cellspacing="1">
			<tr>
				<td><b>Employee ID </b></td>
				<td><input type="text" name="empid"
					onblur=its_whitespace3(this) maxlength=10> <input
					type="hidden" name="sysdate" value="<%=dt%>"></td>
			</tr>

			<tr>
				<td><b>Password</b></td>
				<td><input type="password" name="pwd" maxlength=10></td>
			</tr>

			<tr>
				<td><b>Gender</b></td>
				<td><select name=gen>
						<option>--Select Gender--></option>
						<option>Male</option>
						<option>Female</option>
				</select></td>
			</tr>

			<tr>

				<td><b>Employee Name</b></td>
				<td><input type="text" name="ename" maxLength=30
					onkeyup="CharCheck(this)" onblur="its_whitespace(this)"></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><b>Address</b></td>
				<td><textarea name="address" rows=5
						onblur="its_whitespace2(this)"></textarea></td>
			</tr>
			<tr>
				<td><b>Phone Number</b></td>
				<td><input type="text" name="phno" onkeyup="NoCheck(this)"
					onblur="Check(this)" maxlength=13></td>
			</tr>
			<tr>
			</tr>
			<tr>

				<td><b>Qualification</b></td>
				<td><input type="text" name="qlfy" onkeyup="CharCheck(this)"
					onblur="its_whitespace(this)" maxlength=10></td>
			</tr>
			<tr>
				<td><b>Date Of Joining</b></td>
				<td><input type="text" name="dob" readonly value=""
					maxlength=30> <font size="7"> <a
						href="javascript:void(0)"
						onclick="if(self.gfPop)gfPop.fPopCalendar(document.f1.dob);
  				 return false;"
						HIDEFOCUS tabIndex=5> <img name="popcal" align="absmiddle"
							src="Calendar\calbtn.gif" width="34" height="22" border="0"
							alt=""></a></font></td>


			</tr>

			<td>
			<tr>
				<td><b>Designation</b></td>
				<td><input type="text" name="desg" onkeyup="CharCheck(this)"
					onblur="its_whitespace(this)" maxlength=10></td>
			</tr>



			<tr>
				<td><b>Department</b></td>
				<td><select name=dept>
						<option>--Select Department--></option>
						<option>TRAINING DEVELOPMENT</option>
						<option>WIRE ROD MILL</option>
						<option>BLAST FURNACE</option>
						<option>STEEL MELTING SHOP</option>
						<option>THERMAL POWER PLANT</option>
				</select></td>

			</tr>
			<td colspan=4><input name="Add" type="submit" id="Add"
				value="Add"> &nbsp;&nbsp;&nbsp;&nbsp; <input name="clear"
				type="reset" id="clear" value="Clear"></td>
			</tr>

			<tr>

				</td>
			</tr>
		</table>
	</form>
	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="Calendar\ipopeng.htm" scrolling="no"
		frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;">
	</iframe>
</body>
</html>
