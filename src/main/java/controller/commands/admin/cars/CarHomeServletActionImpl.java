package controller.commands.admin.cars;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import entity.Car;
import service.CarService;
import utils.ReadPropertiesFile;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarHomeServletActionImpl implements ServletAction {
    private final String ADMIN_CAR_HOME_PAGE;

    public CarHomeServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_CAR_HOME_PAGE = propertyPage.getPageProperty("ADMIN_CAR_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> allCars = null;
        try {
            allCars = new CarService(new CarDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allCars", allCars);
        return ADMIN_CAR_HOME_PAGE;
    }
}
