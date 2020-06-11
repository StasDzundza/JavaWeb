package adminServlets;

import Database.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allRooms")
public class ShowingRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBConnection connection = new DBConnection();
        request.setAttribute("rooms", connection.getRoomList());
        getServletContext().getRequestDispatcher("/administration/rooms.jsp").forward(request, response);
    }
}
