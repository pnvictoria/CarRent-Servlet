package controller.commands.admin.labels;

import controller.interfaces.ServletAction;
import dao.LabelsDAO;
import entity.Label;
import service.LabelsService;
import utils.constants.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LabelHomeServletActionImpl implements ServletAction {
    private final String ADMIN_LABEL_HOME_PAGE;

    public LabelHomeServletActionImpl() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_HOME_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_HOME_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Label> allLabels = null;
        try {
            allLabels = new LabelsService(new LabelsDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allLabels", allLabels);
        return ADMIN_LABEL_HOME_PAGE;
    }
}
