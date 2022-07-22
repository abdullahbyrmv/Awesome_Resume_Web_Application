<%@ page import="Resume_Desktop_App.JDBC.dao.UserInterface" %>
<%@ page import="Resume_Desktop_App.Desktop_App.Context" %>
<%@ page import="Resume_Desktop_App.JDBC.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Web Application</title>
</head>
<body>
<%
    UserInterface userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nationalityIdStr = request.getParameter("nationalityId");
    Integer nationalityId = null;
    if (nationalityId != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }
    List<User> list = userDao.getAllInfo(name, surname, nationalityId);
%>

<div>
    <form action="users.jsp" method="GET">
        <%--@declare id="surname"--%><%--@declare id="name"--%>
        <label for="name">Name:</label>
        <input type="text" name="name" value=""/>
        <br/>
        <br/>
        <label for="surname">Surname:</label>
        <input type="text" name="surname" value=""/>

        <input type="submit" name="search" value="Search"/>
    </form>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Nationality</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (User u : list) {
        %>
        <tr>
            <td><%=u.getName()%>
            </td>
            <td><%=u.getSurname()%>
            </td>
            <td><%=u.getNationality().getNationality_name() == null ? "N/A" : u.getNationality().getNationality_name()%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
