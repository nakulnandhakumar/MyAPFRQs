package Unit3.Andrew;

import java.util.Random;

public class Andrew {
}

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

class Party
{
    Party()
    {
        Random random = new Random();
        int selection= random.nextInt(3)+1;
        String option1;
        Boolean rsvp=true; // just because
        String option2;
    }
    //part a
    private void attending(boolean rv)
    {
        if (rv)
        {
            System.out.println("Attending");
        }
        else
            System.out.println("Not attending");
    }
    private void selctionFood(int Food)
    {
        switch (Food)
        {
            case 1: System.out.println("beef"); break;
            case 2: System.out.println("chicken"); break;
            case 3: System.out.println("pasta");break;
            default: System.out.println("fish");
        }
    }
    private String Rvsp(boolean rv, int option)
    {
        if (rv)
        {
            switch (option)
            {
                case 1: return "Thanks for attending. You will be served beef.";
                case 2: return "Thanks for attending. You will be served chicken.";
                case 3: return "Thanks for attending. You will be served pasta.";
                default: return "Thanks for attending. you will be served with fish.";
            }
        }
        else
        {
            return "Sorry that you cant make it";
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
    public void drawSquare(int x, int y, int len) {
        drawLine(x, y, x, y-len);
        drawLine(x, y-len, x+len, y-len);
        drawLine(x+len, y-len, x+len, y);
        drawLine(x+len, y, x, y);
    }

}