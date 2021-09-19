package controller.commands.user.sign_in;

import controller.interfaces.ServletAction;
import dao.UsersDAO;
import entity.User;
import service.UsersService;
import service.interfaces.MainService;
import utils.constants.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignInPostServletAction implements ServletAction {
    private final String ROLE_ADMIN;
    private final String ROLE_USER;

    private final String SUCCESSFUL_RESULT;
    private final String NOT_SUCCESSFUL_RESULT;

    private MainService<User> service;

    public SignInPostServletAction() {
        service = new UsersService(new UsersDAO());

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        SUCCESSFUL_RESULT = propertyPage.getPageProperty("SUCCESSFUL_RESULT");
        NOT_SUCCESSFUL_RESULT = propertyPage.getPageProperty("NOT_SUCCESSFUL_RESULT");

        ReadPropertiesFile propertyRoles= new ReadPropertiesFile();
        ROLE_ADMIN = propertyRoles.getConstantProperty("ROLE_ADMIN");
        ROLE_USER = propertyRoles.getConstantProperty("ROLE_USER");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            //CHANGE, just test
            user = service.getObjectById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if ((req.getParameter("email").equals(user.getEmail())
                && req.getParameter("password").equals(user.getPassword()))) {
            if (ROLE_ADMIN.equals(user.getRole().getName())) {
                return SUCCESSFUL_RESULT;
            }
            if (ROLE_USER.equals(user.getRole().getName())) {
                return SUCCESSFUL_RESULT;
            }
        }
        return NOT_SUCCESSFUL_RESULT;
    }
}
