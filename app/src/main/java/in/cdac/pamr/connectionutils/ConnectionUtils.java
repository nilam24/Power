package in.cdac.pamr.connectionutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dell1 on 11/05/2017.
 */

public class ConnectionUtils  {


    public static Connection getConnection() throws SQLException, Exception{



        Class.forName("net.sourceforge.jtds.jdbc.Driver");


        return DriverManager.getConnection("jdbc:jtds:sqlserver://ip_address/db","db","pass");
    }
}
