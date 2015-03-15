<HTML><HEAD><TITLE>Home Page</TITLE>
<META content="CHARONWARE - www.casestudio.com" name=author>
<LINK title=report  media=screen href="css/simple.css" type=text/css type=text/css rel=stylesheet>
<TABLE class=tabformat cellSpacing=1 cellPadding=2 width="100%" border=0 >
<TBODY>
<TR>
<td>
<%@page import="java.sql.*,EPR.*" %>
<%
try
{
 Connection con=null;
 ResultSet rs=null;
 ConnectionBean CBean=new ConnectionBean();
 con=CBean.getConnection();
 rs=CBean.executeQuery("select * from ind_items_tmp");
%>
<html>
<body bgcolor=lightblue>
<form name =f action="SaveOrder.jsp">
      <table align=center border=1 colspace=10 width="295">
          <th width="116">Item Id 
          <th width="53">Qty 
          <th width="104">Check 
            <%
while(rs.next())
{
String itid=rs.getString(1);
%>
        <tr>
          <td class=tabhead1 width="116"><%=itid %></td>
          <td class=tabhead1 width="53"><%=rs.getString(2) %></td>
          <td class=tabhead1 width="104"><a href="Delete.jsp?itid=<%=itid%>" style={cursor:hand}>Delete</a></td>
</tr>
<%
}
}catch(Exception ex)
{
%>
          <td width="116"><b> 
            <%
  out.println("Error While Connecting DataBase" + ex);
}
%>
        </table>
</form>
</body>
</html>
</td>
</TR>
</TBODY></TABLE>
<br>
<br>
<br>


</BODY>
</HTML>
