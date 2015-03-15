
<jsp:include page="AdminHeader.jsp" />
<script>
	function CheckInput() {
		if (f1.itmname.value == "") {
			alert("Please Enter Item name");
			f1.itmname.focus();
			return false;
		} else if (f1.itdesc.value == "") {
			alert("Please Enter Item Description");
			f1.itdesc.focus();
			return false;
		} else if (f1.itcat.selectedIndex == 0) {
			alert("Please Select Item Catagory");
			f1.itcat.focus();
			return false;
		} else if (f1.itspec.value == "") {
			alert("Please Enter Item Specification");
			f1.itspec.focus();
			return false;
		} else if (f1.unts.value == "") {
			alert("Please Enter Units");
			f1.unts.focus();
			return false;
		} else if (f1.rts.value == "") {
			alert("Please Enter Rate");
			f1.rts.focus();
			return false;

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
	function setfocus() {

		f1.itmname.focus();

	}
</script>

<html>
<head>
</head>
<body bgcolor=lightblue onload="setfocus()">
	<strong><font size="5" face="Courier New, Courier, mono">ITEM
			REGISTRATION </font></strong>
	</p>
	<%@page import="java.sql.*,EPR.*"%>
	<%
		Connection con = null;
		ResultSet rs = null;
		int itno = 0;

		try {

			ConnectionBean CBean = new ConnectionBean();
			con = CBean.getConnection();
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(item_id) from items_info");
			rs.next();
			itno =rs.getInt(1)+1;
			if (itno == 0) {
				itno = 1;
			}
			rs.close();
			rs = stmt.executeQuery("select item_id from items_info");
			String empid = session.getValue("empid") + "";
			System.out.println("Employee Id" + empid);

		} catch (Exception ex) {

		}
	%>



	<form name="f1" method="post" action="ItemRegister"
		onsubmit="return CheckInput()">
		<table border="0" cellpadding="5" cellspacing="1">
			<tr>
				<td><b>Item Id </b></td>
				<td><input type="text" name="itmid" readonly value=<%=itno%>
					maxlength=10></td>
			</tr>

			<tr>
				<td><b>Item Name</b></td>
				<td><input type="text" name="itmname" maxlength=20
					onkeyup="CharCheck(this)" onblur="its_whitespace(this)"></td>
			</tr>
			<tr>
				<td><b>Item Description</b></td>
				<td><textarea name="itdesc" onkeyup="CharCheck(this)"
						onblur="its_whitespace(this)"></textarea></td>
			</tr>
			<tr>
			</tr>

			<tr>

				<td><b>Item Catagory</b></td>
				<td><select name="itcat">
						<option><--Slect Catagory--></option>
						<option>TRAINING DEVELOPMENT</option>
						<option>WIRE ROD MILL</option>
						<option>BLAST FURNACE</option>
						<option>STEEL MELTING SHOP</option>
						<option>THERMAL POWER PLANT</option>


				</select></td>
			</tr>


			<tr>
				<td><b>Item Spec</b></td>
				<td><textarea name="itspec" rows=5 cols=20 maxlength=100></textarea></td>
			</tr>
			<tr>
				<td><b>Units</b></td>
				<td><input type="text" name="unts" maxlength=12></td>
			</tr>
			<tr>
			</tr>
			<tr>

				<td><b>Rate</b></td>
				<td><input type="text" name="rts" onkeyup="NoCheck(this)"
					onblur="Check(this)" maxlength=40></td>
			</tr>


			<td>
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
