package controller.commands.user.page;

import controller.interfaces.ServletAction;
import utils.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class UserPageGetServletAction implements ServletAction {
    private final String USER_PAGE;

    public UserPageGetServletAction() {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        USER_PAGE = propertyPage.getPageProperty("USER_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return USER_PAGE;
    }
}
