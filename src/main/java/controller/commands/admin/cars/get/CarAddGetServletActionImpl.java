package controller.commands.admin.cars.get;

import controller.interfaces.ServletAction;
import dao.LabelDAO;
import dao.LevelDAO;
import entity.Car;
import entity.Label;
import entity.Level;
import service.LabelService;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CarAddGetServletActionImpl implements ServletAction {
    private final MainService<Label> labelService;
    private final MainService<Level> levelService;
    private final String ADMIN_CAR_ADD_PAGE;

    public CarAddGetServletActionImpl() {
        this.labelService = new LabelService(new LabelDAO());
        this.levelService = new LevelService(new LevelDAO());
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_CAR_ADD_PAGE = propertyPage.getPageProperty("ADMIN_CAR_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Label> allLabels = null;
        List<Level> allLevels = null;
        try {
            allLabels = labelService.getObjects();
            allLevels = levelService.getObjects();
            req.setAttribute("allLabels", allLabels);
            req.setAttribute("allLevels", allLevels);
            System.out.println(allLabels);
            System.out.println(allLevels);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_CAR_ADD_PAGE;
    }
}
