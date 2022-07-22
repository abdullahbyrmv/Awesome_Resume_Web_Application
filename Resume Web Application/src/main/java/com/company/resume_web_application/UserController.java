package com.company.resume_web_application;
import Resume_Desktop_App.Desktop_App.Context;
import Resume_Desktop_App.JDBC.dao.UserInterface;
import Resume_Desktop_App.JDBC.entity.User;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private UserInterface userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = userDao.getByID(id);
        user.setName(name);
        user.setSurname(surname);

        userDao.updateUser(user);
        response.sendRedirect("index.jsp");
    }
}
