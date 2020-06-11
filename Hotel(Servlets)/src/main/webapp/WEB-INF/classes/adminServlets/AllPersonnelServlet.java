package adminServlets;

import Database.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allPersonnel")
public class AllPersonnelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection connection = new DBConnection();
        request.setAttribute("workers", connection.getWorkersList());
        getServletContext().getRequestDispatcher("/administration/workers.jsp").forward(request, response);
    }
}
