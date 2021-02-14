package Unit9.NakulPackage;

import java.util.ArrayList;

public class Nakul {
}

/** QUESTION #1 **/

/** The following Book class is used to represent books and print information about each book.
 * Each Book object has attributes for the book title and for the name of the book’s author. **/
class Book {
    private String title;
    private String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public void printBookInfo() {
        System.out.print(title + ", written by " + author);
    }

}
/** (a) The PictureBook class is a subclass of the Book class that has one additional attribute: a String variable named
 * illustrator that is used to represent the name of the illustrator of a picture book.
 * The PictureBook class also contains a printBookInfo method to print the title, writer, and illustrator of a picture book. **/
 class PictureBook extends Book {
    private String illustrator;  // New variable for illustrator

    public PictureBook(String t, String a, String i) {
        super(t, a); // Calls the constructor in parent class to initialize title and author
        illustrator = i; // Constructor initializes illustrator variable
    }

    @Override
    public void printBookInfo() {
        super.printBookInfo();  // Calls the print method in superclass in print title and author
        System.out.print(" and illustrated by "+illustrator);  // Prints the illustrator right after
    }
}

/** Consider the following books:
 * A book titled Frankenstein, written by Mary Shelley
 * A picture book titled The Wonderful Wizard of Oz, written by L. Frank Baum and illustrated by W.W. Denslow **/
 class Implementation {

     public Implementation(){ // Default constructor

     }
/** (b) Write a code segment that can be used to replace "missing code" so that book1 and book2 will be correctly
 * created and added to myLibrary. Assume that class PictureBook works as intended, regardless of what you
 * wrote in part (a). **/
    public static void main(String[] args) {
        ArrayList<Book> myLibrary = new ArrayList<Book>();  // Arraylist for storing books and picture books

        // Missing Code
        Book book1 = new Book("Frankenstein", "Mary Shelley"); // Initializing regular book
        Book book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow"); // Initializing picture book with type book but using picture book and book class constructor. Polymorphism.
        // End of missing code

        myLibrary.add(book1);
        myLibrary.add(book2);

        for (Book book : myLibrary){  // Implementation to see if code works and it does
            book.printBookInfo();
            System.out.println("");
        }

        /** IMPLEMENTATION FOR PART C **/
        BookListing listing1 = new BookListing(book1, 10.99);
        listing1.printDescription();

        BookListing listing2 = new BookListing(book2, 12.99);
        listing2.printDescription();

        // Implementation for part c prints out the correct method
    }
}

/** The BookListing class is used to generate a descriptive listing for a book.
 * The BookListing constructor takes a Book object and a double value as
 * parameters and uses them to print information about the book, along with its price.
 * Assume that book1 and book2 were created as specified in part (b).
 * The following table demonstrates the intended behavior of the BookListing class using objects book1 and book2. **/

/** (c) Complete the BookListing class below.
 * Your implementation should conform to the examples.
 * Assume that class PictureBook works as intended, regardless of what you wrote in part (a). **/

class BookListing {
    private double price;  // Variable for storing price
    private Book book;  // Variable for storing book object

    public BookListing(Book b, double p){  // Constructor to initialize book and price variables
        price = p;
        book = b;
    }

    public void printDescription(){
        book.printBookInfo();  // Prints info about book regardless of it being a picture book or a book
        System.out.println(", $"+price); // Prints the price
    }

    /** FOR IMPLEMENTATION SEE ABOVE IMPLEMENTATION CLASS **/
}


/** QUESTION 2 **/

/** A set of classes using inheritance is used to represent animals observed at a wildlife sanctuary.

All Animal objects have the following attributes:
 * A String variable indicating whether the animal is a carnivore or a herbivore
 * A String variable representing the animal species (e.g., lion, giraffe, zebra)
 * A String variable representing the name of the individual animal (e.g., Lisa, Gary, Percy)
 * The Animal class also contains a toString method that indicates the state of an animal. **/

class Animal {
    private String type;
    private String species;
    private String name;

    public Animal(String t, String s, String n) { // Initializing all animal instance variables through constructor
        type = t;
        species = s;
        name = n;
    }

    @Override
    public String toString() {  // toString method overrides previous toString method.
        return name+" the "+species+" is a "+type;
    }

    public static void main(String[] args) {
        Animal lisa = new Animal("carnivore", "lion", "Lisa"); // Creating lisa the lion is a carnivore
        System.out.println(lisa.toString()); // Correctly prints lisa the lion
    }
}

/** The Herbivore class is a subclass of Animal.
 * The Herbivore class does not contain any attributes or methods other than those found in the Animal class.
 * The constructor to the Herbivore class accepts two parameters for the species and name of the herbivore.
 * The constructor passes those parameters along with the string literal "herbivore" to the Animal class to construct the object. **/

/** (b)  Write the complete Herbivore class.
 * Your implementation must meet all specifications and conform to the behavior shown in the table. **/
class Herbivore extends Animal{

    public Herbivore(String s, String n){  // Constructor takes parameters and passes them to superclass with type
        super("herbivore", s, n);
    }

    public static void main(String[] args) {  // Implementation shows code works exactly as it is supposed to
        Herbivore gary = new Herbivore("giraffe", "Gary");  // Creating herbivore class object
        System.out.println(gary.toString());  // Calling toString which calls toString method of superclass
    }
}

/** The Elephant class is a subclass of Herbivore.
 * The Elephant class contains one additional attribute not found in Herbivore: a double variable representing
 * the length of the elephant’s tusks, in meters.
 * The constructor to the Elephant class accepts two parameters for the name and tusk length of the elephant.
 * The constructor passes those parameters along with the string literal "elephant" to the Herbivore class to
 * construct the object. **/

/** (c)   Write the complete Elephant class.
 * Your implementation must meet all specifications and conform to the behavior shown in the table. **/

class Elephant extends Herbivore{
    private double tuskLength; // tusklength variable

    public Elephant(String n, double tl){
        super("elephant", n);  // calls superclass constructor which calls animal constructor
        tuskLength = tl; // initializes tusklength
    }

    @Override
    public String toString() { // Overrides the superclass toString (Animal class toString)
        return super.toString() + " with tusks "+tuskLength+" meters long";
        // Calls Animal class toString for initial part of return message and then returns the rest of required message
    }

    public static void main(String[] args) { // Implementation shows that code works.
        Elephant percy = new Elephant("Percy", 2.0);
        System.out.println(percy.toString());
    }
}