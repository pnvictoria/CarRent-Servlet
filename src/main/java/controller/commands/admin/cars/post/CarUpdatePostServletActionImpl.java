package controller.commands.admin.cars.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import dao.LabelDAO;
import entity.Car;
import entity.Label;
import entity.Level;
import entity.mapper.LabelMapper;
import entity.mapper.LevelMapper;
import service.CarService;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
