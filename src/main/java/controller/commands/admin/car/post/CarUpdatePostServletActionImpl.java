package controller.commands.admin.car.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import entity.Car;
import entity.Label;
import entity.Level;
import service.CarService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarUpdatePostServletActionImpl implements ServletAction {
    private MainService<Car> service;
    private final String ADMIN_CAR_HOME_PAGE;

    public CarUpdatePostServletActionImpl() {
        service = new CarService(new CarDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = property.getCommandsProperty("ADMIN_CAR_HOME");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Car car = Car.newBuilder()
                .setName(req.getParameter("name"))
                .setPrice(Integer.parseInt(req.getParameter("price")))
                .setJpg(req.getParameter("jpg"))
                .setLevel(
                        Level.newBuilder()
                                .setName(req.getParameter("level_name"))
                                .build()
                )
                .setLabel(Label.newBuilder()
                        .setName(req.getParameter("label_name"))
                        .build())
                .setDesc(req.getParameter("desc"))
                .build();
        service.updateObject(car);
        return ADMIN_CAR_HOME_PAGE;
    }
}
