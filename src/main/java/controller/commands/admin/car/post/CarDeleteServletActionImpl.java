package controller.commands.admin.car.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import entity.Car;
import service.CarService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CarDeleteServletActionImpl implements ServletAction {
    private MainService<Car> service;
    private final String ADMIN_CAR_HOME_PAGE;

    public CarDeleteServletActionImpl() {
        this.service = new CarService(new CarDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = property.getCommandsProperty("ADMIN_CAR_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_CAR_HOME_PAGE;
    }
}
