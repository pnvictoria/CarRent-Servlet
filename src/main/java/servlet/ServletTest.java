package servlet;

import dao.UsersDAO;
import service.UsersService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class ServletTest extends HttpServlet {

    public ServletTest() {
    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("HelloServlet#doGet");
//
//        resp.getWriter().println("Hi!!!");
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        boolean userRegistrated = false;
        try {
            userRegistrated = new UsersService(new UsersDAO()).isUserRegistrated(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userRegistrated)
            response.sendRedirect("/ServletMainPage");
        else
            out.println("wrong");


//        try {
//            DriverManager.registerDriver(new org.postgresql.Driver());
//
//            String dbURL = "jdbc:postgresql://localhost:5432/postgres";
//            Properties parameters = new Properties();
//            parameters.put("user", "postgres");
//            parameters.put("password", "123qwe");
//            Connection conn = DriverManager.getConnection(dbURL, parameters);
//
//
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(
//                    "SELECT email, password\n" +
//                            "\tFROM \"servlet-car\".\"user\" where email = '"+email+"' and password = '"+password + "'");
//
//
//            if(resultSet.next())
//                response.sendRedirect("items.jsp");
//            else
//                out.println("wrong");
//
//            conn.close();
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


    }

}
