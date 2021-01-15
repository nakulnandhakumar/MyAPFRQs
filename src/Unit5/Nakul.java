package Unit5;

import java.lang.*;
import java.util.ArrayList;


public class Nakul {
}
 /** QUESTION #1 **/

 /** The following class represents an invitation to an event. The variable hostName represents the name of the host of the event and the variable address represents the location of the event. **/

 class Invitation {
     private String hostName;
     private String address;

     public Invitation(String n, String a) {
         hostName = n;
         address = a;
     }

     /** (a) Write a method for the Invitation class that returns the name of the host. Write the method below. **/
     public String getHostName() {  // Simple get method that returns the hostName. IntelliJ does this automatically for you.
         return hostName;
     }

     /** (b) Write a method for the Invitation class that accepts a parameter and uses it to update the address for the event.
            Write the method below. **/
     public void updateAddress(String newAddress){ // Updating the instance variable address by passing a newAddress into the method
         address = newAddress;
     }

     /** (c)   Write a method for the Invitation class that will accept the name of a person who will be invited as a string parameter and return a string consisting of the name of the person being invited along with name of the host and location of the event.
      For example, if the host name is "Karen", the party location is "1234 Walnut Street", and the person invited is "Cheryl", the method should return a string in the following format.
      Dear Cheryl, please attend my event at 1234 Walnut Street. See you then, Karen.
      Write the method below. Your implementation must conform to the example above. **/
     public void sendInvitation(String invitedGuestName){  // Print statement which substitutes out the guest, host, and address with their respective variables
         System.out.println("Dear "+invitedGuestName+", please attend my event at "+address+". See you then, "+hostName);
     }

     /** (d)   A student has written the following one-parameter constructor to be included in the Invitation class.
      The method is intended to construct a new Invitation object that sets address to the value of the parameter and sets hostName to the default name "Host".
      The constructor does not work as intended.

      public Invitation(String address) {
        address = address;
        hostName = "Host";
      }

      Write a correct implementation of the one-parameter Invitation constructor that avoids the error in the student’s implementation.
      Write the method below. **/

     public Invitation(String address) { // The student didn't differentiate between instance and local variable and the constructor thought they were both local variables. You need the this.address.
         this.address = address;
         hostName = "Host";
     }

     public static void main(String[] args) {  // Simple implementation and object creation to test if code works.
         Invitation invitation = new Invitation("Nakul", "12143 Deer Ridge Avenue");
         System.out.println(invitation.getHostName());
         invitation.updateAddress("52956 Cherry Blossom Court");
         invitation.sendInvitation("Andrew");

         Invitation invitation2 = new Invitation("29573 Heaven Road");
         System.out.println(invitation2.getHostName());
         System.out.println(invitation2.address);
     }

 }
 /** This question involves the implementation of the PasswordGenerator class, which generates strings containing initial passwords for online accounts.
    The PasswordGenerator class supports the following functions.

  Creating a password consisting of a specified prefix, a period, and a randomly generated numeric portion of specified length
  Creating a password consisting of the default prefix "A", a period, and a randomly generated numeric portion of specified length
  Reporting how many passwords have been generated. **/

 class PasswordGenerator {
     int numberOfDigits;
     String prefixCharacter;
     static int numberOfPasswords = 0;
     static ArrayList<String> listOfPasswords = new ArrayList<>();

     public PasswordGenerator(int numberOfDigits, String prefixCharacter){  // Constructor for when you want to specify both number fo digits and prefix character
         this.numberOfDigits = numberOfDigits; // Sets instance variable numberOfDigits to the local parameter numberOfDigits passed in the constructor
         this.prefixCharacter = prefixCharacter; // Sets instance variable prefixCharacter to the local parameter prefixCharacter passed in the constructor
     }

     public PasswordGenerator(int numberOfDigits){  // Constructor for when you want to only specify only number of digits and defaults prefix to "A"
         this.numberOfDigits = numberOfDigits;
         this.prefixCharacter = "A";
     }

     public void updateNumberOfPasswords(){ // Adds to number of passwords created when method is called
         numberOfPasswords++;
     }

     public void getNumberOfPasswords(){  // Prints number of passwords created
         System.out.println(numberOfPasswords);
     }

     public void generatePassword(){  // Main password generator method of class
         int integer;
         String password;
         String integerPass = "";

         for (int i = 0; i < numberOfDigits; i++){ // Creates random integers and concatenates them one by one
             integer = (int) (Math.random()*10);
             integerPass = integerPass.concat(String.valueOf(integer));
         }

         password = prefixCharacter + "." + integerPass; // Creates password through concatenating prefix, period, and string of random integers
         savePassword(password); // Saves password to arraylist
         updateNumberOfPasswords(); // Adds one to number of passwords created
     }

     public void savePassword(String password){
         listOfPasswords.add(password); // Adds the password that is passed in through parameter to static arraylist
     }

     public String getPassword(int index){
         return listOfPasswords.get(index);  // Gets the password at the index in the Arraylist
     }

     public static void main(String[] args){ // Implementation for testing if password generator and its methods work correctly
         PasswordGenerator passGen1 = new PasswordGenerator(4, "ps"); // Initializes both random numbers and prefixCharacter
         passGen1.generatePassword(); // Generate password for passGen1 object
         passGen1.generatePassword(); // Generate password for passGen1 object
         passGen1.getNumberOfPasswords();  // Should print 2 (which it does) as output

         PasswordGenerator passGen2 = new PasswordGenerator(3); // Initializes just random numbers and default initializes prefix to "A"
         passGen2.generatePassword(); // Generate password for passGen2 object
         passGen2.getNumberOfPasswords(); // Should return 3 even though only one password associated with passGen2 because of static variable

         System.out.println(passGen1.getPassword(2));
         System.out.println(passGen2.getPassword(2));
         // Both print statements should print the same thing because of the static arraylist variable
     }


 }


