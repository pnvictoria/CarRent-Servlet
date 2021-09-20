package controller.commands.user.sign_up;

import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.Role;
import entity.User;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class SignUpPostServletAction implements ServletAction {
    private final int ROLE_USER_ID;
    private final String ROLE_USER;

    private final String MAIN_PAGE;
    private final String SIGN_UP_PAGE;

    private MainService<User> service;

    public SignUpPostServletAction() {
        service = new UserService(new UserDAO());

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        MAIN_PAGE = propertyPage.getPageProperty("MAIN_PAGE");
        SIGN_UP_PAGE = propertyPage.getPageProperty("SIGN_UP_PAGE");

        ReadPropertiesFile propertyRole = new ReadPropertiesFile();
        ROLE_USER_ID = Integer.parseInt(propertyRole.getConstantProperty("ROLE_USER_ID"));
        ROLE_USER = propertyRole.getConstantProperty("ROLE_USER");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.newBuilder()
                .setName(req.getParameter("name"))
                .setSurname(req.getParameter("surname"))
                .setSex(getUserSex(req.getParameter("sex")))
                .setDate(req.getParameter("day"))
                .setEmail(req.getParameter("email"))
                .setPassword(req.getParameter("password"))
                .setRole(
                        Role.newBuilder()
                                .setId(ROLE_USER_ID)
                                .setName(ROLE_USER)
                                .build())
                .build();
        try {
            if(service.addObject(user)) {
                return MAIN_PAGE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SIGN_UP_PAGE;
    }

    public boolean getUserSex(String sex) {
        return Objects.equals(sex, "female");
    }
}
