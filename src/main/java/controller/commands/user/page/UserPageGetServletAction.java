package controller.commands.user.page;

import controller.interfaces.ServletAction;
import entity.Car;
import entity.Order;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPageGetServletAction implements ServletAction {
    private MainService<Order> orderService;
    private MainService<Car> carService;
    private final String USER_MAIN_PAGE;

    public UserPageGetServletAction(MainService<Order> orderService, MainService<Car> carService) {
        this.orderService = orderService;
        this.carService = carService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_MAIN_PAGE = propertyPage.getPageProperty("USER_MAIN_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carFromOrders = new ArrayList<>();
        try {
            for (Order order : orderService.getObjects()) {
                if(order != null){
                    carFromOrders.add(carService.getObjectById(order.getId()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("carFromOrders", carFromOrders);


        return USER_MAIN_PAGE;
    }
}
