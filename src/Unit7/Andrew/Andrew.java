package Unit7.Andrew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Andrew {
   public static void main(String[] args)
   {
       Username username = new Username("john","smith");
       String[] strings = {"smithj","smithjo"};
       username.setAvailUsernames(strings);
       username.SetavailUsernamesTradtional();
   }



}

class Username
{
    String[] array = {"smithj","smithjo"}; // tester
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
    public void setAvailUsernames(String[] usednames)
    {
        List<String> list = possiblenames.stream().filter(s-> Arrays.stream(usednames).noneMatch(Predicate.isEqual(s))).collect(Collectors.toList());
        possiblenames = (ArrayList<String>) list;
        System.out.println(possiblenames);
    }
    public void SetavailUsernamesTradtional()
    {
        ListIterator<String> listIterator = possiblenames.listIterator();
        while (listIterator.hasNext())
        {
            if (isUsed(listIterator.next()))
            {
                listIterator.remove();
            }
        }
        System.out.println(possiblenames);

    }





}

