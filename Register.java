import java.util.*;
import java.io.*;
public class Register {
	
	// encrypting password before we store it in the database
	public static String encrypt(String text, int shiftKey)
    {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        String Digit = "0123456789";
        String Special = "@#$%^&*";
			
        String cipherText = "";
        text = text.toLowerCase();
	        
        for (int i = 0; i < text.length(); i++)
	        {
				int charPosition,keyVal;
				char replaceVal;
				//if character is a digit
				if(Character.isDigit(text.charAt(i)))
                    { 
                        charPosition = Digit.indexOf(text.charAt(i));
                        keyVal = (shiftKey + charPosition) %10;
                        replaceVal = Digit.charAt(keyVal);
                    }
				//if character is a alphabet
				else if(Character.isLetter(text.charAt(i)))
                    {
                        charPosition = ALPHABET.indexOf(text.charAt(i));
                        keyVal = (shiftKey + charPosition) % 26;
                        replaceVal = ALPHABET.charAt(keyVal);
                    }
				//if character is special character
				else
                    {
                        charPosition = Special.indexOf(text.charAt(i));
                        keyVal = (shiftKey + charPosition) % 7;
                        replaceVal = Special.charAt(keyVal);
                    }
				
	            cipherText += replaceVal;
	        }
        return cipherText;
    }
  
	//function which reads data from user and store them in database
	public static User newUser()
	{
		try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new FileWriter("UsernamePassword.txt",true));
			 
                System.out.print(AnsiColours.BLUE + "Enter your name: ");
                String name = Util.handleInput();
			
                System.out.print(AnsiColours.BLUE + "Enter your location: ");
                String location = Util.handleInput();
			 
                System.out.print(AnsiColours.BLUE + "Enter your age : ");
                int age = Integer.parseInt(Util.handleInput());
			 
                System.out.print(AnsiColours.BLUE + "Enter your phone number: ");
                long phNo = Long.parseLong(Util.handleInput());
			 
                System.out.print(AnsiColours.BLUE + "Enter your salary: ");
                double salary = Double.parseDouble(Util.handleInput());
			 
                System.out.print(AnsiColours.BLUE + "Enter user name: ");
                String username = Util.handleInput();
			 
                System.out.print(AnsiColours.BLUE + "Enter a password: ");
                String password = encrypt(Util.handleInput(), 3);
			 
                User newUser =  new User(name,location, age, phNo, salary, username, password);
			 
                //storing username and password in the textfile 
                bw.write(newUser.getUsername());
                bw.write(" ");
                bw.write(newUser.getPassword());
                bw.write("\n");
                bw.close();
                return newUser;
            }
		catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }
	}
}
