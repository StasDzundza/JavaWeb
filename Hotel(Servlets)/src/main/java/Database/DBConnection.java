package Database;

import Hotel.Order;
import Hotel.OrderFeatures;
import Hotel.Room;
import Hotel.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static final String JDBC_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "dzundza";
    private static final String PASSWORD = "321";

    public static ArrayList<Worker> getWorkersList() {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String sql = "SELECT * from PERSONNEL";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Worker> workersList = new ArrayList<>();
            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt(1));
                worker.setFirstName(resultSet.getString(2));
                worker.setLastName(resultSet.getString(3));
                worker.setSalary(resultSet.getInt(4));
                worker.setRole(resultSet.getString(5));
                worker.setAge(resultSet.getInt(6));
                worker.setPhone(resultSet.getString(7));
                workersList.add(worker);
            }
            return workersList;

        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public static ArrayList<Order> getOrderList() {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "SELECT * from ORDERS";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDateFrom(resultSet.getDate(2));
                order.setDateTo(resultSet.getDate(3));
                order.setRoom(resultSet.getInt(4));
                order.setFirstName(resultSet.getString(5));
                order.setLastName(resultSet.getString(6));
                order.setStatus(resultSet.getString(7));

                orders.add(order);
            }
            return orders;

        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public static ArrayList<Room> getRoomList() {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String sql = "SELECT * from ROOMS";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room();
                room.setNum(resultSet.getInt(1));
                room.setFloor(resultSet.getInt(2));
                room.setPrice(resultSet.getInt(3));
                room.setCategory(resultSet.getString(4));
                room.setOccupancy(resultSet.getInt(5));
                rooms.add(room);
            }
            return rooms;
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public static void addWorker(Worker worker) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String sql = "INSERT INTO PERSONNEL (FIRST_NAME,LAST_NAME,SALARY,ROLE,AGE,ID,PHONE) VALUES (?,?,?,?,?,PERSONNEL_ID.NEXTVAL,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, worker.getFirstName());
            preparedStatement.setString(2, worker.getLastName());
            preparedStatement.setInt(3, worker.getSalary());
            preparedStatement.setString(4, worker.getRole());
            preparedStatement.setInt(5, worker.getAge());
            preparedStatement.setString(6, worker.getPhone());
            preparedStatement.executeQuery();

        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void addRoom(Room room) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String sql = "INSERT INTO ROOMS (NUM,PRICE,CATEGORY,OCCUPANCY,FLOOR) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,room.getNum());
            preparedStatement.setInt(2,room.getPrice());
            preparedStatement.setString(3,room.getCategory());
            preparedStatement.setInt(4,room.getOccupancy());
            preparedStatement.setInt(5,room.getFloor());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void updateSalary(int workerID, int salary) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "UPDATE PERSONNEL SET SALARY = ? WHERE ID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, salary);
            preparedStatement.setInt(2, workerID);
            preparedStatement.executeQuery();
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void dismissWorker(int workerID) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "DELETE FROM PERSONNEL WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, workerID);
            preparedStatement.executeQuery();
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static ArrayList<Room> getSuitableRooms(OrderFeatures orderFeatures) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "SELECT * FROM ROOMS " +
                    "WHERE((PRICE BETWEEN ? AND ?) AND (OCCUPANCY = ?) AND (CATEGORY IN (?,?,?)))";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderFeatures.getMinPrice());
            statement.setInt(2, orderFeatures.getMaxPrice());
            statement.setInt(3, orderFeatures.getOccupancy());
            int index = 4;
            String[] categories = orderFeatures.getCheckedCategories();
            for (String category : categories) {
                statement.setString(index++, category);
            }
            for (int i = index; i < 7; i++) {
                statement.setString(index++, "none");
            }
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                Room room = new Room();
                room.setNum(resultSet.getInt(1));
                room.setFloor(resultSet.getInt(2));
                room.setPrice(resultSet.getInt(3));
                room.setCategory(resultSet.getString(4));
                room.setOccupancy(resultSet.getInt(5));
                rooms.add(room);
            }
            return rooms;

        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public static void discardReservedRooms(ArrayList<Room> allRooms, Date dateFrom, Date dateTo) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "SELECT ROOM FROM ORDERS " +
                    "WHERE(STATUS = '+' AND " +
                    "((? > DATE_FROM AND ? < DATE_TO) OR (? > DATE_FROM AND ? < DATE_TO) OR (? < DATE_FROM AND ? > DATE_TO)))";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, dateFrom);
            statement.setDate(2, dateFrom);
            statement.setDate(3, dateTo);
            statement.setDate(4, dateTo);
            statement.setDate(5, dateFrom);
            statement.setDate(6, dateTo);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Integer> reservedRooms = new ArrayList<>();
            while (resultSet.next()) {
                reservedRooms.add(resultSet.getInt(1));
            }
            for (int i = 0; i < allRooms.size(); i++) {
                boolean found = false;
                for (Integer roomNum : reservedRooms) {
                    if (allRooms.get(i).getNum() == roomNum) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    allRooms.remove(i);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    public static Room getRoom(int roomNumber) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "SELECT * FROM ROOMS WHERE NUM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomNumber);
            ResultSet resultSet = statement.executeQuery();
            Room room = null;
            while (resultSet.next()) {
                room = new Room();
                room.setNum(resultSet.getInt(1));
                room.setFloor(resultSet.getInt(2));
                room.setPrice(resultSet.getInt(3));
                room.setCategory(resultSet.getString(4));
                room.setOccupancy(resultSet.getInt(5));
            }
            return room;

        } catch (Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    public static void addOrder(Order order) {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            String sql = "INSERT INTO ORDERS" +
                    "(DATE_FROM,DATE_TO,ROOM,FIRST_NAME,LAST_NAME,ID) VALUES(?,?,?,?,?,ORDER_ID.NEXTVAL)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, order.getDateFrom());
            statement.setDate(2, order.getDateTo());
            statement.setInt(3, order.getRoom());
            statement.setString(4, order.getFirstName());
            statement.setString(5, order.getLastName());
            System.out.println(statement.toString());
            statement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }
    }
}
