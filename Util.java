/**
 * Author: therealpj
 * Compliation: javac Util.java
 * Date: 9 May, 2021
 * Helper file containing utility functions
 **/

import java.io.*;
import java.util.*;

class Util {
    
    // clears the terminal
    public static void clearScreen() {  
        System.out.print(AnsiColours.CLEAR);  
        System.out.flush();  
    }  

    // checks if the first passed string matches with the other passed strings
    public static boolean equal(String first, String ...strings) {
        // using a foreach loop to check the variable number of passed strings 
        for(String s : strings) {
            if (first.equals(s)) return true;
        }
        return false;
    }
    
    // take input from user, returns the string
    public static String handleInput() {
        System.out.print(AnsiColours.RED);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = "";
        try {
            inp = br.readLine();
            inp.trim();            
        } catch(Exception e) {
            System.out.println("Invalid input. (Exception: " + e + ")");
        }
        System.out.print(AnsiColours.WHITE);        
        return inp;
    }

}
