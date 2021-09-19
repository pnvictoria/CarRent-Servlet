package controller.commands.user.sign_out;

import controller.interfaces.ServletAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpGetServletAction implements ServletAction {
    private final String SIGN_UP_PAGE = "/main/pages/sign-up.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return SIGN_UP_PAGE;
    }
}
