/**
 * @author AnannaBhattacharya
 * Date: 15 May, 2021
 */

import java.util.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
//Login class for validating user input and assisting in password recovery.
public class Login {
    //To validate whether a user is already present in the database or not. If yes, go ahead with login, otherwise writes 
    //a new record for the user.
    public static boolean validateUser(User user) throws SQLException{
        try {
            //BufferedReader br = new BufferedReader(new FileReader("UsernamePassword.txt"));
            //String line;
            int user_id;

            ResultSet rs = UserJDBC.getUser(user.getUsername(), user.getPassword());
            if (!rs.next()) {
                System.out.println("here");
                return false;
            } else {
                user_id = rs.getInt(1);
                User.setUserId(user_id);
                return true;
            }
        }
        catch(Exception e)  
        {
        	e.printStackTrace();
            return false;
        }
    }

    public static String login() throws SQLException {
        System.out.println(AnsiColours.BLUE + "Enter username: ");
        String username = Util.handleInput();
        System.out.println(AnsiColours.BLUE + "Enter password: ");
        String password = Util.handleInput();
        User u = new User("", "", 0, 123, 0, username, password);
        if (validateUser(u)) return username;
        return null;
    }

}
