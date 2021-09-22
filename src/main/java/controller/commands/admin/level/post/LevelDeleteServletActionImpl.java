package controller.commands.admin.level.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import dao.LevelDAO;
import entity.Car;
import entity.Level;
import service.CarService;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LevelDeleteServletActionImpl implements ServletAction {
    private MainService<Level> service;
    private final String ADMIN_LEVEL_HOME_PAGE;

    public LevelDeleteServletActionImpl() {
        this.service = new LevelService(new LevelDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_LEVEL_HOME_PAGE = property.getCommandsProperty("ADMIN_LEVEL_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LEVEL_HOME_PAGE;
    }
}