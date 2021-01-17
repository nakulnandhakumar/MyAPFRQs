package Unit6;

public class Nakul {
}


/** QUESTION #1 **/

/**
 * An array of String objects, words, has been properly declared and initialized.
 * Each element of words contains a String consisting of lowercase letters (a–z).
 * Write a code segment that uses an enhanced for loop to print all elements of words that end with "ing".
 * As an example, if words contains {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"}, then the following output should be produced by the code segment:

 fading
 trailing
 batting

 * Write the code segment as described above. The code segment must use an enhanced for loop to earn full credit. **/

class Ing {
    String[] words;
    int lengthOfWord;

    public Ing(String[] arr){
        words = arr;
    }

    public void printWordsEndingInIng(){
        for (String word: words){
            lengthOfWord = word.length();

            if (lengthOfWord < 3){
                continue;
            }
            if (word.substring(lengthOfWord - 3).equals("ing")){
                System.out.println(word);
            }
        }
    }

    public static void main(String[] args){
        String[] arrOfStrings = {"a", "run", "strike", "man", "coming", "dude", "mistering", "through", "sipping", "listening"};
        Ing ing = new Ing(arrOfStrings);
        ing.printWordsEndingInIng();
    }
}