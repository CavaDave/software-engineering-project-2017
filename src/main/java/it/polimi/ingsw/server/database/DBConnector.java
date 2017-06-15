package it.polimi.ingsw.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {
    private final static Logger LOGGER = Logger.getLogger(DBConnector.class.getName());
    private final static String URL = "jdbc:sqlite:./resources/server/lollolm02.db";
    private final static String USERNAME = "root";

    private static Connection connection;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL, USERNAME, "");
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "An exception while connecting to the database was thrown", e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Cannot close the connection", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}