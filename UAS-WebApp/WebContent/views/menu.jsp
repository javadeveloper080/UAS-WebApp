<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<script type="text/javascript">
function fun(){
     
        document.getElementById('menuDiv').style.display = "none";
}
</script>
<div ondblclick="fun()" id="menuDiv">
<div id="leftmenu" >
            <div style="padding-left:0px;padding-top:10px;"><img height="220" width="200" src="images/karthik.jpg" alt="userimage.jpg" /></div>

            <div class="seperator"></div>

            <div class="form">
                <table>
                    <tr><td><a style="color: green;"  href="loginAction.do?method=loginPage">Login</a></td></tr>
                    <tr><td><a style="color: green;"  href="loginAction.do?method=friends">Student Enrollment</a></td></tr>
                     <tr><td>
                             <html:link action="Fee" style="color: green;" >Fee</html:link>
                         </td></tr>
                </table>
                <br clear="all" />
            </div>
        </div>
</div>

