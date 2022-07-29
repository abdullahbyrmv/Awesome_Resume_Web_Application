<%@ page import="Resume_Desktop_App.JDBC.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Web Application</title>
</head>
<body>

<%
    User u = (User) request.getAttribute("user");
%>

<div>
    <form action="userDetail" method="POST">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <%--@declare id="surname"--%><%--@declare id="name"--%>
        <label for="name">Name:</label>
        <input type="text" name="name" value="<%=u.getName()%>"/>
        <br/>
        <br/>
        <label for="surname">Surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>"/>

        <input type="submit" name="save" value="Save"/>
    </form>
</div>
</body>
</html>
