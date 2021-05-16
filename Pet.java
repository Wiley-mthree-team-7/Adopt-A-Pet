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
        System.out.println(AnsiColours.RED);
        System.out.println("--PET DETAILS--");

        System.out.println(AnsiColours.YELLOW + "Name: " + AnsiColours.BLUE + this.name);
        System.out.println(AnsiColours.YELLOW + "Age: " + AnsiColours.BLUE + this.age);
        System.out.println(AnsiColours.YELLOW + "Fees: " + AnsiColours.BLUE + this.fees);
        System.out.println(AnsiColours.YELLOW + "Breed: " + AnsiColours.BLUE + this.breed);


        String inp = "";
        do {
            System.out.println(AnsiColours.RED + "Press Y to display picture, N to cancel");
            inp = Util.handleInput().toLowerCase();
            if (Util.equal(inp, "yes", "YES", "y", "Y")) {
                String petImage = this.breed.toLowerCase() + ".jpeg";
                Picture pet = new Picture(petImage);
                pet.show();
                break;
            } else if (Util.equal(inp, "n", "N", "NO")) {
                break;
            } else {
                System.out.println(AnsiColours.RED + "Wrong choice, try again");
            }
        } while (true);
            
        do {
            System.out.println(AnsiColours.RED + "Press Y to hear its sound, N to cancel");
            inp = Util.handleInput().toLowerCase();
            if (Util.equal(inp, "yes", "YES", "y", "Y")) {
                String petSound = this.breed.toLowerCase() + ".wav";
                Sound pet = new Sound(petSound);
                pet.play();
                break;
            } else if (Util.equal(inp, "n", "N", "NO")) {
                break;
            } else {
                System.out.println(AnsiColours.RED + "Wrong choice, try again");
            }
        } while (true);
    }  
}
