package controller.commands.admin.levels.get;

import controller.interfaces.ServletAction;
import dao.LevelDAO;
import entity.Label;
import entity.Level;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LevelUpdateGetServletActionImpl implements ServletAction {
    private final String ADMIN_LEVEL_UPDATE_PAGE;
    private final MainService<Level> levelService;

    public LevelUpdateGetServletActionImpl() {
        this.levelService = new LevelService(new LevelDAO());
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LEVEL_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_LEVEL_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String labelId = request.getParameter("id");
        try {
            Level level = levelService.getObjectById(Integer.parseInt(labelId));
            request.setAttribute("level", level);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LEVEL_UPDATE_PAGE;
    }
}
