<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%> 

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" type="text/css"  href="css/base.css" />
 

    </head>
    <body>
        <div id="base_layout_header">
            <tiles:insert attribute="header" ignore="true" />
        </div>
        <div id="base_layout_wrap" >
            <div id="base_layout_sidebar">
                <tiles:insert attribute="menu" />
            </div>
            <div id="base_layout_content">
                <tiles:insert attribute ="body" />
            </div>

           
        </div>
             <div id="base_layout_footer">
                <tiles:insert attribute="footer" />
            </div>
    </body>
</html>