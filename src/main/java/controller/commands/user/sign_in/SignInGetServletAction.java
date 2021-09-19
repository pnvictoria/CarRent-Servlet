package controller.commands.user.sign_in;

import controller.interfaces.ServletAction;
import utils.constants.ReadPropertiesFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInGetServletAction implements ServletAction {
    private final String SIGN_IN_PAGE;

    public SignInGetServletAction() {
        ReadPropertiesFile property = new ReadPropertiesFile();
        SIGN_IN_PAGE = property.getPageProperty("SIGN_IN_PAGE");
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return SIGN_IN_PAGE;
    }
}
