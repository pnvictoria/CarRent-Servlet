package controller.servlet;

import controller.commands.CommandManager;
import controller.interfaces.ServletAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private CommandManager commandManager;

    @Override
    public void init() throws ServletException {
        commandManager = new CommandManager();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletAction command = commandManager.getCommand(request);
        String loadedPage = command.execute(request, response);
        request.getRequestDispatcher(loadedPage).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletAction command = commandManager.getCommand(request);
        String loadedMapping = command.execute(request, response);
        response.sendRedirect(request.getContextPath() + loadedMapping);
    }
}
