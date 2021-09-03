import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

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

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            String dbURL = "jdbc:postgresql://localhost:5433/servletСar";
            Properties parameters = new Properties();
            parameters.put("email", "postgres");
            parameters.put("password", "123qwe");
            Connection conn = DriverManager.getConnection(dbURL, parameters);

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"servletСar\".\"user\" where "+email+" and "+password);

            System.out.println("1");
            if(resultSet.next())
                response.sendRedirect("items.jsp");
            else
                out.println("wrong");

            conn.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
