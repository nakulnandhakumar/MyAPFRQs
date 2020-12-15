package Unit2;

public class Andrew { 
  LightSequence gradShow = new LightSequence("0101 0101 0101");
  gradShow.display();
  gradShow.changeSequence("0011 0011 0011");
  String resultSeq = gradShow.insertSegment("1111 1111",4);
  
}

class LightSequence

{

// attributes not shown

/** The parameter seq is the initial sequence used for

the light display
*/

public LightSequence(String seq)

{ // implementation not shown // }

/** Inserts the string segment in the current sequence,

starting at the index ind. Returns the new sequence.
*/

public String insertSegment(String segment, int ind)

{ // implementation not shown // }

/** Updates the sequence to the value in seq

*/

public void changeSequence(String seq)

{ // implementation not shown // }

/** Uses the current sequence to turn the light on and off

for the show
*/

public void display()

{ / implementation not shown / }
public void String remove(String oldSeq, String segment)
{
int start = oldSeq.indexOf(segment);
If(start!=-1)
{
this.newSeq = oldSeq.substring(start,segment.length()+start);
return;
}
else
{
System.out.println("sorry substring wasnt found in the orginal string");
return;
}
}
  //double a vertical
//double b horizontal
public void printStraight-line(double a, double b)
{
double display = Math.sqrt(((Math.pow(a,2))+(Math.pow(b,2))))
System.out.println("The straight line distance is: "+display);
}
}
