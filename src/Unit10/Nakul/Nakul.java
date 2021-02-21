package Unit10.Nakul;

public class Nakul {
}

/** QUESTION 1 **/
/** This question involves computing the greatest common factor between two positive integers
 * and using greatest common factors to reduce fractions.
 * You will write two methods in the NumberSystem class that follows. **/

class NumberSystem {
    int greatestCommonFactor;  // Class variable for implementation purposes in the main method
    /** Precondition: a and b are positive integers.
     * Returns the greatest common factor of a and b, as described in part (a).
     */

    /** PART A **/
    /** The greatest common factor can be computed using the following rules.
     * Case I: If a is evenly divisible by b, then the GCF is b.
     * Case II: If a is not evenly divisible by b, then the GCF of a and b is equal to the GCF of b and the remainder when a is divided by b.
     * If the rule in case II is repeatedly applied, it is guaranteed to eventually result in case I.
     * The gcf method returns the greatest common factor of parameters a and b, as determined by case I and case II.
     * Write the gcf method below. You are encouraged to implement this method recursively. **/

    public static int gcf(int a, int b) {
        if (a%b == 0) {    // "If statement" that checks if the remainder when dividing a by b is 0, if true, return b
            return b;
        }
        return gcf(b, a%b);  // If "if statement" above returns false, passes "b" as "a" in next recursive function call and passes "a"%"b" as "b"
    }


    /** Precondition: numerator and denominator are positive integers.
     * Reduces the fraction numerator / denominator
     * and prints the result, as described in part (b).
     */

    /** PART B **/
    /** If the numerator is evenly divisible by the denominator, then the fraction reduces to the result when the numerator is divided by the denominator.
     If the numerator is not evenly divisible by the denominator, then the
     reduced numerator will be equal to the numerator divided by the GCF of the numerator and the denominator.
     Similarly, the reduced denominator will be equal to the denominator divided by the GCF of the numerator and the denominator. **/

    public static void reduceFraction(int numerator, int denominator) {
        int GCF;  // temp variable to store GCF for later divisions
        if (numerator%denominator == 0) {
            System.out.println(numerator/denominator);  // If the remainder when dividing is zero, directly prints the result of the division
        }
        else {
            GCF = gcf(numerator, denominator); // If remainder when dividing is not zero, calls gcf method to find GCF
            System.out.println((numerator/GCF) + "/" +(denominator/GCF));  // Divides both the numerator and denominator by GCF and prints them in fraction form
        }
    }

    public static void main(String[] args) {
        NumberSystem numberSystem = new NumberSystem();

        /** IMPLEMENTATION FOR PART A **/
        numberSystem.greatestCommonFactor = gcf(24, 9);  // Finds the GCF of 24 and 9
        System.out.println(numberSystem.greatestCommonFactor);  // Prints out "3" which is the correct answer. Works for other numbers as well

        /** IMPLEMENTATION FOR PART B **/
        reduceFraction(24, 9); // Finds the reduced fraction of 24/9 and correctly prints 8/3
    }

}