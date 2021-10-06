package controller.commands.admin.order.post;

import controller.interfaces.ServletAction;
import entity.Order;
import entity.State;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class OrderApproveServletActionImpl implements ServletAction {
    private final MainService<Order> orderService;
    private final MainService<State> stateService;
    private final String ADMIN_ORDER_HOME_PAGE;

    //TODO
    private final int ID_APPROVE = 2;

    public OrderApproveServletActionImpl(MainService<Order> orderService, MainService<State> stateService) {
        this.orderService = orderService;
        this.stateService = stateService;
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_ORDER_HOME_PAGE = property.getCommandsProperty("ADMIN_ORDER_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            orderService.updateObject(Order.newBuilder()
                    .setId(Integer.parseInt(request.getParameter("id")))
                    .setState(stateService.getObjectById(ID_APPROVE))
                    .build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_ORDER_HOME_PAGE;
    }
}