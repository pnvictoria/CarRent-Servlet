package controller.commands.admin.labels.get;

import controller.interfaces.ServletAction;
import dao.LabelDAO;
import entity.Label;
import service.LabelService;
import service.interfaces.MainService;
import utils.ReadPropertiesFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LabelUpdateGetServletActionImpl implements ServletAction {
    private final String ADMIN_LABEL_UPDATE_PAGE;
    private final MainService<Label> labelService;

    public LabelUpdateGetServletActionImpl() {
        this.labelService = new LabelService(new LabelDAO());
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        ADMIN_LABEL_UPDATE_PAGE = propertyPage.getPageProperty("ADMIN_LABEL_UPDATE_PAGE");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String labelId = request.getParameter("id");
        try {
            Label objectById = labelService.getObjectById(Integer.parseInt(labelId));
            request.setAttribute("label", objectById);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LABEL_UPDATE_PAGE;
    }
}
