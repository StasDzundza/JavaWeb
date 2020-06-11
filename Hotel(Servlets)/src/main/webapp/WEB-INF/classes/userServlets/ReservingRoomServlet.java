package userServlets;

import Database.DBConnection;
import Hotel.Order;
import Hotel.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/reserveRoom")
public class ReservingRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection connection = new DBConnection();
        Room room = connection.getRoom(Integer.parseInt(request.getParameter("room")));
        HttpSession session = request.getSession();
        Date dateFrom = (Date)session.getAttribute("dateFrom");
        Date dateTo = (Date)session.getAttribute("dateTo");
        Order order = new Order();
        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);
        order.setRoom(room.getNum());
        order.setFirstName(request.getParameter("firstName"));
        order.setLastName(request.getParameter("lastName"));
        connection.addOrder(order);
        getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
    }

}
