package controller.commands.admin.labels.post;

import controller.interfaces.ServletAction;
import dao.LabelDAO;
import entity.Label;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LabelAddPostServletActionImpl implements ServletAction {
    private MainService<Label> service;

    private final String ADMIN_LABEL_HOME_PAGE;
    private final String ADMIN_LABEL_ADD_PAGE;

    public LabelAddPostServletActionImpl() {
        service = new LabelService(new LabelDAO());

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_HOME_PAGE");
        ADMIN_LABEL_ADD_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_ADD_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Label label = service.getObjectById(id);
            if(service.addObject(label)) {
                return ADMIN_LABEL_HOME_PAGE;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LABEL_ADD_PAGE;
    }
}
