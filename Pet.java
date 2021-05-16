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

    public void display() throws IOException{
        System.out.println(AnsiColours.RED);
        System.out.println("--PET DETAILS--");

        System.out.println(AnsiColours.YELLOW + "Name: " + AnsiColours.BLUE + this.name);
        System.out.println(AnsiColours.YELLOW + "Age: " + AnsiColours.BLUE + this.age);
        System.out.println(AnsiColours.YELLOW + "Fees: " + AnsiColours.BLUE + this.fees);
        System.out.println(AnsiColours.YELLOW + "Breed: " + AnsiColours.BLUE + this.breed);

        System.out.println(AnsiColours.RED + "Press Y to display picture, N to cancel");
        String inp = Util.handleInput().toLowerCase();
        if (Util.equal(inp, "yes", "YES", "y", "Y")) {
            String petImage = this.breed.toLowerCase() + ".jpeg";
            Picture pet = new Picture(petImage);
            pet.show();
        } else if (Util.equal(inp, "n", "N", "NO")) {
            return;
        }
        else {
            Welcome.browse();
        }
    }  
}
