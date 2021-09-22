package controller.commands.user.sign_in;

import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.User;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SignInPostServletAction implements ServletAction {
    private final String ROLE_ADMIN;
    private final String ROLE_USER;

    private final String ADMIN_PAGE;
    private final String MAIN_PAGE;
    private final String SIGN_IN_PAGE;

    private MainService<User> service;

    public SignInPostServletAction() {
        service = new UserService(new UserDAO());

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        MAIN_PAGE = propertyPage.getPageProperty("MAIN_PAGE");
        ADMIN_PAGE = propertyPage.getPageProperty("ADMIN_CAR_HOME_PAGE");

        ReadPropertiesFile propertyRole= new ReadPropertiesFile();
        ROLE_ADMIN = propertyRole.getConstantProperty("ROLE_ADMIN");
        ROLE_USER = propertyRole.getConstantProperty("ROLE_USER");
        SIGN_IN_PAGE = propertyRole.getConstantProperty("SIGN_IN_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = service.getByItem(User.newBuilder().setEmail(req.getParameter("email")).build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(users != null && !users.isEmpty()) {
            User user = users.get(0);
            if ((req.getParameter("email").equals(user.getEmail())
                    && req.getParameter("password").equals(user.getPassword()))) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                if (ROLE_ADMIN.equals(user.getRole().getName())) {
                    return ADMIN_PAGE;
                }
                if (ROLE_USER.equals(user.getRole().getName())) {
                    return MAIN_PAGE;
                }
            }
        }
        return SIGN_IN_PAGE;
    }
}
