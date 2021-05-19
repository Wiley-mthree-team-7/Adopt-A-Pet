/**
 * Author: therealpj
 * Compliation: javac Pet.java
 * Date: 9 May, 2021
 * A superclass for any type of pet.
 **/

import java.io.*;
import java.util.*;

class Pet {
    protected String name, breed;
    protected int age, fees;
    
    public Pet(String name, int age, int fees, String breed) {
        this.name = name;
        this.age = age;
        this.fees = fees;
        this.breed = breed;
    }

    public void display() throws Exception{
      

        String inp = "";
        do {
            Util.clearScreen();
            System.out.println(AnsiColours.RED);
            System.out.println("--PET DETAILS--");
            
            System.out.println(AnsiColours.YELLOW + "Name: " + AnsiColours.BLUE + this.name);
            System.out.println(AnsiColours.YELLOW + "Age: " + AnsiColours.BLUE + this.age);
            System.out.println(AnsiColours.YELLOW + "Fees: " + AnsiColours.BLUE + this.fees);
            System.out.println(AnsiColours.YELLOW + "Breed: " + AnsiColours.BLUE + this.breed);
            
            System.out.println(AnsiColours.CYAN);
            System.out.println("Press 1. to see its picture");
            System.out.println("Press 2. to hear its sound");
            System.out.println("Press 3. to return to the menu");
            System.out.println("Press 4. to see the next pet");
            System.out.println("Press 5. to quit");
            inp = Util.handleInput().toLowerCase();
            if (Util.equal(inp, "Picture", "picture", "pic", "p", "1.", "1")) {
                String petImage = this.breed.toLowerCase() + ".jpeg";
                Picture pet = new Picture("pet_pics/" + petImage);
                pet.show();
            } else if (Util.equal(inp, "Sound", "sound", "s", "bark", "meow", "2", "2.")) {
                String petSound = this.breed.toLowerCase() + ".wav";
                Sound pet = new Sound(petSound);
                pet.play();
            } else if (Util.equal(inp,"menu", "m", "3.", "3") ){
                Welcome.browse();
            }
            else if (Util.equal(inp, "next", "n", "c", "4", "4.")){
                return;                    
            } else if (Util.equal(inp, "quit", "exit", "q", "5", "5." )) {
                Welcome.exit();
            }
            else {
                System.out.println(AnsiColours.RED + "Wrong choice, try again");
            }
        } while (true);
    }  
}
