package Unit4.Andrew;


import java.util.Random;

public class Andrew {
    public static void main(String[] args) {
        LongStreak longStreak = new LongStreak("CCAAAAATTT!"); // given test case CCAAAAATTT!
        CoinGame coinGame = new CoinGame(10,5);

    }
}

class LongStreak
{
    String streak;
    int lastsum;
    char index;
    LongStreak(String pass)
    {
        this.streak = pass;
        Consecutive();
        Driver();
    }
    private void Driver() //driver for the recurisve loop
    {
        index =' ';
        lastsum=0;
        int postion =0;
        int currentsum = 1;
        Rec(streak.length(),postion,currentsum);
        System.out.println(lastsum + " " + index);
    }

    private void Rec(int length , int position , int currentsum) // recursive
    {
        if (length == 1) // base case exit at last index
        {
            return; //exits
        }
        if (streak.charAt(position)==streak.charAt(position+1)) // compares the two positions
        {
            currentsum++;
            if (currentsum>lastsum) //checks if current sum is greater than last sum if so setts the char at the current index
            {
                index = streak.charAt(position); //global var
            }
        }
        else
        {
            currentsum=1; //resets counter
        }
        lastsum = Math.max(currentsum, lastsum); // gobal var
        Rec(length-1, position+1, currentsum); // recursive loop
    }

    private void Consecutive() //iterative
    {
        int currentsum= 1;
        int prevsum =0;
        char index = ' '; // set to a space character, use '' for chars
        for (int i=0; i<streak.length()-1;i++) //breaks when it reaches the last index
        {
            if (streak.charAt(i) == streak.charAt(i+1)) // breaks the string into chars, the == works like boolean case instead of an int return
            {
                currentsum++; // if true it adds one to the currentsum
                if (prevsum<currentsum) // this checks if the prev sum is less then current sum and figures out what character it should print at the end
                {
                    index=  streak.charAt(i); // sets the char to the current index
                }
            }
            else
            {
                currentsum=1; // reset the current sum to one to represent a single character
            }
            prevsum = Math.max(currentsum,prevsum); // use a in built function to see if prevsum is greater than currentsum, if current sum is greater it sets prev sum to the current sum
        }
        System.out.println(prevsum +" "+  index ); //prevsum is always going to be larger than currentsum or equal to it so i just print prev sum at the end
    }

}

class CoinGame
{

    private int startingCoins; // starting number of coins

    private int maxRounds; // maximum number of rounds played



    public CoinGame(int s, int r) // constructor provided  by collage board
    {
        startingCoins = s;
        maxRounds = r;
        playGame();
    }



    /** Returns the number of coins (1, 2, or 3) that player 1 will spend.

     */

    public int getPlayer1Move()

    {

        Random random = new Random(System.currentTimeMillis()/20); // creates a random instance with the seed of time dived by fix number

        /* implementation not shown. */
        return random.nextInt(3)+1; //returns an int from 0-2 +1

    }



    /** Returns the number of coins (1, 2, or 3) that player 2 will spend, as described in part (a).
     * @param round int value that represent the current round
     */
    public int getPlayer2Move(int round)
    {

        /* to be implemented in part (a) */
        if (round%3==0) // conditions provided  by collage board
        {
            return 3;
        }
        else if(round%2==0)
        {
            return 2;
        }
        else //default case
            return 1;

    }



    /** Plays a simulated game between two players, as described in part (b).

     */

    public void playGame()

    {
        int player1coins = startingCoins; //local vars used to track player coins
        int player2coins = startingCoins;
        for (int i =1; i<=maxRounds; i++)
        {
            if (player1coins<3) //end conditions for both players
            {
                break;
            }
            if (player2coins<3)
            {
                break;
            }

            int player1move = getPlayer1Move(); // gets the return of the player
            int player2move = getPlayer2Move(i); // needs the game round to figure out return
            if (Math.abs((player1move-player2move))==0) // dont need the abs but too lazy to remove it
            {
                player1coins-= player1move;
                player2coins-=player2move-1;
            }
            else if (Math.abs(player1move-player2move)==1) // abs need to figure out the relative difference between the two values
            {
                player1coins-=player1move;
                player2coins-=player2move-1;
            }
            else //default case
            {
                player1coins-=player1move-2;
                player2coins-=player2move;
            }
        }
        if (player1coins>player2coins) //win condition
        {
            System.out.println("player one wins");
        }
        if (player2coins>player1coins) // win condition
        {
            System.out.println("player two wins");
        }
        else if (player2coins==player1coins)
        {
            System.out.println("tie game");
        }
        /* to be implemented in part (b) */

    }

}



