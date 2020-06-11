package adminServlets;

import Database.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dismissingWorker")
public class DismissingWorkerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection connection = new DBConnection();
        connection.dismissWorker(Integer.parseInt(request.getParameter("id")));
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
