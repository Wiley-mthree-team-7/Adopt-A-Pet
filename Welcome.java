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
    public static void browse() throws Exception{
        Util.clearScreen();
        drawHeading();

        System.out.print(AnsiColours.CYAN);
        System.out.println("Which pet would you like to browse first?");
        System.out.println("1. Dogs");
        System.out.println("2. Cats");
        System.out.println("3. Login");
        System.out.println("4. Register");        
        System.out.println("x. Exit");
        System.out.println("Enter choice: ");
        
        String choice = Util.handleInput().toLowerCase();
        if (Util.equal(choice, "dogs", "1", "1.", "d")) {
            System.out.println("Great choice! Here is the list of available dogs:");
            printPets("dogs.txt");
            browse();
        } else if (Util.equal(choice, "cats", "2", "2.", "c")) {
            System.out.println("Cat masterrace! Here is the list of available cats:");
            printPets("cats.txt");
            browse();
        } else if(Util.equal(choice, "login", "3", "3.", "l")) {
            String u = Login.login();
            if (u != null) System.out.println(AnsiColours.GREEN + "Welcome back, " + u + "!");
            else System.out.println(AnsiColours.RED + "Unable to login :(");
            Thread.sleep(4000);
            browse();
        } else if(Util.equal(choice, "register", "4", "4.", "r")) {
            User u = Register.newUser();
            if (u != null) 
                System.out.println(AnsiColours.GREEN+ "User " + u.getName() + " successfully registered!");
            else System.out.println("Couldn't register user");
            Thread.sleep(4000);
            browse();
        } else if (Util.equal(choice, "exit", "x", "x.", "quit", "close")) {
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

    public static void printPets(String petInfo) throws Exception{
        ArrayList<Pet> pets = new ArrayList<Pet>();
        FileInputStream in = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("./pet_info/" + petInfo)));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                pets.add(new Pet(words[0], Integer.parseInt(words[1]),
                                 Integer.parseInt(words[2]), words[3]));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unable to open file " + petInfo);
        }

        for(Pet p : pets) {
            p.display();
        }
    }

    private static void drawLine() {
        System.out.print(AnsiColours.RED);
        for(int i = 0; i < 160; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.print(AnsiColours.WHITE);
    }
    public static void main(String[] args) throws Exception{
        Util.clearScreen();
        drawHeading();
        browse();
    }    
}
