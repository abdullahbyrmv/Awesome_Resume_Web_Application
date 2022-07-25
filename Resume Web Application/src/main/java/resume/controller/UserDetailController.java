package resume.controller;

import Resume_Desktop_App.Desktop_App.Context;
import Resume_Desktop_App.JDBC.dao.UserInterface;
import Resume_Desktop_App.JDBC.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userDetail")
public class UserDetailController extends HttpServlet {
    private UserInterface userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equals("Update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            User user = userDao.getByID(id);
            user.setName(name);
            user.setSurname(surname);

            userDao.updateUser(user);
        } else if (action.equals("delete")) {
            userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(request.getParameter("id"));
            UserInterface userDao = Context.instanceUserDao();
            User u = userDao.getByID(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("owner", true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userDetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }
    }
}
