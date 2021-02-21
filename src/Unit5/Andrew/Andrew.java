package Unit5.Andrew;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Andrew {
    public static void main(String[] args)
    {
        Invitation invitation = new Invitation("andrew", "123 billboard");
        System.out.println(invitation.getHostName());
        invitation.updateAdresss("123 notbillboard");
        System.out.println(invitation.greating("Void"));
        PasswordGenerator gen1 = new PasswordGenerator("pre", 6);
        gen1.genPass();
        gen1.lamdba();
        PasswordGenerator gen2 = new PasswordGenerator(6);
        gen2.Driver();
        System.out.println(gen1.getCount() + " " + gen2.getCount());
        gen1.printAllPasswords();
        gen2.printAllPasswords();

    }


}
class Invitation

{

    private String hostName;

    private String address;



    public Invitation(String n, String a)
    {

        hostName = n;
        address = a;

    }

    public String getHostName() {
        return hostName;
    }
    public void updateAdresss(String newadress)
    {
        this.address = newadress;
    }
    //Dear Cheryl, please attend my event at 1234 Walnut Street. See you
    //then, Karen.
    public String greating(String name)
    {
        return "Dear "+name+", please attend my event at "+this.address+". See you then, "+ this.hostName;
    }

    public Invitation(String address)
    {
        this.address = address;
        hostName = "Host";

    }

}

class PasswordGenerator
{
   static private ArrayList<String> arrayOfPasswords = new ArrayList<>();
    String prefix;
    int length;
    public PasswordGenerator(int length)
    {
            this.length = length;
            prefix = "A.";


    }
    public PasswordGenerator(String prefix, int length)
    {
            this.prefix = prefix+".";
            this.length = length;

    }
    public void genPass()
    {
        String password = prefix;
      Random random = new Random(System.nanoTime());
        for (int i = 0; i <length ; i++) {
             password = password.concat(String.valueOf(random.nextInt(10)));
        }
        arrayOfPasswords.add(password);

    }
    public void lamdba()
    {
        // string = prevsting makes a new string
        final String[] password = {prefix}; // one assume that this should not be pass by reference
        IntStream intStream= new Random().ints(length,0,10);
        intStream.forEach(num -> password[0] = password[0].concat(String.valueOf(num)));
        arrayOfPasswords.add(password[0]);

    }
    private void recursive(int length , String password)
    {
        if (length == 0)
        {
            arrayOfPasswords.add(password);
            return;
        }
        Random rand = new Random();
        password = password.concat(String.valueOf(rand.nextInt(10)));
        recursive(--length, password);
    }
    public void Driver()
    {
        int local = this.length;
        String password = prefix;
        recursive(local,password);
    }

    public int getCount() {
        return arrayOfPasswords.size();
    }
    public void printAllPasswords()
    {
        arrayOfPasswords.forEach(System.out::println);
    }

}
