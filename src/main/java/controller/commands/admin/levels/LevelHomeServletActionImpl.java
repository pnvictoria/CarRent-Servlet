package controller.commands.admin.levels;

import controller.interfaces.ServletAction;
import dao.LevelsDAO;
import dao.RolesDAO;
import entity.Levels;
import entity.Roles;
import service.LevelsService;
import service.RolesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LevelHomeServletActionImpl implements ServletAction {
    private final String ADMIN_LEVEL_PAGE = "/main/pages/admin/admin-levels.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Levels> allLevels = null;
        try {
            allLevels = new LevelsService(new LevelsDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allLevels", allLevels);

        return ADMIN_LEVEL_PAGE;
    }
}
