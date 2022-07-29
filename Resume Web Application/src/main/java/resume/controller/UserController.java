package resume.controller;

import Resume_Desktop_App.Desktop_App.Context;
import Resume_Desktop_App.JDBC.dao.UserInterface;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private UserInterface userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
