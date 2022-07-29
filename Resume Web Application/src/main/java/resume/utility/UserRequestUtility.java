//package resume;
//import Resume_Desktop_App.Desktop_App.Context;
//import Resume_Desktop_App.JDBC.dao.UserInterface;
//import Resume_Desktop_App.JDBC.entity.User;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class UserRequestUtility {
//    public static void CheckRequest(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException {
//        String userIdStr = request.getParameter("id");
//        if (userIdStr == null || userIdStr.trim().isEmpty()) {
//            throw new IllegalArgumentException("id is not specified");
//        }
//    }
//
//    public static User ProcessRequest(HttpServletRequest request, HttpServletResponse response) {
//            UserRequestUtility.CheckRequest(request, response);
//            Integer userId = Integer.parseInt(request.getParameter("id"));
//            UserInterface userDao = Context.instanceUserDao();
//            User u = userDao.getByID(userId);
//            if (u == null) {
//                throw new IllegalArgumentException("There is no user with this id");
//            }
//            return u;
//    }
//}
