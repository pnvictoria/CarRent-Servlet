package controller.commands.admin.labels;

import controller.interfaces.ServletAction;
import dao.LabelsDAO;
import entity.Labels;
import service.LabelsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LabelHomeServletActionImpl implements ServletAction {
    private final String ADMIN_LABEL_PAGE = "/main/pages/admin/admin-labels.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Labels> allLabels = null;
        try {
            allLabels = new LabelsService(new LabelsDAO()).getObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("allLabels", allLabels);

        return ADMIN_LABEL_PAGE;
    }
}
