package Unit7.Andrew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Andrew {
   public static void main(String[] args)
   {
       Username username = new Username("john","smith");
   }

}

class Username
{
    String[] array = {"smithj","smithjo"};
    private ArrayList<String> possiblenames;
    public Username(String Firstname, String Lastname)
    {
        possiblenames = new ArrayList<>();
            for (int i=0; i<Firstname.length(); i++)
            {
                String temp = Firstname.substring(0, i+1);
                possiblenames.add((Lastname+temp));
            }
            System.out.println(possiblenames);
            setAvailUsernames();
    }

    public boolean isUsed(String name)
    {
            return Arrays.asList(array).contains(name);
    }


    public void setAvailUsernames()
    {
        List<String> list =  possiblenames.stream().filter(this::isUsed).collect(Collectors.toList()); // two ways find used ones and remove from array list
        List<String> notusedNames = possiblenames.stream().filter(s -> !isUsed(s)).collect(Collectors.toList()); // or make a new list either way works
        notusedNames.forEach(System.out::println);
        list.forEach(s -> possiblenames.remove(s));
       System.out.println(possiblenames);
    }



}

