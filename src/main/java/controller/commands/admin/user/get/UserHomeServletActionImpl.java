package controller.commands.admin.user.get;

import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.User;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserHomeServletActionImpl implements ServletAction {
    private final String ADMIN_USER_HOME_PAGE;

    public UserHomeServletActionImpl(MainService<User> userService) {
        this.userService = userService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_USER_HOME_PAGE = propertyPage.getPageProperty("ADMIN_USER_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = null;
        try {
            allUsers = userService.getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allUsers", allUsers);
        return ADMIN_USER_HOME_PAGE;
    }
}
