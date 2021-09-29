package controller.commands.admin.label.get;

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
import java.util.List;

public class LabelHomeServletActionImpl implements ServletAction {
    private final String ADMIN_LABEL_HOME_PAGE;

    public LabelHomeServletActionImpl(MainService<Label> labelService) {
        this.labelService = labelService;
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Label> allLabels = null;
        try {
            allLabels = labelService.getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allLabels", allLabels);
        return ADMIN_LABEL_HOME_PAGE;
    }
}
