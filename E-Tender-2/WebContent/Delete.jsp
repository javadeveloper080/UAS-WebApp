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
 String itid=request.getParameter("itid");
 int updated=CBean.executeUpdate("delete  from  ind_items_tmp where item_id=" + itid + "  ");
 %>
  <jsp:forward page="AddItem.jsp" />
 
 <%

}catch(Exception ex)
{
%>
 <b>
<%
  out.println("Error While Connecting DataBase" + ex);
}
%>




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
