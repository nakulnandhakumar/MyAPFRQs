package Unit8.Andrew;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Andrew {
}
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
    public Plot getHighestYield(String c) {

        ArrayList<Plot> po = new ArrayList<>();
        for (Plot[] plots : this.farmPlots)
        {
            po.addAll(Arrays.asList(plots));
        }
        return  po.stream().filter(plot -> plot.getCropType().equals(c)).max(Comparator.comparing(Plot::getCropYield)).orElse(null);

    }
    public Plot getHighestYeildForloop(String c)
    {
        AbstractMap.SimpleEntry<Integer,Integer> index = null;
        String cropType = c;
        int max = 0;
        for (int i = 0; i<this.farmPlots.length; i++)
        {
          for (int j = 0; j<this.farmPlots[i].length; j++)
          {
              if (farmPlots[i][j].getCropType().equals(cropType))
              {
                  if (farmPlots[i][j].getCropYield()>max)
                  {
                      max = farmPlots[i][j].getCropYield();
                      index = new AbstractMap.SimpleEntry<>(i,j);

                  }
              }
          }
        }
            assert index != null;
            return farmPlots[index.getKey()][index.getValue()];
    }
    public Boolean sameRow(int col)
    {
        int row = 0;
        String prev = "";
        for (Plot[] r : this.farmPlots)
        {
            if (row == 0)
            {
                prev = r[col].getCropType();
                row++;
                continue;
            }
            else
            {
                if (!r[col].getCropType().equals(prev))
                {
                    return false;
                }
            }
            row++;
        }
        return true;
    }



}
/*
 ArrayList<Plot> po = new ArrayList<>();
  for (Plot[] plots : this.farmPlots)
  {
      po.addAll(Arrays.asList(plots));
  }
return  po.stream().filter(plot -> plot.getCropType().equals(c)).max(Comparator.comparing(Plot::getCropYield)).orElse(null);
 */