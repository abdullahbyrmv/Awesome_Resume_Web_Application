<%@ page import="Resume_Desktop_App.JDBC.dao.UserInterface" %>
<%@ page import="Resume_Desktop_App.Desktop_App.Context" %>
<%@ page import="Resume_Desktop_App.JDBC.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Web Application</title>
    <link rel="stylesheet" href="assets/users.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
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

<div class="container myContainer">
    <div class="row">
        <div class="col-4">
            <form action="users.jsp" method="GET">
                <%--@declare id="surname"--%><%--@declare id="name"--%>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input placeholder="Please Enter Name" class="form-control" type="text" name="name" value=""/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input placeholder="Please Enter Surname" class="form-control" type="text" name="surname"
                           value=""/>
                </div>
                <br>
                <div>
                    <input class="btn btn-primary" type="submit" name="search" value="Search"/>
                </div>
            </form>
        </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <th></th>
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
                <td style="width:5px">
                    <form action="userDetail" method="GET">
                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                        <input type="hidden" name="action" value="update"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            <i class="update_delete_buttons fa-solid fa-square-pen"></i>
                        </button>
                    </form>
                </td>
                <td style="width:5px">
                    <form action="userDetail" method="POST">
                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button class="btn btn-danger" type="submit" value="delete">
                            <i class="update_delete_buttons fa-solid fa-trash-can"></i>
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
