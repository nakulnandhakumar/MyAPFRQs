package Unit9.AndrewPackage;

import java.util.ArrayList;


/*
A book titled Frankenstein, written by Mary Shelley
A picture book titled The Wonderful Wizard of Oz, written by L. Frank Baum and illustrated by W.W. Denslow
 */
public class Andrew {
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        ArrayList<Book> mylibary = new ArrayList<>();
        Book book1 = new Book("Frankenstein","Mary Shelley");
        PictureBook book2 = new PictureBook("The Wonderful Wizard of Oz","L. Frank Baum","W.W. Denslow");
        mylibary.add(book1);
        mylibary.add(book2);
        mylibary.forEach(Book::printBookInfo);
        Listing listing = new Listing(book1,10.92);
        listing.PrintInfo();
        listing= new Listing(book2,10.99);
        listing.PrintInfo();
        Herbivore herbivore = new Herbivore("donkey","gary");
        Elephant herbivore1 = new Elephant("name",2.0);
        System.out.println(herbivore1);


    }

}
class Book

{
    private String title;
    private String author;
    public Book(String t, String a)
    {
        title = t;
        author = a;

    }
    public void printBookInfo()
    {
        System.out.print(title + ", written by " + author);
    }
}
class PictureBook extends Book
{
    private String illustator;

    public PictureBook(String t, String a, String illustator) {
        super(t, a);
        this.illustator = illustator;
    }

    @Override
    public void printBookInfo() {
        super.printBookInfo();
        System.out.println(" and illustrated by " + illustator);
    }
}

class Listing
{
    private Book book;
    private double price;
    public Listing(Book book, double price)
    {
        this.book= book;
        this.price = price;
    }
    public void PrintInfo()
    {
        book.printBookInfo();
        System.out.println(", " + price);

    }


}

class Animal {
    String Name;
    String Species;
    String Diet;
    public Animal(String name, String species, String diet)
    {
        this.Name = name;
        this.Diet = diet;
        this.Species = species;
    }

    @Override
    public String toString() {
        return String.format("%s the %s is a %s",Name,Species,Diet);
    }
}

class Herbivore extends Animal
{

    public Herbivore(String species, String name ) {
        super(name, species,"herbivore");
    }
}

class Elephant extends Herbivore
{
    public double tusklen;
    public Elephant(String name,double tusklen)
    {
        super("Elephant",name);
        this.tusklen= tusklen;


    }
    @Override
    public String toString()
    {
        return super.toString().concat(" with tusk "+tusklen+" meters long");
    }

}


