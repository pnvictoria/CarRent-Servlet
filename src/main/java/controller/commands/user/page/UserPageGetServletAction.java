package controller.commands.user.page;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageGetServletAction implements ServletAction {
    private final String userPage;

    public UserPageGetServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        userPage = propertyPage.getPageProperty("USER_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return userPage;
    }
}
