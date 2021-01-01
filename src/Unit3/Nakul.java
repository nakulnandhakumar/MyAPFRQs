package Unit3;

public class Nakul {
}
    /** Question #1 **/
    /** SHOW ALL YOUR WORK. REMEMBER THAT PROGRAM SEGMENTS ARE TO BE WRITTEN IN JAVA.

        Assume that the classes listed in the Java Quick Reference have been imported where appropriate.
        Unless otherwise noted in the question, assume that parameters in method calls are not null and that methods are called only when their preconditions are satisfied.
        In writing solutions for each question, you may use any of the accessible methods that are listed in classes defined in that question.
        Writing significant amounts of code that can be replaced by a call to one of these methods will not receive full credit.

        Assume that the following variables have been properly declared and initialized.

        a boolean variable named rsvp
        an int variable named selection, where 1 represents "beef", 2 represents "chicken", 3 represents "pasta", and all other values represent "fish"
        a String variable named option1
        a String variable named option2 **/

class Party {

    boolean rsvp; // For convenience, I have decided to initialize this as true so no errors are returned if I use this variable as a parameter
    int selection;
    String option1;
    String option2;

    public Party() { // default constructor of class Party is initialized here so no errors are returned
    }

    /** (a)   Write a code segment that prints "attending" if rsvp is true and prints "not attending" otherwise.
     Write the code segment below. **/
    public void attendance(boolean rsvp) { // Simple if statement that executes functions if true is returned and executes the else if none is true
        if (rsvp) {
            System.out.println("attending");
        }
        else {
            System.out.println("not attending");
        }
    }

    /** (b)   Write a code segment that prints the food item associated with selection.
     For example, if selection is 3, the code segment should print "pasta".
     Write the code segment below. Your code segment should meet all specifications and conform to the example. **/
    public void foodTypes(int selection) {  // simple If statement for recognizing selection
        if (selection == 1) {
            System.out.println("beef");
        }
        else if (selection == 2) {
            System.out.println("chicken");
        }
        else if (selection == 3) {
            System.out.println("pasta");
        }
        else {
            System.out.println("fish");
        }
    }

    /** (c)   Write a code segment that will store a dinner selection in option1 based on the values of rsvp and selection.
     The intended behavior of the code segment is described below.

     If rsvp is true, the code segment should store in option1 a string indicating the person’s attendance and food choice.
     For example, if rsvp is true and selection is 1, the following string should be stored in option1.
     "Thanks for attending. You will be served beef."

     If rsvp is false, the following string should be stored in option1, regardless of the value of selection.
     "Sorry you can't make it."
     Write the code segment below. Your code segment should meet all specifications and conform to the examples. **/

    public void foodSelection() {  // simple nested if statement, just follow the if statements and elses
        if (rsvp) {
            if (selection == 1){
                option1 = "Thanks for attending. You will be served beef.";
            }
            else if (selection == 2){
                option1 = "Thanks for attending. You will be served chicken.";
            }
            else if (selection == 3){
                option1 = "Thanks for attending. You will be served pasta.";
            }
            else {
                System.out.println("Thanks for attending. You will be served fish.");
            }
        }
        else {
            System.out.println("Sorry you can't make it.");
        }
    }

    /** (d)   Write a code segment that will print true if the strings option1 and option2 contain the same values and will print false otherwise.
     Write the code segment below. **/
    public void stringComparison (String option1, String option2) {  // simple string comparison and if else statement
        if (option1.equals(option2)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}


       /** Question #2 **/
       /** SHOW ALL YOUR WORK. REMEMBER THAT PROGRAM SEGMENTS ARE TO BE WRITTEN IN JAVA.
        Assume that the classes listed in the Java Quick Reference have been imported where appropriate.
        Unless otherwise noted in the question, assume that parameters in method calls are not null and that methods are called only when their preconditions are satisfied.
        In writing solutions for each question, you may use any of the accessible methods that are listed in classes defined in that question.
        Writing significant amounts of code that can be replaced by a call to one of these methods will not receive full credit.
        This question involves the Draw class, which is used to draw line segments and squares on a  10 -by- 10   xy -coordinate grid. **/

class Draw
{

    /** Precondition: All parameters are between 0 and 10, inclusive.
     * Draws a line segment in a  10 -by- 10   xy -coordinate grid.
     * The line segment is drawn from (x1, y1) to (x2, y2).
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    { /* implementation not shown */ }


    /** Precondition: 0 ≤ x < 10, 0 < y ≤ 10, and len > 0.
     * Draws a square on a  10 -by- 10   xy -coordinate grid
     * and prints the square’s side length and area.
     * The upper left corner of the square will be located
     * at the coordinate (x, y) and the side length of the
     * square will be len (or as large as will fit in the grid).
     */
    public void drawSquare(int x, int y, int len) {  // Just calling drawLine in logical order with logical parameters to draw lines between different points to make a square
        drawLine(x, y, x, y-len);
        drawLine(x, y-len, x+len, y-len);
        drawLine(x+len, y-len, x+len, y);
        drawLine(x+len, y, x, y);
    }

}