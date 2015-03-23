<%-- 
    Document   : ajax
    Created on : 24 Mar, 2015, 1:09:11 AM
    Author     : SARAT
--%>

<%
    String key =request.getParameter("id");
    if(key.equals("volvo")){
    %>
    
    <option value="t1">t1</option>
    <option value="t2">t2</option>
    <option value="t3">t3</option>
    <%
    }
    else  if(key.equals("saab")){
        %>
        
      <option value="b1">b1</option>
    <option value="b2">b2</option>
    <option value="b3">b3</option>
    
     <%
    }
    else  if(key.equals("opel")){
        %>
         <option value="c1">c1</option>
    <option value="c2">c2</option>
    <option value="c3">c3</option>
    
    <% 
      }
    %>