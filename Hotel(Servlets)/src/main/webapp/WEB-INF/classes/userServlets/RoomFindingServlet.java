package userServlets;

import Database.DBConnection;
import Hotel.OrderFeatures;
import Hotel.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/findRoom")
public class RoomFindingServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RoomFindingServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DBConnection connection = new DBConnection();
            OrderFeatures orderFeatures = createOrderFeaturesInstance(request);
            Date dateFrom = orderFeatures.getDateFrom();
            Date todayDate = new Date();
            if(dateFrom.compareTo(todayDate) < 0){
                request.setAttribute("error","Invalid date");
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }
            ArrayList<Room> rooms = connection.getSuitableRooms(orderFeatures);
            connection.discardReservedRooms(rooms, orderFeatures.getDateFrom(), orderFeatures.getDateTo());
            request.setAttribute("rooms", rooms);
            getServletContext().getRequestDispatcher("/user/suitable_rooms.jsp").forward(request, response);
        } catch (ParseException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    private OrderFeatures createOrderFeaturesInstance(HttpServletRequest request) throws ParseException {
        OrderFeatures orderFeatures = new OrderFeatures();
        orderFeatures.setMinPrice(Integer.parseInt(request.getParameter("minPrice")));
        orderFeatures.setMaxPrice(Integer.parseInt(request.getParameter("maxPrice")));
        String[] categories = request.getParameterValues("categories");
        orderFeatures.setCheckedCategories(categories);
        orderFeatures.setOccupancy(Integer.parseInt(request.getParameter("occupancy")));

        HttpSession session = request.getSession();
        String dateFrom = request.getParameter("dateFrom");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateFrom);
        java.sql.Date sqlDateFrom = new java.sql.Date(date.getTime());
        orderFeatures.setDateFrom(sqlDateFrom);
        session.setAttribute("dateFrom", sqlDateFrom);

        String dateTo = request.getParameter("dateTo");
        date = sdf.parse(dateTo);
        java.sql.Date sqlDateTo = new java.sql.Date(date.getTime());
        orderFeatures.setDateTo(sqlDateTo);
        session.setAttribute("dateTo", sqlDateTo);
        return orderFeatures;
    }
}
