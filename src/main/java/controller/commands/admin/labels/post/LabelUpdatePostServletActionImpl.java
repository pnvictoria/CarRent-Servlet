package controller.commands.admin.labels.post;

import controller.commands.CommandManager;
import controller.commands.admin.labels.get.LabelHomeServletActionImpl;
import controller.interfaces.ServletAction;
import dao.LabelDAO;
import entity.Label;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LabelUpdatePostServletActionImpl implements ServletAction {
    private MainService<Label> service;

    private final String ADMIN_LABEL_HOME_PAGE;

    public LabelUpdatePostServletActionImpl() {
        service = new LabelService(new LabelDAO());

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Label label = service.getObjectById(Integer.parseInt(req.getParameter("id")));
            label.setName(req.getParameter("name"));
            service.updateObject(label);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LABEL_HOME_PAGE;
    }
}
