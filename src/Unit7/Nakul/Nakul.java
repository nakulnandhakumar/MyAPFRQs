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
    public UserName(String firstName, String lastName) {
        String temp;
        int lengthOfFirstName = firstName.length();

        for (int i = 0; i < lengthOfFirstName; i++){
            temp = firstName.substring(0, i+1);
            possibleNames.add(lastName+temp);
        }

    }



    /** Returns true if arr contains name, and false otherwise. */
    public boolean isUsed(String name, String[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (name.equals(arr[i])){
                return true;
            }
        }
        return false;
    }


    /** Removes strings from possibleNames that are found in usedNames as described in part (b).
     */
    public void setAvailableUserNames(String[] usedNames) {
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < possibleNames.size(); i++){
            if (isUsed(possibleNames.get(i), usedNames)){
                continue;
            }
            else {
                temp.add(possibleNames.get(i));
            }
        }

        possibleNames = temp;
    }

    public static void main(String[] args) {
        String[] usedNames = {"smithj", "smithja", "smithjo"};
        UserName userName = new UserName("john", "smith");
        userName.setAvailableUserNames(usedNames);
        System.out.println(userName.possibleNames);
    }

}