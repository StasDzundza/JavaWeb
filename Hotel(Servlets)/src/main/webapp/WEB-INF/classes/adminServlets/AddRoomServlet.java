package adminServlets;

import Database.DBConnection;
import Hotel.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addRoom")
public class AddRoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Room room = new Room();
        room.setNum(Integer.parseInt(req.getParameter("num")));
        room.setPrice(Integer.parseInt(req.getParameter("price")));
        room.setOccupancy(Integer.parseInt(req.getParameter("occupancy")));
        room.setCategory(req.getParameter("category"));
        room.setFloor(Integer.parseInt(req.getParameter("floor")));
        DBConnection.addRoom(room);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
