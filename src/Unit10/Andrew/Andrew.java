package Unit10.Andrew;

public class Andrew {


}

class Numbers
{
    public static int gcf(int a, int b)
    {

        if (a%b==0) // division is clean
        {
            return b;
        }
        else
        {
            return gcf(b,a%b); // wording of problem sounds like b should go first then a
        }


    }

    public static void reduceFraction(int num, int dom)
    {
            int reducer = gcf(num, dom);
            num/=reducer;
            dom/=reducer;
            if (num%dom == 0)
            {
                System.out.println(num/dom);
            }
            else
                System.out.println(num+"/"+dom);

    }

    public static void main(String[] args)
    {
        System.out.println(gcf(3,7));
        reduceFraction(3,9);
    }

}
