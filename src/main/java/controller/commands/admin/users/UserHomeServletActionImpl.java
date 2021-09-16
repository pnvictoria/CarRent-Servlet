package controller.commands.admin.users;

import controller.interfaces.ServletAction;
import dao.UsersDAO;
import entity.Users;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserHomeServletActionImpl implements ServletAction {
    private final String ADMIN_USER_PAGE = "/main/pages/admin/admin-users.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> allUsers = null;
        try {
            allUsers = new UsersService(new UsersDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allUsers", allUsers);

        return ADMIN_USER_PAGE;
    }
}
