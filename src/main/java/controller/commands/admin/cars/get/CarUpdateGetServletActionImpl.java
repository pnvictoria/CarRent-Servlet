package controller.commands.admin.cars.get;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import dao.LabelDAO;
import dao.LevelDAO;
import entity.Car;
import entity.Label;
import entity.Level;
import service.CarService;
import service.LabelService;
import service.LevelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CarUpdateGetServletActionImpl implements ServletAction {
    private final String ADMIN_CAR_UPDATE_PAGE;
    private final MainService<Car> carService;
    private final MainService<Label> labelService;
    private final MainService<Level> levelService;

    public CarUpdateGetServletActionImpl() {
        this.carService = new CarService(new CarDAO());
        this.labelService = new LabelService(new LabelDAO());
        this.levelService = new LevelService(new LevelDAO());
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_CAR_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_CAR_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        List<Label> allLabels = null;
        List<Level> allLevels = null;
        try {
            Car car = carService.getObjectById(Integer.parseInt(id));
            allLabels = labelService.getObjects();
            allLevels = levelService.getObjects();
            req.setAttribute("car", car);
            req.setAttribute("allLabels", allLabels);
            req.setAttribute("allLevels", allLevels);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_CAR_UPDATE_PAGE;
    }
}