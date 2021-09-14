package controller.commands;

import dao.UsersDAO;
import entity.Users;
import service.UsersService;
import service.interfaces.MainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

    MainService<Users> service;

    public SignInServlet() {
        service = new UsersService(new UsersDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/main/pages/sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        Users user = null;

        try {
            //CHANGE, just test
            user = service.getObjectById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if ((request.getParameter("email").equals(user.getEmail())
                && request.getParameter("password").equals(user.getPassword()))) {
            //CHANGE, just test
            if (user.getRole().getId() == 1) {
                response.sendRedirect("./admin/main");
            }
            if (user.getRole().getId() == 2) {
                response.sendRedirect("./");
            }
        } else {
            out.println("wrong");
        }
    }
}
