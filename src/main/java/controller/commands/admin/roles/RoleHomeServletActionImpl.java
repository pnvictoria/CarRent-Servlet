package controller.commands.admin.roles;

import controller.interfaces.ServletAction;
import dao.RolesDAO;
import entity.Roles;
import service.RolesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoleHomeServletActionImpl implements ServletAction {
    private final String ADMIN_ROLES_PAGE = "/main/pages/admin/admin-roles.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Roles> allRoles = null;
        try {
            allRoles = new RolesService(new RolesDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allRoles", allRoles);

        return ADMIN_ROLES_PAGE;
    }
}
