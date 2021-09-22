package controller.commands.admin.label.post;

import controller.interfaces.ServletAction;
import dao.CarDAO;
import dao.LabelDAO;
import entity.Car;
import entity.Label;
import service.CarService;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LabelDeletePostServletActionImpl implements ServletAction {
    private MainService<Label> service;
    private final String ADMIN_LABEL_HOME_PAGE;

    public LabelDeletePostServletActionImpl() {
        this.service = new LabelService(new LabelDAO());
        ReadPropertiesFile property = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = property.getCommandsProperty("ADMIN_LABEL_HOME");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.deleteObject(Integer.parseInt(request.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LABEL_HOME_PAGE;
    }
}