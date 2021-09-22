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

public class RoleDeleteServletActionImpl implements ServletAction {
    private MainService<Role> service;
    private final String ADMIN_ROLE_HOME_PAGE;

    public RoleDeleteServletActionImpl() {
        this.service = new RoleService(new RoleDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_ROLE_HOME_PAGE = property.getCommandsProperty("ADMIN_ROLE_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_ROLE_HOME_PAGE;
    }
}