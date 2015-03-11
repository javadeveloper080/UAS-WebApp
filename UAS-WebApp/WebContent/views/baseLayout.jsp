<%-- 
    Document   : baseLayout
    Created on : Dec 19, 2008, 1:28:41 AM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:getAsString name="title" ignore="true" /></title>
    </head>
    
    <body>
<!--        <div id="wrapper">-->
        <table border="1" cellpadding="2" cellspacing="3" align="center" >
            <tr>
                <td height="20%" width="100%" colspan="2">
                    <tiles:insert attribute="header" ignore="true" />
                </td>
            </tr>
            <tr>
                <td width="20%" height="100%">
                    <tiles:insert attribute="menu" />
                </td>
                <td >
                    <tiles:insert attribute="body" />
                </td>
            </tr>
            <tr>
                <td height="20%" width="100%"  colspan="2">
                    <tiles:insert attribute="footer" />
                </td>
            </tr>
        </table>
<!--        </div>      -->
    </body>
</html>
