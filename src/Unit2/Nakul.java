package Unit2;

import java.lang.*;

public class Nakul {
}


class LightSequenceN {
    private String seq;

    /** The parameter seq is the initial sequence used for the light display **/
    private LightSequenceN(String seq) {
        this.seq = seq;
    }

    /** Inserts the string segment in the current sequence, starting at the index ind. Returns the new sequence. **/
    private String insertSegmentN(String segment, int ind) {
        // temporary
        return segment;
    }

    /** Updates the sequence to the value in seq **/
    private void changeSequenceN(String seq) {
        this.seq = seq;
    }

    /** Uses the current sequence to turn the light on and off for the show **/
    private void displayN() {
        /* implementation not shown */
    }

    /** (e) Assume that the string oldSeq has been properly declared and initialized and contains the string segment.
     Write a code segment that will remove the first occurrence of segment from oldSeq and store it in the string newSeq.
     Consider the following examples.

     If oldSeq is "1100000111" and segment is "11", then "00000111" should be stored in newSeq.
     If oldSeq is "0000011" and segment is "11", then "00000" should be stored in newSeq.
     If oldSeq is "1100000111" and segment is "00", then "11000111" should be stored in newSeq.
     Write the code segment below. Your code segment should meet all specifications and conform to the examples. **/
    private String removeSegmentN(String oldSeq, String segment){
        int segmentExists = oldSeq.indexOf(segment);
        String newSeq = new String();
        if (segmentExists != -1){
            try {
                newSeq = oldSeq.replaceFirst(segment, "");
            }
            catch ( NullPointerException e) {
                System.out.println("NullPointerException Caught");
            }
        }
        else {
            System.out.println("Given segment does not exist in oldSeq. Assigning oldSeq to newSeq...");
        }
        return newSeq;
    }

    /** (f) Two lights will be arranged on a two-dimensional plane.
     The vertical distance between the two lights is stored in the double variable a.
     The horizontal distance between the two lights is stored in the double variable b.
     The straight-line distance between the two lights is given by the formula
     square root of the quantity a squared plus b squared.
     Write a code segment that prints the straight-line distance between the two lights according to the formula above **/
    private double distanceBetweenLights(double a, double b){
        double distance = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
        return distance;
    }

    /** Driver Code to test if answers are right **/
    public static void main (String[] args){
        String oldSeq = "1100000111";
        String newSeq;
        double straightLineDistance;

        /** (a) Write a statement to create a Unit2.LightSequenceN object gradShow that has the initial light sequence "0101 0101 0101".
         Write the statement below. **/
        LightSequenceN gradshow = new LightSequenceN("0101 0101 0101");
        System.out.println(gradshow.seq);

        /** (b) Write a statement that will call the display method to display the light sequence for the gradShow object.
         Write the statement below. **/
        gradshow.displayN();

        /** (c) Write a statement that will be used to update the gradShow light sequence to "0011 0011 0011".
         Write the statement below. **/
        gradshow.changeSequenceN("0011 0011 0011");
        System.out.println(gradshow.seq);

        /** (d) Write a code segment that will call the insertSegment method to insert the segment "1111 1111" in the current sequence for gradShow at index 4.
         The resulting sequence will be stored in the string resultSeq.
         Write the code segment below. **/
        String resultSeq = gradshow.insertSegmentN("1111 1111", 4);
        System.out.println(resultSeq); // This will just print the segment parameter in the method
                                       // insertSegmentN because the method just returns the entered parameter
                                       // since I can't change the method because that is what is given

        /** (e) See removeSegmentN method for answer to part e. **/
        newSeq = gradshow.removeSegmentN(oldSeq,"11");
        System.out.println(newSeq);

        /** (f) See distanceBetweenLights method for answer to part f. **/
        straightLineDistance = gradshow.distanceBetweenLights(4, 3);
        System.out.println(straightLineDistance);
    }
}


















