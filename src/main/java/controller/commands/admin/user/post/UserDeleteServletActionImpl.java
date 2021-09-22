package controller.commands.admin.user.post;

import controller.interfaces.ServletAction;
import dao.UserDAO;
import entity.User;
import service.UserService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserDeleteServletActionImpl implements ServletAction {
    private MainService<User> service;
    private final String ADMIN_USER_HOME_PAGE;

    public UserDeleteServletActionImpl() {
        this.service = new UserService(new UserDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_USER_HOME_PAGE = property.getCommandsProperty("ADMIN_USER_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_USER_HOME_PAGE;
    }
}