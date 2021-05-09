/**
 * Author: therealpj
 * Compliation: javac Welcome.java
 * Execution: java Welcome
 * Date: 3 May, 2021
 * Displays the welcome screen for Adopt-A-Pet.
 **/

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

class Welcome {

    // clears the terminal
    private  static void clearScreen() {  
        System.out.print(AnsiColours.CLEAR);  
        System.out.flush();  
    }  

    // Displays the heading of our application using BufferedImage
    private static void drawHeading() {
        // Creating a BufferedImage to display heading
        BufferedImage image = new BufferedImage(165, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // Setting font and size
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        Graphics2D graphics2D = (Graphics2D) g;

        // turning on antialias for a nicer look
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        drawLine();
        
        graphics2D.drawString("ADOPT -A- PET !", 10, 24);

        // Printing the image
        for(int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for(int x = 0; x < 165; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : "#");
            
            System.out.print(AnsiColours.GREEN);            
            if (sb.toString().trim().isEmpty()) continue;
            System.out.println(sb);
        }
        System.out.print(AnsiColours.WHITE);
        drawLine();
    }

    
    // Display the pets
    public static void browse() throws IOException{
        clearScreen();
        drawHeading();

        System.out.println("Which pet would you like to browse first?");
        System.out.println("1. Dogs");
        System.out.println("2. Cats");
        System.out.println("3. Login");
        System.out.println("4. Register");        
        System.out.println("x. Exit");
        System.out.println("Enter choice: ");
        
        String choice = takeInput().toLowerCase();
        if (equal(choice, "dogs", "1", "1.", "d")) {
            
        } else if (equal(choice, "cats", "2", "2.", "c")) {
            
        } else if(equal(choice, "login", "3", "3.", "l")) {
            
        } else if(equal(choice, "register", "4", "4.", "r")) {
            
        } else if (equal(choice, "exit", "x", "x.", "quit", "close")) {
            exit();
        } 
        else {
            System.out.println("Um.... I don't understand that choice. Please try again.");
            try {
                Thread.sleep(2000);
            } catch(Exception e) {
            }
            browse();
        }

    }
    
    // Close the program
    public static void exit() {
        System.out.println("Thank you for browsing our pet gallery. Hope to see you soon!");
        System.exit(0);
    }

    // checks if the first passed string matches with the other passed strings
    private static boolean equal(String first, String ...strings) {
        // using a foreach loop to check the variable number of passed strings 
        for(String s : strings) {
            if (first.equals(s)) return true;
        }
        return false;
    }
    

    // take input from user, returns the string
    private static String takeInput() throws IOException{
        System.out.print(AnsiColours.RED);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine();
        inp.trim();
        System.out.print(AnsiColours.WHITE);        
        return inp;

    }

    private static void drawLine() {
        System.out.print(AnsiColours.RED);
        for(int i = 0; i < 160; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print(AnsiColours.WHITE);
    }
    public static void main(String[] args) throws IOException{
        clearScreen();
        drawHeading();
        browse();
    }    
}
