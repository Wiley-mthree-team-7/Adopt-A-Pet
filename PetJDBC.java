import java.io.*;
import java.util.*;
import java.sql.*;

class PetJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/AdoptAPet";
    private static final String user = "root";
    private static final String password = "password";

    public static void printTable() {
        Welcome.drawLine();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            String query = "SELECT * FROM Pet";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.printf(AnsiColours.WHITE + "%3s", rs.getString(1));
                System.out.printf(AnsiColours.BLUE + "%15s", rs.getString(2));
                System.out.printf((rs.getString(3).equals("Cat") ? AnsiColours.YELLOW : AnsiColours.RED) + "%5s", rs.getString(3));
                System.out.printf(AnsiColours.BLUE+ "%20s", rs.getString(4));
                System.out.printf((rs.getString(5).equals("M") ? AnsiColours.YELLOW : AnsiColours.RED) + "%3s", rs.getString(5));
                System.out.printf(AnsiColours.PURPLE + "%10s", rs.getString(6));                
                System.out.println();
            }
            System.out.print(AnsiColours.RESET);
            Welcome.drawLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }   
}
