import java.io.*;
import java.util.*;
import java.sql.*;

class UserJDBC {
    static final String url = "jdbc:mysql://localhost:3306/AdoptAPet";
    static final String user = "root";
    static final String password = "password";

    public static ResultSet getUser(String username, String password) {
        ResultSet rs = null;
        try {
            Connection conn = DriverManager.getConnection(UserJDBC.url, UserJDBC.user, UserJDBC.password);
            Statement st = conn.createStatement();
            String query = "SELECT id FROM User where username = '" + username + "' and password = '" + password + "'";
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
