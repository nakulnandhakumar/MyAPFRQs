package Unit7.Nakul;

import java.util.ArrayList;

public class Nakul {
}


/** QUESTION #1 **/
/** This question involves the creation of user names for an online system.
 * A user name is created based on a user’s first and last names.
 * A new user name cannot be a duplicate of a user name already assigned.
 * You will write the constructor and one method of the UserName class.
 * A partial declaration of the UserName class is shown below. **/

class UserName {

    // The list of possible user names, based on a user’s first and last names and initialized by the constructor.
    private ArrayList<String> possibleNames = new ArrayList<String>();

    /** Constructs a UserName object as described in part (a).
     * Precondition: firstName and lastName have length greater than 0
     * and contain only uppercase and lowercase letters.
     */
    public UserName(String firstName, String lastName) {  // Constructor for setting possible usernames
        String temp; // Temp variable to contain substrings for concatenation later
        int lengthOfFirstName = firstName.length();  // first name length to be used in for loop traversing through first name

        for (int i = 0; i < lengthOfFirstName; i++){
            temp = firstName.substring(0, i+1); // Assigns increasing length of first name string and concatenates it to end of lastname
            possibleNames.add(lastName+temp); // Stores possible usernames in arraylist created
        }

    }



    /** Returns true if arr contains name, and false otherwise. */
    public boolean isUsed(String name, String[] arr) { // Implementation of isUsed which was not given by CollegeBoard
        for (int i = 0; i < arr.length; i++){ // Simple for loop traversing through array with possible names and returning true if matching
            if (name.equals(arr[i])){
                return true;
            }
        }
        return false;
    }


    /** Removes strings from possibleNames that are found in usedNames as described in part (b).
     */
    public void setAvailableUserNames(String[] usedNames) {  // Sets the available usernames by removing used names from possible user name array list
        ArrayList<String> temp = new ArrayList<String>(); // temp arraylist for storing unused names

        for (int i = 0; i < possibleNames.size(); i++){ // Traverses through possible names array list
            if (isUsed(possibleNames.get(i), usedNames)){
                continue; // If any of the names inside are used then the loop restarts and checks the next index
            }
            else {
                temp.add(possibleNames.get(i));  // If name is not used, it is added to temp arraylist
            }
        }

        possibleNames = temp;  // At the very end of the method, the contents of the temp arraylist which are the unused names are copied to the original possible names arraylist
    }

    public static void main(String[] args) { // Implementation in Main shows that this works
        String[] usedNames = {"smithj", "smithja", "smithjo"};
        UserName userName = new UserName("john", "smith");
        userName.setAvailableUserNames(usedNames);
        System.out.println(userName.possibleNames);
    }

}