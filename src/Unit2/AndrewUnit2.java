package Unit2;
import java.util.*;
import java.math.*;
public class AndrewUnit2 {

  public static void main(String[] args)
  {
    LightSequence gradShow = new LightSequence("0101 0101 0101");
    gradShow.display();
    gradShow.changeSequence("0011 0011 0011");
    String resultSeq = gradShow.insertSegment("1111 1111",4);
    System.out.println(resultSeq);
    gradShow.remove(gradShow.seq, "01");
    System.out.println(gradShow.seq);
    System.out.println(gradShow.newSeq);
    System.out.println(gradShow.seq);
    gradShow.printStraightline(4.0,2.0);
  }

  
}

class LightSequence

{
  String seq;
  String newSeq;


public LightSequence(String seq)
{
  this.seq = seq;
}

public String insertSegment(String segment, int ind)

{ // implementation not shown
          String local = this.seq;
          String temp = local.substring(0,ind);
          local = temp.concat(segment+local);
    return local;
  }



public void changeSequence(String seq)

{ // implementation not shown
}
public void display()
{
  System.out.println(seq);
}
public void remove(String oldSeq, String segment)
{
int start = oldSeq.indexOf(segment);
if (start!=-1)
{
//this.newSeq = oldSeq.substring(start,start+segment.length()); if you want the removed section
  this.newSeq = oldSeq.substring(0,start);
  this.newSeq = this.newSeq.concat(oldSeq.substring(start+segment.length()));

}
else
{
System.out.println("sorry substring wasn't found in the original string");
}
  return;
}
  //double a vertical
//double b horizontal
public void printStraightline(double a, double b)
{
double display = Math.sqrt(((Math.pow(a,2))+(Math.pow(b,2))));
System.out.println("The straight line distance is: "+display);
}
}
