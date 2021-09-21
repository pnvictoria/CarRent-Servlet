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
        String id = request.getParameter("id");
        try {
            Label label = labelService.getObjectById(Integer.parseInt(id));
            request.setAttribute("label", label);
            System.out.println(label);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADMIN_LABEL_UPDATE_PAGE;
    }
}
