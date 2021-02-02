package Unit8.Nakul;

import java.util.Arrays;

public class Nakul {
}

/** QUESTION 1 **/
/** The ExperimentalFarm class represents crops grown on an experimental farm.
 * An experimental farm is a rectangular tract of land that is divided into a grid of equal-sized plots.
 * Each plot in the grid contains one type of crop.
 * The crop yield of each plot is measured in bushels per acre.
 * A farm plot is represented by the Plot class.
 * A partial definition of the Plot class is shown below.  **/

class Plot {
    private String cropType;
    private int cropYield;

    public Plot(String crop, int yield) {
        cropType = crop;
        cropYield = yield;
    }

    public String getCropType() {
        return cropType;
    }

    public int getCropYield() {
        return cropYield;
    }
}


/** The grid of equal-sized plots is represented by a two-dimensional array of Plot objects named farmPlots, declared in the ExperimentalFarm class.
 * A partial definition of the ExperimentalFarm class is shown below. **/

class ExperimentalFarm {
    private Plot[][] farmPlots;


    public ExperimentalFarm(Plot[][] p) {
         // Initializing the given values from CollegeBoard
        p[0][0] = new Plot("corn", 20);
        p[0][1] = new Plot("corn", 30);
        p[0][2] = new Plot("peas", 10);
        p[1][0] = new Plot("peas", 30);
        p[1][1] = new Plot("corn", 40);
        p[1][2] = new Plot("corn", 62);
        p[2][0] = new Plot("wheat", 10);
        p[2][1] = new Plot("corn", 50);
        p[2][2] = new Plot("rice", 30);
        p[3][0] = new Plot("corn", 55);
        p[3][1] = new Plot("corn", 30);
        p[3][2] = new Plot("peas", 30);

        farmPlots = p;
    }

    /** Returns the plot with the highest yield for a given crop type, as described in part (a). */
    public Plot getHighestYield(String c) {
        int rowInd = 0; // Initializing variables for temporary comparisons and for return specific index of array
        int colInd = 0;
        int yieldMax = 0;
        int rowCounter = 0;

        for (Plot[] plots : farmPlots) {  // For each loop that assigns the rows of 2D array to temp 1D array for traversing
            int colCounter = 0;

            for (int i = 0; i < plots.length; i++) {  // Traverses through elements in 1D array

                if (plots[i].getCropType().equals(c)){  // Checks to see if same crop type otherwise skips to next element

                    if (plots[i].getCropYield() > yieldMax){  // If same crop type and if greater value, then new index and temp max gets assigned
                        rowInd = rowCounter;
                        colInd = colCounter;
                        yieldMax = plots[i].getCropYield();
                    }

                }
                colCounter++;  // Column counter to keep track of column indexes
            }
            rowCounter++; // Rox counter to keep track of row indexes
        }
        if (yieldMax == 0){  // Returns null if no crop type found when searching
            return null;
        }
        else {
            return farmPlots[rowInd][colInd];  // Returns object with max yield of crop type if present
        }
    }


    /** Returns true if all plots in a given column in the two-dimensional array farmPlots
     * contain the same type of crop, or false otherwise, as described in part (b).
     */
    public boolean sameCrop(int col) {  // Traverses through the rows of a certain column and compares each element with first element
        for (int i = 0; i < farmPlots.length; i++){
            if (!farmPlots[i][col].getCropType().equals(farmPlots[0][col].getCropType())){ // Returns false if crop type not the same
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {  // Implementation of code (Runs correctly)
        Plot[][] p = new Plot[4][3];
        ExperimentalFarm experimentalFarm = new ExperimentalFarm(p);
        Plot highestCrop = experimentalFarm.getHighestYield("corn");
        System.out.println(highestCrop.getCropType());
        System.out.println(highestCrop.getCropYield());

       boolean col0Result = experimentalFarm.sameCrop(0);
       System.out.println(col0Result);
       boolean col1Result = experimentalFarm.sameCrop(1);
       System.out.println(col1Result);
    }
}