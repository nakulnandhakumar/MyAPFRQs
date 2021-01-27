package Unit6.AndrewPackage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Andrew {
    public static void main(String[] args)
    {
        Ing ing = new Ing();
        ing.printerJava();
        ing.printerMadeByme();
        ing.lambda();
    }

}
class Ing
{
   String[] strings= {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
   public Ing()
   {

   }
   public void printerJava()
   {
       for (String string : strings)
       {
                if (string.endsWith("ing"))
                {
                    System.out.println(string);
                }
       }
   }
   public void printerMadeByme()
   {
       int counter =0;
       char[] searchby = {'g','n','i'};
       for (String string : strings)
       {
           for (int i = string.length()-1; i>=string.length()-3; i--)
           {
               if (string.charAt(i)==searchby[counter])
               {
                   counter++;
               }
               else
                   break;
           }
           if (counter ==3)
           {
               System.out.println(string);
           }
           counter = 0;
       }
   }

   public void lambda()
   {
     List<String> allstrings =  Arrays.stream(strings).filter(s -> s.endsWith("ing")).collect(Collectors.toList());
     Arrays.stream(strings).filter(s -> s.endsWith("ing")).forEach(System.out::println);
     allstrings.forEach(System.out::println);
   }




}


class PayRoll
{
    private int[] itemsSold; // number of items sold by each employee

    private double[] wages; // wages to be computed in part (b)



    /** Returns the bonus threshold as described in part (a).

     */

    public double computeBonusThreshold()
    {

        /* To be implemented in part (a) */
        int min =itemsSold[0]; // assures us that at least one of the values is accounted for
        int max =0; // max can be zero tho
        int total = 0;
        for (int x : itemsSold)
        {
            total+=x;
            if (x>max)
            {
                max =x;
            }
            if (x<min)
            {
                min =x;
            }
        }

            return (double)(total-min-max)/(itemsSold.length-2);
    }



    /** Computes employee wages as described in part (b)

     * and stores them in wages.

     * The parameter fixedWage represents the fixed amount each employee

     * is paid per day.

     * The parameter perItemWage represents the amount each employee

     * is paid per item sold.

     */

    public void computeWages(double fixedWage, double perItemWage)

    {
        double threshold = computeBonusThreshold();

        for (int i = 0; i <itemsSold.length ; i++) {
            if (itemsSold[i]>threshold)
            {
                wages[i] = (fixedWage+(itemsSold[i]*perItemWage))*1.1;
            }
            else
            {
                wages[i] = fixedWage+(itemsSold[i]*perItemWage);
            }

        }
        System.out.println(Arrays.toString(wages));
        /* To be implemented in part (b) */

    }
}

