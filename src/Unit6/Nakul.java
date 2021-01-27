package Unit6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Nakul {
}


/** QUESTION #1 **/

/**
 * An array of String objects, words, has been properly declared and initialized.
 * Each element of words contains a String consisting of lowercase letters (a–z).
 * Write a code segment that uses an enhanced for loop to print all elements of words that end with "ing".
 * As an example, if words contains {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"}, then the following output should be produced by the code segment:

 fading
 trailing
 batting

 * Write the code segment as described above. The code segment must use an enhanced for loop to earn full credit. **/

class Ing {
    String[] words;  // Initialize array to store words for ending test
    int lengthOfWord; // variable for length of word

    public Ing(String[] arr){
        words = arr;
    } // Constructor to assign strings (words) from inputted array to words array

    public void printWordsEndingInIng(){
        for (String word: words){  // For each loop iterates through all words in the array words until none are left
            lengthOfWord = word.length(); // Stores length of word

            if (lengthOfWord < 3){  // Because any words less than three characters will not be printed in any condition, go to the next word
                continue;
            }
            if (word.substring(lengthOfWord - 3).equals("ing")){ // Substring that takes the last three letters of the word and checks
                System.out.println(word); // Prints if above condition is met
            }
        }
    }

    public static void main(String[] args){  // Implementation
        String[] arrOfStrings = {"a", "run", "strike", "man", "coming", "dude", "mistering", "through", "sipping", "listening"};
        Ing ing = new Ing(arrOfStrings);
        ing.printWordsEndingInIng();
    }
}

/** QUESTION #2 **/

/** Employees at a store are paid daily wages according to the following rules:
 * Each employee is paid the same fixed amount per day.
 * Each employee is paid an additional amount for each item they sold on that day.

 * Daily Bonus:
 If the number of items sold that day by an employee is greater than a computed threshold,
    then the employee also receives a bonus equal to 10 percent of the employee’s daily wages.

 You will write two methods in the Payroll class below. **/

class Payroll {
    private int[] itemsSold = {19, 32, 15, 54, 23, 49, 39, 26}; // number of items sold by each employee. Instantiated by Nakul Nandhakumar for testing and implementation purposes
    private double[] wages = new double[itemsSold.length]; // wages to be computed in part (b)
    double bonusThreshold;

    /** (a) The bonus threshold is calculated based on the number of items sold by all employees on a given day.
     * The employee with the greatest number of sales and the employee with the least number of sales on that day are ignored in the calculation.
     * The average number of items sold by the remaining employees on that day is computed, and this value is used as the bonus threshold.
     * Complete the method computeBonusThreshold below, which is intended to return the bonus threshold based on the contents of the itemsSold array.
     * Assume that itemsSold has been filled appropriately, and that the array contains at least three employees.**/

    public double computeBonusThreshold() {
        int[] copyOfItemsSold = itemsSold; //Uses a copy because the original array with preserved order is needed for question #2
        double bonusThreshold = 0;
        int temp;
        int salesExcludingMinMax = 0;

        // Bubble sort method performed on itemsSold to distinguish least and most sales
        for (int i = 0; i < copyOfItemsSold.length - 1; i++){

            for (int j = 0; j < copyOfItemsSold.length - 1; j++){

                if (copyOfItemsSold[j] > copyOfItemsSold[j+1]){  // The swapping of the bubble sort using temp variables
                    temp = copyOfItemsSold[j];
                    copyOfItemsSold[j] = copyOfItemsSold[j+1];
                    copyOfItemsSold[j+1] = temp;
                }
            }
        }

        // Calculating the total number of sales if you ignore the employee with the most and the employee with the least sales
        for (int i = 0; i < copyOfItemsSold.length - 2; i++){
            salesExcludingMinMax += copyOfItemsSold[i+1];
        }
        bonusThreshold = (double) (salesExcludingMinMax) / (copyOfItemsSold.length-2); // Calculating bonus threshold
        System.out.println("Bonus Threshold: "+bonusThreshold); //Should print out 31.333 with the given itemsSold array. This is for testing.
        return bonusThreshold;
    }

    /** (b) The computeWages method is intended to calculate the wages for each employee and to assign them to the appropriate element of the array wages.
     For example, wages[3] should be assigned the wages for employee 3.

     * An employee’s wages consist of their daily wages plus a possible bonus and are calculated as follows.
     Each employee’s wages are equal to the fixed wage plus the number of items sold times the amount paid per item sold.
     If the employee sold more items than the bonus threshold, the employee also receives a  10  percent bonus added to their wages.

     * Write the method computeWages.
     * Assume that itemsSold has been filled appropriately, and there are at least three employees in the array.
     * Assume also that the wages array and the itemsSold array have the same length.
     * Your solution must call computeBonusThreshold appropriately to receive full credit.**/

    public void computeWages(double fixedWage, double perItemWage) {
        int i = 0;
        bonusThreshold = computeBonusThreshold();

        for (int items: itemsSold) {
            wages[i] = fixedWage + items*perItemWage;

            if (items > bonusThreshold){
                wages[i] = Math.floor((wages[i]*1.1)*100)/100; // Serves to truncate decimals to 2 decimals
            }
            i++;
        }
    }

    public static void main(String[] args){ // Implementation for this question. Everything runs perfectly
        Payroll payroll = new Payroll();
        payroll.computeWages(10.0, 1.5);
        System.out.println(Arrays.toString(payroll.itemsSold));
        System.out.println(Arrays.toString(payroll.wages));
    }
}