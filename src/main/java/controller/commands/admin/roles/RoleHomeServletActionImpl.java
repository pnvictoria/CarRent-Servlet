package controller.commands.admin.roles;

import controller.interfaces.ServletAction;
import dao.RolesDAO;
import entity.Role;
import service.RolesService;
import utils.constants.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoleHomeServletActionImpl implements ServletAction {
    private final String ADMIN_ROLE_HOME_PAGE;

    public RoleHomeServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = propertyPage.getPageProperty("ADMIN_ROLE_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> allRoles = null;
        try {
            allRoles = new RolesService(new RolesDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allRoles", allRoles);
        return ADMIN_ROLE_HOME_PAGE;
    }
}
