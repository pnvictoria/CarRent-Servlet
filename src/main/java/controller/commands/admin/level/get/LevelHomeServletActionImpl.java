package controller.commands.admin.level.get;

import controller.interfaces.ServletAction;
import dao.LevelDAO;
import entity.Level;
import service.LevelService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LevelHomeServletActionImpl implements ServletAction {
    private final String ADMIN_LEVEL_HOME_PAGE;

    public LevelHomeServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LEVEL_HOME_PAGE = propertyPage.getPageProperty("ADMIN_LEVEL_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Level> allLevels = null;
        try {
            allLevels = new LevelService(new LevelDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allLevels", allLevels);
        return ADMIN_LEVEL_HOME_PAGE;
    }
}
