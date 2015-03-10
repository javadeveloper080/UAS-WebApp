<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%> 

<tiles:insert page="/views/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="Tiles Example" />
    <tiles:put name="header" value="/views/header.jsp" />
    <tiles:put name="menu" value="/views/menu.jsp" />
    <tiles:put name="body" value="/views/body.jsp" />
    <tiles:put name="footer" value="/views/footer.jsp" />
</tiles:insert>