package controller.commands.user.sign_out;

import controller.interfaces.ServletAction;
import dao.UsersDAO;
import entity.Role;
import entity.User;
import service.UsersService;
import service.interfaces.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class SignUpPostServletAction implements ServletAction {
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";

    private final String SUCCESSFUL_RESULT = "/main/pages/admin/admin-cars.jsp";
    private final String NOT_SUCCESSFUL_RESULT = "/index.jsp";

    private MainService<User> service;

    public SignUpPostServletAction() {
        service = new UsersService(new UsersDAO());
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.newBuilder()
                .setName(req.getParameter("name"))
                .setSurname(req.getParameter("surname"))
                .setSex(returnUserSex(req.getParameter("sex")))
                .setDate(req.getParameter("day"))
                .setEmail(req.getParameter("email"))
                .setPassword(req.getParameter("password"))
                .setRole(
                        Role.newBuilder()
                                .setName(req.getParameter("role"))
                                .build())
                .build();


        try {
            if(service.addObject(user)) {
                return SUCCESSFUL_RESULT;
            } else {
                return NOT_SUCCESSFUL_RESULT;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return NOT_SUCCESSFUL_RESULT;
    }

    public boolean returnUserSex(String req) {
        return Objects.equals(req, "female");
    }
}
