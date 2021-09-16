package controller.commands.admin.cars;

import controller.interfaces.ServletAction;
import dao.CarsDAO;
import dao.RolesDAO;
import entity.Cars;
import entity.Roles;
import service.CarsService;
import service.RolesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarHomeServletActionImpl implements ServletAction {
    private final String ADMIN_CARS_PAGE = "/main/pages/admin/admin-cars.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cars> allCars = null;
        try {
            allCars = new CarsService(new CarsDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allCars", allCars);

        return ADMIN_CARS_PAGE;
    }
}
