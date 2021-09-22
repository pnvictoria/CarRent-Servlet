package controller.commands.admin.level.post;

import controller.interfaces.ServletAction;
import dao.LevelDAO;
import entity.Level;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LevelAddPostServletActionImpl implements ServletAction {
    private MainService<Level> service;
    private final String ADMIN_LEVEL_HOME_PAGE;
    private final String ADMIN_LEVEL_ADD_PAGE;

    public LevelAddPostServletActionImpl() {
        service = new LevelService(new LevelDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_LEVEL_HOME_PAGE = property.getCommandsProperty("ADMIN_LEVEL_HOME");
        ADMIN_LEVEL_ADD_PAGE = property.getCommandsProperty("ADMIN_LEVEL_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Level level = Level.newBuilder()
                    .setName(req.getParameter("name"))
                    .build();
            if(service.addObject(level)) {
                return ADMIN_LEVEL_HOME_PAGE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LEVEL_ADD_PAGE;
    }
}
