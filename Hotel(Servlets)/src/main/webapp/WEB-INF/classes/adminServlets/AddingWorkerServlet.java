package adminServlets;

import Hotel.Worker;
import Database.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addingWorker")
public class AddingWorkerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker worker = new Worker();
        worker.setAge(Integer.parseInt(request.getParameter("age")));
        worker.setSalary(Integer.parseInt(request.getParameter("salary")));
        worker.setFirstName(request.getParameter("firstName"));
        worker.setLastName(request.getParameter("lastName"));
        worker.setRole(request.getParameter("role"));
        worker.setPhone(request.getParameter("phone"));
        DBConnection connection = new DBConnection();
        connection.addWorker(worker);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
