package controller.commands.admin.role.get;

import controller.interfaces.ServletAction;
import dao.RoleDAO;
import entity.Role;
import service.RoleService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RoleUpdateGetServletActionImpl implements ServletAction {
    private final String ADMIN_ROLE_UPDATE_PAGE;
    private final MainService<Role> roleService;

    public RoleUpdateGetServletActionImpl(MainService<Role> roleService) {
        this.roleService = roleService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_ROLE_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_ROLE_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            Role role = roleService.getObjectById(Integer.parseInt(id));
            request.setAttribute("role", role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_ROLE_UPDATE_PAGE;
    }
}

