import Database.DBConnection;
import Hotel.Room;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnectionTest {
    @Test
    public void constantsTest() throws NoSuchFieldException, IllegalAccessException {
        DBConnection connection = new DBConnection();
        Field field = DBConnection.class.
                getDeclaredField("JDBC_DRIVER_NAME");
        field.setAccessible(true);
        String JDBC_DRIVER_NAME = (String) field.get(connection);
        Assert.assertEquals("oracle.jdbc.driver.OracleDriver", JDBC_DRIVER_NAME);

        field = DBConnection.class.
                getDeclaredField("DATABASE_URL");
        field.setAccessible(true);
        String DATABASE_URL = (String) field.get(connection);
        Assert.assertEquals("jdbc:oracle:thin:@localhost:1521:xe", DATABASE_URL);

        field = DBConnection.class.
                getDeclaredField("USER");
        field.setAccessible(true);
        String USER = (String) field.get(connection);
        Assert.assertEquals("dzundza", USER);

        field = DBConnection.class.
                getDeclaredField("PASSWORD");
        field.setAccessible(true);
        String PASSWORD = (String) field.get(connection);
        Assert.assertEquals("321", PASSWORD);
    }

    @Test
    public void driverLoadTest() throws ClassNotFoundException {
        final String JDBC_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
        Class<?> c = Class.forName(JDBC_DRIVER_NAME);
        boolean driverIsLoaded = (c == null) ? false : true;
        Assert.assertTrue(driverIsLoaded);
    }

    @Test
    public void connectionTest() throws ClassNotFoundException, SQLException {
        final String JDBC_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
        final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        final String USER = "stas";
        final String PASSWORD = "321";

        Class.forName(JDBC_DRIVER_NAME);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        boolean connected = (connection == null) ? false : true;
        Assert.assertTrue(connected);
    }

    @Test
    public void roomsExistingTest() {
        ArrayList<Room> rooms = DBConnection.getRoomList();
        boolean roomsExist = (rooms == null) ? false : true;
        Assert.assertTrue(roomsExist);
    }
}
