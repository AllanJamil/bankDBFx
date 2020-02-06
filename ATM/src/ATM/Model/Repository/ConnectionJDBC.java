package ATM.Model.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {

    public static Connection getConnection () {
        Properties properties=new Properties();
        Connection myCon = null;
        try {

            properties.loadFromXML(new FileInputStream
                    ("C:\\Users\\Allan\\Documents\\Nackademin\\Databas Teknink\\Inlämningsuppgift 3\\Settings\\config.xml"));

            myCon = DriverManager.getConnection(
                properties.getProperty("connection"),
                properties.getProperty("user"),
                properties.getProperty("password"));

            System.out.println("Connected to Database");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return myCon;
    }

}


