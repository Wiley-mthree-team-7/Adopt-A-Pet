/**
 * @author AnannaBhattacharya
 * Date: 15 May, 2021
 */

import java.util.*;
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
    public boolean validateUser(User user){
        try {
            BufferedReader br = new BufferedReader(new FileReader("UsernamePassword.txt"));
            String line;
            int flag = 0;
            //check if the combination of username & password already exists.
            while((line = br.readLine())!=null){
                String[] loginDetails = line.split(" ");
                if(loginDetails[0].equals(user.getUsername()) && loginDetails[1].equals(user.getPassword())){
                    flag = 1;
                    return true;
                }
            }
            br.close();
            //if the combination is of a new user, append login details to file for future reference.
            if(flag == 0){
                BufferedWriter bw = new BufferedWriter(new FileWriter("UsernamePassword.txt"));
                bw.write(user.getUsername());
                bw.write(" ");
                bw.write(user.getPassword());
                bw.close();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        return false;
    }

}