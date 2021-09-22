package controller.commands.admin.car.post;

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

public class CarAddPostServletActionImpl implements ServletAction {
    private MainService<Car> service;
    private final MainService<Label> labelService;
    private final MainService<Level> levelService;
    private final String ADMIN_CAR_HOME_PAGE;
    private final String ADMIN_CAR_ADD_PAGE;

    public CarAddPostServletActionImpl() {
        this.labelService = new LabelService(new LabelDAO());
        this.levelService = new LevelService(new LevelDAO());
        service = new CarService(new CarDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = property.getCommandsProperty("ADMIN_CAR_HOME");
        ADMIN_CAR_ADD_PAGE = property.getCommandsProperty("ADMIN_CAR_ADD");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Car car = Car.newBuilder()
                    .setName(req.getParameter("name"))
                    .setPrice(Integer.parseInt(req.getParameter("price")))
                    .setJpg(req.getParameter("jpg"))
                    .setLevel(getLevelFromList(req.getParameter("level_name")))
                    .setLabel(getLabelFromList(req.getParameter("level_name")))
                    .setDesc(req.getParameter("desc"))
                    .build();
            if(service.addObject(car)) {
                return ADMIN_CAR_HOME_PAGE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_CAR_ADD_PAGE;
    }

    public Label getLabelFromList(String level_name){
        List<Label> label = null;
        try {
            label = labelService.getByItem(
                    Label.newBuilder()
                            .setName(level_name)
                            .build()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return label.get(1);
    }

    public Level getLevelFromList(String label_name){
        List<Level> label = null;
        try {
            label = levelService.getByItem(
                    Level.newBuilder()
                            .setName(label_name)
                            .build()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return label.get(1);
    }
}
