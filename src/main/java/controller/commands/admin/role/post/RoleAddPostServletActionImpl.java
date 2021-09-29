package controller.commands.admin.role.post;

import controller.interfaces.ServletAction;
import dao.RoleDAO;
import entity.Role;
import service.RoleService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RoleAddPostServletActionImpl implements ServletAction {
    private MainService<Role> service;
    private final String ADMIN_ROLE_HOME_PAGE;
    private final String ADMIN_ROLE_ADD_PAGE;

    public RoleAddPostServletActionImpl(MainService<Role> roleService) {
        this.roleService = roleService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = property.getCommandsProperty("ADMIN_ROLE_HOME");
        ADMIN_ROLE_ADD_PAGE = property.getCommandsProperty("ADMIN_ROLE_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Role role = Role.newBuilder()
                    .setName(req.getParameter("name"))
                    .build();
            if(roleService.addObject(role)) {
                return ADMIN_ROLE_HOME_PAGE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_ROLE_ADD_PAGE;
    }
}
