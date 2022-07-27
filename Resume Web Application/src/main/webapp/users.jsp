<%@ page import="Resume_Desktop_App.JDBC.dao.UserInterface" %>
<%@ page import="Resume_Desktop_App.Desktop_App.Context" %>
<%@ page import="Resume_Desktop_App.JDBC.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Web Application</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="assets/javascript/users.js"></script>
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

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                You Sure?
            </div>
            <div class="modal-footer">
                <form action="userDetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </form>
            </div>
        </div>
    </div>
</div>

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
                    <input class="btn btn-primary" type="submit" name="search" value="Search" id="Searchbtn"/>
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
                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button class="btn btn-danger" type="submit" value="delete" data-toggle="modal"
                            data-target="#exampleModal" onclick="setIdForDelete('<%=u.getId()%>')">
                        <i class="update_delete_buttons fa-solid fa-trash-can"></i>
                    </button>
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
